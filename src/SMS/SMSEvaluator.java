package SMS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class SMSEvaluator {
   /* public static void main(String args[]) throws ParseException{
        Evaluate("+919176109911","NXT");
        System.out.println(replymessage);
    }*/
    public static String replymessage = "Invalid request";

    public static void Evaluate(String Sender, String Message) throws ParseException {
        if (Message.contains("EQR")) {
            String[] input = Message.split(" ");
            String SMSidentifier = input[1];
            String date = input[2];
            String[] params = date.split("/");
            int d = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int y = Integer.parseInt(params[2]);

            Calendar cl = Calendar.getInstance();
            Date dt = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date dt1 = sf.parse(date);
            SimpleDateFormat sf2 = new SimpleDateFormat("EEEE");
            String day = sf2.format(dt1);
            System.out.println(day);
            int period_slot = Integer.parseInt(input[3]);
            String dbdate = y + "-" + m + "-" + d;

            ResultSet user_rs = Utilfunctions.executeQuery("select userCode from user where CONCAt('+91',phone)='" + Sender + "'");
            try {
                if (user_rs.next()) {
                    ResultSet period_rs = Utilfunctions.executeQuery("select pconfigId from periodconfig where pconfigId IN (select pconfigId from "
                            + "staffperiod where userCode ='" + user_rs.getString(1) + "') and day ='" + day + "' order by timeFrom limit " + (period_slot - 1) + ",1");
                    period_rs.next();
                    ResultSet class_rs = Utilfunctions.executeQuery("select classCode from staffperiod where pconfigId=" + period_rs.getString(1) + " and userCode='" + user_rs.getString(1) + "'");
                    class_rs.next();
                    ResultSet equipid_rs = Utilfunctions.executeQuery("select equipId from equipment where SMSid='" + SMSidentifier.toUpperCase() + "'");
                    while (equipid_rs.next()) {
                        ResultSet check_rs = Utilfunctions.executeQuery("select * from equipmentissue where equipId=" + equipid_rs.getString(1) + " and issueStatus = 0 and issueDate='" + dbdate + "' and pconfigId=" + period_rs.getString(1));
                        if (check_rs.next()) {
                            replymessage = "Equipment already booked";
                            continue;
                        } else {
                            Utilfunctions.executeUpdate("INSERT INTO `equipmentissue`(`issueId`, `equipId`, `userCode`, `pconfigId`, `classCode`, `issueDate`, `issueStatus`) "
                                    + "VALUES (NULL,'" + equipid_rs.getString(1) + "','" + user_rs.getString(1) + "'," + period_rs.getString(1) + "," + class_rs.getString(1) + ",'" + dbdate + "',0)");
                            replymessage = "Equipment booked";
                            break;
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //Logger.getLogger(SMSEvaluator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Message.contains("NXT")) {
            DateFormat dateFormat = new SimpleDateFormat("EEEE");
            DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String day = dateFormat.format(cal.getTime());
            String current_time = dateFormat1.format(cal.getTime());
            ResultSet user_rs = Utilfunctions.executeQuery("select userCode from user where CONCAT('+91',phone)='" + Sender + "'");
            try {
                if (user_rs.next()) {
                    String query = "SELECT pconfigId,classCode FROM `staffperiod` WHERE userCode = '" + user_rs.getString(1) + "' and "
                            + "pconfigId IN (select pconfigId from periodconfig where day = '" + day + "' and "
                            + "timeFrom = ANY (select timeFrom from periodconfig where timeFrom > '" + current_time + "')) ORDER BY TIMEFROM(pconfigId) LIMIT 0,1";
                    ResultSet nxtperiod_rs = Utilfunctions.executeQuery(query);
                    if (nxtperiod_rs.next()) {
                        ResultSet class_rs = Utilfunctions.executeQuery("SELECT CONCAT(course,' ',dept,' ',year,' - ',section), roomId FROM class "
                                + "where classCode =" + nxtperiod_rs.getString(2));
                        class_rs.next();
                        //System.out.println("here");
                        ResultSet room_rs = Utilfunctions.executeQuery("select roomNo from classroom where roomId =" + class_rs.getString(2));
                        room_rs.next();
                        //System.out.println("here1");
                        ResultSet subject_rs = Utilfunctions.executeQuery("select subName from subject where subCode = (select subCode from classperiod"
                                + " where pconfigId =" + nxtperiod_rs.getString(1) + " and classCode =" + nxtperiod_rs.getString(2) + ")");
                        subject_rs.next();
                        //System.out.println("here2");
                        replymessage = "Class: " + class_rs.getString(1) + "     Subject: " + subject_rs.getString(1) + "    Room No: " + room_rs.getString(1);
                    } else {
                        replymessage = "Your session for today is over";
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //Logger.getLogger(SMSEvaluator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Message.contains("RESET")) {
            String[] input = Message.split(" ");
            String userCode = input[1];
            ResultSet check_rs = Utilfunctions.executeQuery("select * from user where userCode = '" + userCode + "' and CONCAT('+91',phone)='" + Sender + "'");
            try {
                if (check_rs.next()) {
                    String newPassword = Utilfunctions.randomStringGenerator(8);
                    replymessage = "Password Reset to "+newPassword;
                    try {
                        Utilfunctions.executeUpdate("UPDATE `login` SET `password`='" + Utilfunctions.MD5(newPassword).toString(16) + "' WHERE userCode = '" + userCode + "'");
                    } catch (NoSuchAlgorithmException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        //Logger.getLogger(SMSEvaluator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    replymessage ="Access Denied";
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //Logger.getLogger(SMSEvaluator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}