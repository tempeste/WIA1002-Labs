/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author RAVEN
 */
public class Shares {
    int amount;
    int value; 
    int day;
    char type;
    private String typeFull;

    public Shares(String[] arr) {
        day = Integer.valueOf(arr[0]);
        type = arr[1].charAt(0);
        amount = Integer.valueOf(arr[2]);
        value = Integer.valueOf(arr[3]);
        switch (type) {
            case 'B':
                typeFull = "Buy";
                break;
            case 'S':
                typeFull = "Sell";
                break;
            default:
                throw new IllegalArgumentException("Invalid transaction type!");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getValue() {
        return value;
    }

    public char getType() {
        return type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Day " + day+ " : "+typeFull + " " + amount +" shares at RM" +value;
    }
}
