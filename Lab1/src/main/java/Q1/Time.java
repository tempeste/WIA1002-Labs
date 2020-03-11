/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author RAVEN
 */
public class Time {
    private int hour, minute;
    private String answer;
    private int hourConv;
    private String suffix = "AM";
    public Time(int a, int b){
        this.hour = a;
        this.minute = b;
        this.answer = this.convert();
    }
    
    public String convert(){
        if(this.hour > 23 || this.hour < 0 || this.minute > 59 || this.minute <0){
            return "Invalid Time Input";
        }
        
        if(hour > 12){
            this.hourConv = hour - 12;
            this.suffix = "PM";
        }
        
        return String.format("%d:%d %s", hourConv, minute, suffix);
    }
    
    
    public String toString(){
        return String.format("Hour: %d Minute: %d %s", hour, minute, answer);
    }
    
}
