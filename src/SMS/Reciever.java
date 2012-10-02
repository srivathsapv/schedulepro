package SMS;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sasi Praveen
 */
//
public class Reciever implements Runnable {

    private static final long STANDARD = 500;
    private static final long LONG = 2000;
    private static final long VERYLONG = 20000;
    private static final long VERYVERYLONG = 1000000;
    private static SerialConnection mySerial = null;
    static final private char cntrlZ = (char) 26;
    Thread aThread = null;
    private long delay = STANDARD;
    private SerialParameters defaultParameters = new SerialParameters(SetPortForm.getPort(), 9600, 0, 0, 8, 1, 0);
    private String final_message = "";
    public static boolean lock = false;
    private SerialParameters params = defaultParameters;

    Reciever() throws InterruptedException, SerialConnectionException {
        SerialConnection intSerial = new SerialConnection(params);
        String result = "";
        intSerial.openConnection();
        intSerial.send("atz");
        result = intSerial.getIncommingString();
        while (result.equals("")) {
            result = intSerial.getIncommingString();
            Thread.sleep(10);
        }
        //System.out.println(result);
        result = "";
        intSerial.send("ath0");
        result = intSerial.getIncommingString();
        while (result.equals("")) {
            result = intSerial.getIncommingString();
            Thread.sleep(10);
        }
        //System.out.println(result);
        result = "";
        intSerial.send("at+cpms=\"SM\"");
        while (result.equals("")) {
            result = intSerial.getIncommingString();
            Thread.sleep(10);
        }
        //System.out.println(result);
        result = "";
        intSerial.send("AT+CMGF=1");
        while (result.equals("")) {
            result = intSerial.getIncommingString();
            Thread.sleep(10);
        }
        //System.out.println(result);
        result = "";
        intSerial.send("AT+CMGD=0,4");
        while (result.equals("")) {
            result = intSerial.getIncommingString();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        //System.out.println(result);
        intSerial.closeConnection();
    }

    /**
     * connect to the port and start the dialogue th
     */
    public void run() {
        mySerial = new SerialConnection(params);
        startConnection();
        while (true) {
            while (!lock) {
                String in = mySerial.getIncommingString();
                if (in.contains("+CMTI")) {
                    System.out.println("Recieved");
                    String msg = "";
                    String delmsg = "";
                    mySerial.send("AT+CMGR=0");
                    while (msg.equals("")) {
                        msg = mySerial.getIncommingString();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Error");
                        }
                    }
                    //System.out.println(msg);
                    mySerial.send("AT+CMGD=0,4");
                    while (delmsg.equals("")) {
                        delmsg = mySerial.getIncommingString();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Error");
                        }
                    }
                    String[] recieved = msg.split("\"");
                    String sender = recieved[3];
                    System.out.println("Sender:" + sender);
                    recieved = msg.split("\n");
                    String message = recieved[5];
                    System.out.println("Message:" + message);
                    try {
                        SMSEvaluator.Evaluate(sender, message);
                    } catch (ParseException ex) {
                        Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error");
                    }
                    Sender.recipient = sender;
                    Sender.message = SMSEvaluator.replymessage;
                    Sender.send_reply = true;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error");
                }
            }
        }
    }

    public static void stopConnection() {
        mySerial.closeConnection();
    }

    public static void startConnection() {
        try {
            mySerial.openConnection();
        } catch (SerialConnectionException ex) {
            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error");
        }
        String intmsg = "";
        mySerial.send("at+cpms=\"SM\"");
        while (intmsg.equals("")) {
            intmsg = mySerial.getIncommingString();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    private void log(String s) {
        System.out.println(new java.util.Date() + ":" + this.getClass().getName() + ":" + s);
    }
}
