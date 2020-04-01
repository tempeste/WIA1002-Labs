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
public class Q5 {
    public static void main(String[] args) {
        String[] arr = new String[]{"ARS", "CHE", "LEI", "MAN", "LIV", "TOT"};
        LinkedList list = new LinkedList<String>();
        for(String string : arr){
            list.addNode(string);
        }
        System.out.println("The list consists of " + list);
        System.out.println("Remove all the word that consists of the A character using iterator");
        LinkedList.LinkedListIterator iterator = list.iterator();
        while(iterator.hasNext()){
            if(((String) iterator.getCurrent().getData()).contains("A")){
                iterator.remove();
            }
            iterator.next();
        }
        
        System.out.println("The updated list consists of " + list);
    }
}
