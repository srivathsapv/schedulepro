/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class Validation {
    //Returns true if string contains only character words and has one space betwwen each word;
    public static boolean isStringWithSpace(String input)
    {
        return input.matches("(([a-zA-Z])+(\\s)?)+");
    }
    //Return true if it is all numbers 
    public static boolean isNumber(String input)
    {
        return input.matches("[0-9]+");
    }
    //Returns true if the number is 10digits in length
    public static boolean isPhoneNumber(String input)
    {
        return input.matches("[0-9]{10}");
    }
    //Return true if it is a vaild email-id
    public static boolean isEmailId(String input)
    {
        return input.matches("(\\W*\\w+\\W*)*[@]\\w+[.]\\w+");
    }
    //Returns true if it is a valid username (i.e.) a single word with any letter,digit or special characters
    public static boolean isUsername(String input)
    {
        return input.matches("\\W*\\w+\\W*");
    }
    //Returns true if thr password length is between 6 and 16
    public static boolean isPassword(String input)
    {
        return input.matches("[\\W*\\w*]{6,16}");
    }
    public static boolean isalphanumeric(String input)
    {
        return input.matches("([a-zA-Z0-9])+");
    }
    public static boolean isalphanumericOrNull(String input)
    {
        return input.matches("([a-zA-Z0-9])*");
    }
    public static boolean isValidDate(int day,int month,int year){
        
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day > 31) return false;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day > 30) return false;
                break;
            case 2:
                if(year % 4 == 0 && day > 29) return false;
                else if(day > 28) return false;
                break;
        }
        return true;
    }
}

