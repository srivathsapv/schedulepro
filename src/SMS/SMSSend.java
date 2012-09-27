package SMS;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sasi Praveen
 */
public class SMSSend {

    public static void main(String args[]) throws Exception { 
        Sender s = new Sender();
        Reciever r = new Reciever();
        Thread sThread = new Thread(s,"Sender");
        Thread rThread = new Thread(r,"Reciever");
        sThread.start();
        rThread.start();
    }
  
}
