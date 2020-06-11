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
public class Special implements Comparable<Special>{
    int value;
    public Special(Integer a){
        value = a;
    }
    
    public int compareTo(Special o) {
        if(value % 2 == 0 ){
            if(o.value %2 !=0){
                return 1;
            }else{
                return value - o.value;
            }
        }else{
            if(o.value%2 == 0 ){
                return -1;
            }else{
                return value - o.value;
            }
        }
    }
    
    public String toString(){
        return String.valueOf(value);
    }
}
