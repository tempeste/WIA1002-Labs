/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

/**
 *
 * @author RAVEN
 */
public class Q6 {
    private static Maze mazeObj = new Maze("Maze.txt"); //global variables to reduce tracking headaches
    private static char[][] maze = mazeObj.getMaze();   //global variables to reduce tracking headaches
    private static Stack<int[]> open = new Stack<>();   //global variables to reduce tracking headaches
    private static Stack<int[]> close = new Stack<>();  //global variables to reduce tracking headaches
    private static int[] finish = mazeObj.getFinish();  //global variables to reduce tracking headaches
    private static int[] start = mazeObj.getStart();    //global variables to reduce tracking headaches
    
    public static void main(String[] args) {
        open.push(start);
        boolean hasSolution = solve(open.peek()[0], open.peek()[1]);
        fill();
        maze[start[0]][start[1]] = 'S'; //Without this and the next line, 
        maze[finish[0]][finish[1]] = 'F';//The S and F will disappear from the maze
        System.out.println("");
        if(hasSolution){
            System.out.println("The Solution is:");
            for(int i = 0; i < mazeObj.getRows(); i++){ //displaying maze
                for(int j = 0; j < mazeObj.getColumns(); j++){
                    System.out.print(maze[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("There is no solution");
        }
    }
    
    static boolean solve(int r, int c){
        if(maze[r][c] == '#'){ //if encounter #, backtrack
            open.pop();
            return false;
        }else if(close.search(new int[]{r,c})){ //if encounter visited nodes, backtrack
            open.pop();  
            return false;
        }else if(maze[r][c] == 'F' ){ //if reached finish cell, end the function by passing true to parent
            return true;
        }else{
            close.push(new int[]{r,c});
        }
        
        int[][] neighbours = new int[][]{ //generation of 4-direction neighbours
            {r+1,c}, {r-1,c}, {r,c+1},{r,c-1}
        };
        
        for(int[] arr: neighbours){ 
            open.push(arr); //open is the stack we'll use to print our route
            if(solve(arr[0], arr[1])){
                return true;
            }
        }
        open.pop(); //if everything fails, empty the stack;
        return false;
    }
    
    static void fill(){ //to print out the route
        while(!open.isEmpty()){
            int[] temp= open.pop();
            maze[temp[0]][temp[1]] = '.';
        }
    }
}
