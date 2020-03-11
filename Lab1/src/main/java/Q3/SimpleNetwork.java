package Q3;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAVEN
 */
public class SimpleNetwork {
    private String name;
    private String ip;
    private String subnet;
    private boolean status;

    public SimpleNetwork(String name, String ip, String subnet, boolean status) {
        this.name = name;
        this.ip = ip;
        this.subnet = subnet;
        this.status = status;
        System.out.println(this.toString());
    }
    
    @Override
    public String toString(){
        return "Host Name: " + name + "IP: " + ip + " Subnet Mask: "+ subnet + " Status: " + (status? "UP" : "DOWN");
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getSubnet() {
        return subnet;
    }

    public boolean isStatus() {
        return status;
    }
    
    
    public void ping(SimpleNetwork a){
        if(this.status && a.isStatus() == false){
            System.out.printf("%s cannot ping %s because the destination %s is down. \n", this.name, a.getName(), a.getName() );
            return;
        }
        String[] subNetMask = this.subnet.split("\\.");
        String[] ip1 = this.ip.split("\\.");
        String[] ip2 = a.getIp().split("\\.");
        boolean able = true;
        for(int i = 0; i < 4; i++){
            if( (Integer.parseInt(ip1[i])& Integer.parseInt(subNetMask[i]) )!= (Integer.parseInt(ip2[i])& Integer.parseInt(subNetMask[i]))){
                able = false;
            }
        }
        
        if (able == false){
           System.out.printf("%s cannot ping %s because the destination %s is located in a different network. \n", this.name, a.getName(), a.getName() );
        }else{
            System.out.printf("%s can ping %s \n", this.name, a.getName());
        }
    }
}
