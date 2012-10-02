package SMS;

import javax.comm.*;
import java.io.*;
import java.awt.TextArea;
import java.awt.event.*;
import java.util.TooManyListenersException;
import javax.swing.JOptionPane;
//
/**
A class that handles the details of a serial connection. Reads from one
TextArea and writes to a second TextArea.
Holds the state of the connection.
*/
public class SerialConnection implements SerialPortEventListener,
					 CommPortOwnershipListener {
//    private SerialDemo parent;

/*    private TextArea messageAreaOut;
    private TextArea messageAreaIn;
    */

    private SerialParameters parameters;
    private OutputStream os;
    private InputStream is;
    private KeyHandler keyHandler;

    private CommPortIdentifier portId;
    private SerialPort sPort;

    private boolean open;

    private String receptionString="";

    public String getIncommingString(){
      byte[] bVal= receptionString.getBytes();
      receptionString="";
      return new String (bVal);
  }

    /**
    Creates a SerialConnection object and initilizes variables passed in
    as params.

    @param parent A SerialDemo object.
    @param parameters A SerialParameters object.
    @param messageAreaOut The TextArea that messages that are to be sent out
    of the serial port are entered into.
    @param messageAreaIn The TextArea that messages comming into the serial
    port are displayed on.
    */
    public SerialConnection(SerialParameters parameters) {
        this.parameters = parameters;
	open = false;
   }

   /**
   Attempts to open a serial connection and streams using the parameters
   in the SerialParameters object. If it is unsuccesfull at any step it
   returns the port to a closed state, throws a
   <code>SerialConnectionException</code>, and returns.

   Gives a timeout of 30 seconds on the portOpen to allow other applications
   to reliquish the port if have it open and no longer need it.
   */
   public void openConnection() throws SerialConnectionException {

       // System.out.println("OK 0 ");
	// Obtain a CommPortIdentifier object for the port you want to open.
        
	try {
           //System.out.println(parameters.getPortName());
	    portId = CommPortIdentifier.getPortIdentifier(parameters.getPortName());
	} catch (NoSuchPortException e) {
            JOptionPane.showMessageDialog(null, "Error");
           //System.out.println("Yes the problem is here 1 ");
            e.printStackTrace();
	   // throw new SerialConnectionException(e.getMessage());
	}catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Error");
          //  System.out.println("ErrorErrorErrorError");
            e.printStackTrace();
        }
        //System.out.println(portId);
        //System.out.println("OK 1 ");
	// Open the port represented by the CommPortIdentifier object. Give
	// the open call a relatively long timeout of 30 seconds to allow
	// a different application to reliquish the port if the user
	// wants to.
	try {
	    sPort = (SerialPort)portId.open("SMSConnector", 30000);
	} catch (PortInUseException e) {
            JOptionPane.showMessageDialog(null, "Error");
	    throw new SerialConnectionException(e.getMessage());
	}
        //System.out.println("OK 2 ");
        sPort.sendBreak(1000);

	// Set the parameters of the connection. If they won't set, close the
	// port before throwing an exception.
	try {
	    setConnectionParameters();
	} catch (SerialConnectionException e) {
            JOptionPane.showMessageDialog(null, "Error");
	    sPort.close();
	    throw e;
	}
       // System.out.println("OK 3 ");
	// Open the input and output streams for the connection. If they won't
	// open, close the port before throwing an exception.
	try {
	    os = sPort.getOutputStream();
	    is = sPort.getInputStream();
	} catch (IOException e) {
	    sPort.close();
	    throw new SerialConnectionException("Error opening i/o streams");
	}
//System.out.println("OK 4 ");
/*
	// Create a new KeyHandler to respond to key strokes in the
	// messageAreaOut. Add the KeyHandler as a keyListener to the
	// messageAreaOut.
	keyHandler = new KeyHandler(os);
	messageAreaOut.addKeyListener(keyHandler);
*/
	// Add this object as an event listener for the serial port.
	try {
	    sPort.addEventListener(this);
	} catch (TooManyListenersException e) {
	    sPort.close();
	    throw new SerialConnectionException("too many listeners added");
	}
//System.out.println("OK 5 ");
	// Set notifyOnDataAvailable to true to allow event driven input.
	sPort.notifyOnDataAvailable(true);

	// Set notifyOnBreakInterrup to allow event driven break handling.
	sPort.notifyOnBreakInterrupt(true);

	// Set receive timeout to allow breaking out of polling loop during
	// input handling.
	try {
	    sPort.enableReceiveTimeout(30);
	} catch (UnsupportedCommOperationException e) {
	}
//System.out.println("OK 6 ");
	// Add ownership listener to allow ownership event handling.
	portId.addPortOwnershipListener(this);

	open = true;
    }

    /**
    Sets the connection parameters to the setting in the parameters object.
    If set fails return the parameters object to origional settings and
    throw exception.
    */
    public void setConnectionParameters() throws SerialConnectionException {

	// Save state of parameters before trying a set.
	int oldBaudRate = sPort.getBaudRate();
	int oldDatabits = sPort.getDataBits();
	int oldStopbits = sPort.getStopBits();
	int oldParity   = sPort.getParity();
	int oldFlowControl = sPort.getFlowControlMode();

	// Set connection parameters, if set fails return parameters object
	// to original state.
	try {
	    sPort.setSerialPortParams(parameters.getBaudRate(),
				      parameters.getDatabits(),
				      parameters.getStopbits(),
				      parameters.getParity());
	} catch (UnsupportedCommOperationException e) {
            parameters.setBaudRate(oldBaudRate);
	    parameters.setDatabits(oldDatabits);
	    parameters.setStopbits(oldStopbits);
	    parameters.setParity(oldParity);
	    throw new SerialConnectionException("Unsupported parameter");
	}

	// Set flow control.
	try {
	    sPort.setFlowControlMode(parameters.getFlowControlIn()
			           | parameters.getFlowControlOut());
	} catch (UnsupportedCommOperationException e) {
            SetPortForm.jLabel5.setText("Error");
	    throw new SerialConnectionException("Unsupported flow control");
	}
    }

    /**
    Close the port and clean up associated elements.
    */
    public void closeConnection() {
	// If port is alread closed just return.
	if (!open) {
	    return;
	}

	// Remove the key listener.
//	messageAreaOut.removeKeyListener(keyHandler);

	// Check to make sure sPort has reference to avoid a NPE.
	if (sPort != null) {
	    try {
		// close the i/o streams.
	    	os.close();
	    	is.close();
	    } catch (IOException e) {
		System.err.println(e);
	    }

	    // Close the port.
	    sPort.close();

	    // Remove the ownership listener.
	    portId.removePortOwnershipListener(this);
	}

	open = false;
    }

    /**
    Send a one second break signal.
    */
    public void sendBreak() {
	sPort.sendBreak(1000);
    }

    /**
    Reports the open status of the port.
    @return true if port is open, false if port is closed.
    */
    public boolean isOpen() {
	return open;
    }

    /**
    Handles SerialPortEvents. The two types of SerialPortEvents that this
    program is registered to listen for are DATA_AVAILABLE and BI. During
    DATA_AVAILABLE the port buffer is read until it is drained, when no more
    data is availble and 30ms has passed the method returns. When a BI
    event occurs the words BREAK RECEIVED are written to the messageAreaIn.
    */

    public void serialEvent(SerialPortEvent e) {
 	// Create a StringBuffer and int to receive input data.
	StringBuffer inputBuffer = new StringBuffer();
	int newData = 0;

	// Determine type of event.

	switch (e.getEventType()) {

	    // Read data until -1 is returned. If \r is received substitute
	    // \n for correct newline handling.
	    case SerialPortEvent.DATA_AVAILABLE:
		    while (newData != -1) {
		    	try {
		    	    newData = is.read();
			    if (newData == -1) {
				break;
			    }
			    if ('\r' == (char)newData) {
			   	inputBuffer.append('\n');
			    } else {
			    	inputBuffer.append((char)newData);
			    }
		    	} catch (IOException ex) {
		    	    System.err.println(ex);
		    	    return;
		      	}
   		    }

		// Append received data to messageAreaIn.
		receptionString=receptionString+ (new String(inputBuffer));
                //System.out.print("<-"+receptionString);
		break;

	    // If break event append BREAK RECEIVED message.
	    case SerialPortEvent.BI:
		receptionString=receptionString+("\n--- BREAK RECEIVED ---\n");
	}

    }

    /**
    Handles ownership events. If a PORT_OWNERSHIP_REQUESTED event is
    received a dialog box is created asking the user if they are
    willing to give up the port. No action is taken on other types
    of ownership events.
    */
    public void ownershipChange(int type) {
      /*
	if (type == CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED) {
	    PortRequestedDialog prd = new PortRequestedDialog(parent);
	}
        */
    }

    /**
    A class to handle <code>KeyEvent</code>s generated by the messageAreaOut.
    When a <code>KeyEvent</code> occurs the <code>char</code> that is
    generated by the event is read, converted to an <code>int</code> and
    writen to the <code>OutputStream</code> for the port.
    */
    class KeyHandler extends KeyAdapter {
	OutputStream os;

	/**
	Creates the KeyHandler.
	@param os The OutputStream for the port.
	*/
	public KeyHandler(OutputStream os) {
	    super();
	    this.os = os;
	}

	/**
	Handles the KeyEvent.
	Gets the <code>char</char> generated by the <code>KeyEvent</code>,
	converts it to an <code>int</code>, writes it to the <code>
	OutputStream</code> for the port.
	*/
        public void keyTyped(KeyEvent evt) {
            char newCharacter = evt.getKeyChar();
            if ((int)newCharacter==10) newCharacter = '\r';
            System.out.println ((int)newCharacter);
	    try {
	    	os.write((int)newCharacter);
	    } catch (IOException e) {
		System.err.println("OutputStream write error: " + e);
	    }
        }
    }
        public void send(String message) {
            byte[] theBytes= (message+"\n").getBytes();
            for (int i=0; i<theBytes.length;i++){

              char newCharacter = (char)theBytes[i];
              if ((int)newCharacter==10) newCharacter = '\r';

	      try {
	    	os.write((int)newCharacter);
              } catch (IOException e) {
                  System.err.println("OutputStream write error: " + e);
              }

            }
            //System.out.println (">'" +message +"' sent");




        }
}
