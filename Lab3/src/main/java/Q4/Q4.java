/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;
import java.util.Scanner;
/**
 *
 * @author RAVEN
 */
public class Q4 {
    final static boolean[] Months = new boolean[]{true,false,true,false,true,false,true,true,false,true,false,true};

    
    public static void main(String[] args) {
        //pattern for day change if month change is +3 if going forward from big month to small month -2 if backwards
        //+2 instead if from small mnonth to big month -3 if backwards
        //Feb to March is +1 if leap year, otherwise no change, -1 if go backwards
        //day +1 if going forward from year to year, -1 otherwise
        //day + 2 if going into a leap year, -2 if going from a leap year
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Today Date(dd/mm/yy): ");
        String today = sc.nextLine();
        String toD = dayConv(dayCalc1(today));
        System.out.println("Today is on " + toD);
        System.out.print("Search Date (dd/mm/yy): ");
        String searchDate = sc.nextLine();
        String searchDay = dayConv(dayCalc2(searchDate, today, dayCalc1(today)));
        System.out.println("Search Date is on " + searchDay);

    }
    
    public static int dayCalc1(String date){
        String[] arr = date.split("/");
        int[] specialMonth = new int[]{11,12,1,2,3,4,5,6,7,8,9,10};
        int day, month, year;
        if(arr.length != 3){
            System.out.println("Invalid Date Input");
            return -1;
        }else{
            day = Integer.valueOf(arr[0]);
            month = Integer.valueOf(arr[1]); //remember to -1 when using as index
            year = Integer.valueOf(arr[2]); //year must be 4 digits
            if(month == 1 || month == 2){
                year -= 1;
            }
        }
        
        int f = day + (13*specialMonth[month-1])/5 + year%100 + (year%100)/4 + year/100/4 - 2*(year/100);

        f %= 7;
        return f >= 0 ? f : f* -1;
    }
    
    public static String dayConv(int val){
        switch(val){
            case 0:
                return "Sunday";
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
        }
        return "Error";
    }
    
    public static int dayCalc2(String comp, String ori, int oriDay){
        String[] compSArr = comp.split("/");
        String[] oriSArr = ori.split("/");
        int[] compArr = new int[3];
        int[] oriArr = new int[3];

        for(int i = 0; i < 3; i++){
            compArr[i] = Integer.valueOf(compSArr[i]);
            oriArr[i] = Integer.valueOf(oriSArr[i]);
        }
        
        if(oriDay > 6){
            oriDay -= 7;
        }else if(oriDay <0){
            oriDay +=7;
        }
        
        if(oriArr[2] < compArr[2]){
            if(leapYear(oriArr[2] + 1)){
                String ori2 = ""+ oriArr[0] +"/" + oriArr[1] + "/" + (oriArr[2]+1);
                return dayCalc2(comp, ori2 , oriDay+2);
            }else{
                String ori2 = ""+ oriArr[0] +"/" + oriArr[1] + "/" + (oriArr[2]+1);
                return dayCalc2(comp, ori2 , oriDay+1);
            }
            
        }else if(oriArr[2] > compArr[2]){
            if(leapYear(oriArr[2] - 1)){
                String ori2 = ""+ oriArr[0] +"/" + oriArr[1] + "/" + (oriArr[2]-1);
                return dayCalc2(comp, ori2 , oriDay-2);
            }else{
                String ori2 = ""+ oriArr[0] +"/" + oriArr[1] + "/" + (oriArr[2]-1);
                return dayCalc2(comp, ori2 , oriDay-1);
            }
        }
        
        if(oriArr[1] < compArr[1]){
            switch (oriArr[1] + 1) {
                case 3:
                    if(leapYear(oriArr[2])){
                        String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]+1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay+1);
                    }else{
                        String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]+1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay);
                    }
                case 8:
                    String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]+1) + "/" + oriArr[2];
                    return dayCalc2(comp, ori2 , oriDay+3);
                default:
                    if(Months[oriArr[1]]){
                        ori2 = ""+ oriArr[0] +"/" + (oriArr[1]+1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay+2);
                    }else{
                        ori2 = ""+ oriArr[0] +"/" + (oriArr[1]+1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay+3);
                    }
            }
        }else if(oriArr[1] > compArr[1]){
            switch (oriArr[1] - 1) {
                case 2:
                    if(leapYear(oriArr[2])){
                        String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]-1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay-1);
                    }else{
                        String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]-1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay);
                    }
                case 7:
                    String ori2 = ""+ oriArr[0] +"/" + (oriArr[1]-1) + "/" + oriArr[2];
                    return dayCalc2(comp, ori2 , oriDay-3);
                default:
                    if(Months[oriArr[1]-1]){
                         ori2 = ""+ oriArr[0] +"/" + (oriArr[1]-1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay-2);
                    }else{
                        ori2 = ""+ oriArr[0] +"/" + (oriArr[1]-1) + "/" + oriArr[2];
                        return dayCalc2(comp, ori2 , oriDay-3);
                    }
            }
        }
        
        if(oriArr[0] < compArr[0]){
            String ori2 = ""+ (oriArr[0]+1) +"/" + oriArr[1] + "/" + oriArr[2];
            return dayCalc2(comp, ori2 , oriDay+1);
        }else if(oriArr[0] > compArr[0]){
            String ori2 = ""+ (oriArr[0]-1) +"/" + oriArr[1] + "/" + oriArr[2];
            return dayCalc2(comp, ori2 , oriDay-1);
        }

        return oriDay;
        
    }
    
    
    public static boolean leapYear(int year){
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
            return true;
        }
        
        return false;
    }
    
}
