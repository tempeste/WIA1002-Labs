/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author RAVEN
 */
public class Test {
    public static void main(String[] args) {
        SimpleNetwork a = new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", true);
        SimpleNetwork b = new SimpleNetwork("Host 2", "10.1.1.1", "255.255.255.224", false);
        SimpleNetwork c = new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", true);
        SimpleNetwork d = new SimpleNetwork("Host 4", "10.1.1.15", "255.255.255.224", true);
        
        a.ping(b);
        a.ping(c);
        a.ping(d);
    }
}
