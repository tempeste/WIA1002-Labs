/*
 * 4. Create a program to display the day, month, year and the name of the day for today date. Write a recursive method to display the name of the day of the past date. (Tip: use the today date as the parameters for the recursive method). Example output:
Today Date (dd/mm/yyyy): 13/4/2016
Today is on Wednesday
Search Date (dd/mm/yyyy): 20/8/2015
Search Date is on Thursday
 */
package Q4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test{
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        // Why use recursion when there is a feature for this?
        Date today = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        String day = dayFormat.format(today);
//        System.out.println("Today Date (dd/mm/yyyy): " + sdf.format(today));
//        System.out.println("Today is on " + day);
        // Why use recursion when there is a feature for this? */
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int dayInNumeric = cal.get(Calendar.DAY_OF_WEEK) - 1;
        
        String todayDate = sdf.format(today);
        String passDate = "20/8/2015";
        System.out.println("Today Date (dd/mm/yyyy): " + todayDate);
        System.out.println("Today is on " + day);
        System.out.println("Search Date (dd/mm/yyyy): " + passDate);
        System.out.println("Search Date is on " + findDay(todayDate, passDate, dayInNumeric));
        
    }
    
    public static String findDay(String today, String pass, int day){
        
        if(today.equals(pass)){
            return convertDay(day);
        }
        
        String[] todayList = today.split(Pattern.quote("/"));
        int todayDate = Integer.parseInt(todayList[0]);
        int todayMonth = Integer.parseInt(todayList[1]);
        int todayYear = Integer.parseInt(todayList[2]);
        
        int passYear = Integer.parseInt(today.split(Pattern.quote("/"))[2]);
        int passMonth = Integer.parseInt(today.split(Pattern.quote("/"))[1]);
        int passDate = Integer.parseInt(today.split(Pattern.quote("/"))[0]);
        if(todayYear <= passYear){
            if(todayMonth <= passMonth){
                if(todayDate < passDate){
                    return "SEARCH_YEAR IS LESS THAN TODAY_YEAR";
                }
            }
        }
        
        todayDate -= 1;
        
        if(todayDate <= 0){
            todayMonth -= 1;
            
            switch(todayMonth){
                case 0:
                    todayYear -= 1;
                    todayMonth = 12;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    todayDate = 31;
                    break;
                case 2:
                    if(leapYear(todayYear)) todayDate = 29;
                    else todayDate = 28;
                    break;
                default:
                    todayDate = 30;
            }
        }
        
        day -= 1;
        if(day == 0) day = 7;
        today = todayDate + "/" + todayMonth + "/" + todayYear;
        
        return findDay(today, pass, day);
    }
    
    public static boolean leapYear(int year){
        return (year % 4 == 0 || year % 400 == 0) && year % 100 != 0;
    }
    
    public static String convertDay(int day){
        
        switch(day){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return null;
        }
    }
}