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
public interface UNO<T> {
    final static String[] nums = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Draw Two", "Reverse", "Skip"};
    final static String[] color = new String[]{"Red", "Blue", "Green", "Yellow"};
   
    public void generate();
    public void draw();
}
