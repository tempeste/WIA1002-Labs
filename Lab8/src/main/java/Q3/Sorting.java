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
public class Sorting implements Comparable<Sorting>{
    String name;
    long time;

    public Sorting(String name, long time) {
        this.name = name;
        this.time = time;
    }
    
    @Override
    public int compareTo(Sorting a) {
        return (time - a.time) > 0 ? 1 : (time - a.time) < 0 ? -1 : 0;
    }
    
    public String toString(){
        return name + " : " + time;
    }
}
