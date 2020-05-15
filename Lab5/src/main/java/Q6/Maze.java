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
    private int[] start = new int[2];
    private int[] finish = new int[2];
    private int rows = 0;
    private int columns = 0;

    public Maze(String fileName) {
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
            for(int i = 0; i < rows; i++){
                String input = sc1.nextLine();
                System.out.println(input);
                for(int j = 0; j < columns; j++){
                    maze[i][j] = input.charAt(j);
                    if(input.charAt(j) == 'F'){
                        finish = new int[]{i,j};
                    }else if(input.charAt(j) == 'S'){
                        start = new int[]{i,j};
                    }
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

    public int[] getStart() {
        return start;
    }

    public int[] getFinish() {
        return finish;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
    

}
