/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Maze {
    private char[][] maze;

    public Maze(String fileName) {
        int rows = 0;
        int columns = 0;
        try{
            Scanner sc = new Scanner(new FileInputStream(fileName));
            while(sc.hasNextLine()){
                if(columns == 0){
                    columns = sc.nextLine().length();
                    rows++;
                }
                sc.nextLine();
                rows++;
            }
            sc.close();
            maze = new char[rows][columns];
            Scanner sc1 = new Scanner(new FileInputStream(fileName));
            System.out.println(columns);
            for(int i = 0; i < rows; i++){
                String input = sc1.nextLine();
                System.out.println(input);
                for(int j = 0; j < columns; j++){
                    maze[i][j] = input.charAt(j);
                }
            }
            sc1.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }

    public char[][] getMaze() {
        return maze;
    }

}
