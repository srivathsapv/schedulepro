package SMS;

/*
 * 
 * @author : Sasi Praveen
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Sender implements Runnable {

    public static String recipient = null;
    public static String message = null;
    private String csca = null; // the message center
    private SerialParameters defaultParameters = new SerialParameters(SetPortForm.getPort(), 9600, 0, 0, 8, 1, 0);
    private boolean flag = false;
    public static boolean send_reply = false;

   Sender(){
        try {
            SerialConnection intSerial = new SerialConnection(defaultParameters);
             String result = "";
             intSerial.openConnection();
             intSerial.send("AT+CSCA?");
             result = intSerial.getIncommingString();
             while (result.equals("")) {
                 result = intSerial.getIncommingString();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Error");
                }
             }
             intSerial.closeConnection();
             String[] recieved = result.split("\"");
             csca = recieved[1];
             //System.out.println(csca);
        } catch (SerialConnectionException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error");
        }
   }
    
    public void run() {
        String current_time = "";
        String time = "10:29";
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        current_time = dateFormat1.format(cal.getTime());

        while (true) {
            while (!(current_time.equals(time) || send_reply)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                }
                cal = Calendar.getInstance();
                current_time = dateFormat1.format(cal.getTime());
                flag = true;
                //System.out.println(current_time);
            }
            if (flag) {
                Reciever.lock = true;
                Reciever.stopConnection();
                try {
                    send();
                } catch (SerialConnectionException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Error");
                }
                send_reply = false;
                Reciever.startConnection();
                Reciever.lock = false;
                if (!send_reply) {
                    //new time code
                }
            }
        }
    }

    private void send() throws SerialConnectionException {

        final long STANDARD = 500;
        long LONG = 2000;
        final long VERYLONG = 20000;
        SerialConnection mySerial = null;
        final char cntrlZ = (char) 26;
        String in, out;
        Thread aThread = null;
        long delay = STANDARD;
        int step = 0;
        int status = -1;
        long messageNo = -1;

        System.out.println("Sending");
        SerialParameters params = defaultParameters;

        mySerial = new SerialConnection(params);

        mySerial.openConnection();

        boolean timeOut = false;
        long startTime = (new Date()).getTime();



        while ((step < 7) && (!timeOut)) {
//      log(""+((new Date()).getTime() - startTime);
            //check where we are in specified delay
            timeOut = ((new Date()).getTime() - startTime) > delay;

            //if atz does not work, type to send cntrlZ and retry, in case a message was stuck
            if (timeOut && (step == 1)) {
                step = -1;
                mySerial.send("" + cntrlZ);
            }

            //read incoming string
            String result = mySerial.getIncommingString();

//    log ("<- "+result+"\n--------");
            int expectedResult = -1;

            try {
                //log ("Step:"+step);

                switch (step) {
                    case 0:

                        mySerial.send("atz");
                        delay = LONG;
                        startTime = (new Date()).getTime();
                        break;

                    case 1:
                        delay = STANDARD;
                        mySerial.send("ath0");
                        startTime = (new Date()).getTime();
                        break;
                    case 2:
                        expectedResult = result.indexOf("OK");

                        //log ("received ok ="+expectedResult);
                        if (expectedResult > -1) {
                            mySerial.send("at+cmgf=1");
                            startTime = (new Date()).getTime();
                        } else {
                            step = step - 1;
                        }
                        break;
                    case 3:
                        expectedResult = result.indexOf("OK");

                        // log ("received ok ="+expectedResult);
                        if (expectedResult > -1) {
                            mySerial.send("at+csca=\"" + csca + "\"");
                            startTime = (new Date()).getTime();
                        } else {
                            step = step - 1;
                        }

                        break;
                    case 4:
                        expectedResult = result.indexOf("OK");

                        // log ("received ok ="+expectedResult);
                        if (expectedResult > -1) {
                            mySerial.send("at+cmgs=\"" + recipient + "\"");
                            startTime = (new Date()).getTime();
                        } else {
                            step = step - 1;
                        }

                        break;
                    case 5:
                        expectedResult = result.indexOf(">");

                        // log ("received ok ="+expectedResult);
                        if (expectedResult > -1) {
                            mySerial.send(message + cntrlZ);
                            startTime = (new Date()).getTime();
                        } else {
                            step = step - 1;
                        }
                        delay = VERYLONG;//waitning for message ack

                        break;

                    case 6:
                        expectedResult = result.indexOf("OK");
                        //read message number
                        if (expectedResult > -1) {
                            int n = result.indexOf("CMGS:");
                            result = result.substring(n + 5);
                            n = result.indexOf("\n");
                            status = 0;
                            messageNo = Long.parseLong(result.substring(0, n).trim());

                            log("sent message no:" + messageNo);


                        } else {
                            step = step - 1;
                        }

                        break;
                }
                step = step + 1;

                aThread.sleep(100);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mySerial.closeConnection();
        flag = false;

        System.out.println("sent");
        //if timed out set status

        if (timeOut) {
            status = -2;
            log("*** time out at step " + step + "***");
        }
    }

    /**
     * logging function, includes date and class name
     */
    private void log(String s) {
        System.out.println(new java.util.Date() + ":" + this.getClass().getName() + ":" + s);
    }
}