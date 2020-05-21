/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author RAVEN
 */
public class Packet implements Comparable<Packet>{
    String type;
    static int packetNumber = 0;
    int permaNum;
    
    public Packet(String type){
        this.type = type;
        packetNumber += 1;
        permaNum = packetNumber;
    }
    @Override
    public int compareTo(Packet a) {
        if(priority(this.type) > priority(a.getType())){
            return 1;
        }else if(priority(this.type) < priority(a.getType())){
            return -1;
        }else{
            return 0;
        }
    }
    
    private static int priority(String type){
        switch(type){
            case "Voice":
                return 2;
            case "Video":
                return 1;
            case "Data":
                return 0;
            default:
                System.out.println("Invalid packet type");
                return -1;
        }
    }

    public String getType() {
        return type;
    }
    
    public String toString(){
        return type+ " " + permaNum + " (Priority=" + priority(type)+ ")";
    }
}
