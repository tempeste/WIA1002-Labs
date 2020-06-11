/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author RAVEN
 */
public class Product implements Comparable<Product> {
    String PID;
    String SID;
    double price;
    int quantity;

    public Product(String[] arr) {
        PID = arr[0];
        SID = arr[1];
        price = Double.valueOf(arr[2]);
        double temp = Double.valueOf(arr[3]);
        quantity = (int) temp;
    }

    @Override
    public int compareTo(Product a) {
        if(this.price != a.price){
            return (int) (price - a.price);
        }else if(!this.PID.equals(a.PID)){
            return PID.compareTo(a.PID);
        }else{
            return 0;
        }
    }
    public String toString(){
        return String.format("%s : %s : %f : %d", PID, SID, price, quantity);
    }
        
}
