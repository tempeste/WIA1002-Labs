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
    private static Maze mazeObj = new Maze("Maze.txt");
    private static char[][] maze = mazeObj.getMaze();
    private static Stack<int[]> open = new Stack<>();
    private static Stack<int[]> close = new Stack<>();
    private static int[] finish = mazeObj.getFinish();
    private static int[] start = mazeObj.getStart();
    
    public static void main(String[] args) {
        open.push(start);
        boolean hasSolution = solve(open.peek()[0], open.peek()[1]);
        fill();
        maze[start[0]][start[1]] = 'S';
        maze[finish[0]][finish[1]] = 'F';
        if(hasSolution){
            System.out.println("The Solution is:");
            for(int i = 0; i < mazeObj.getRows(); i++){
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
        if(maze[r][c] == '#'){
            open.pop();
            return false;
        }else if(close.search(new int[]{r,c})){
            open.pop();
            return false;
        }else if(maze[r][c] == 'F' ){
            return true;
        }else{
            close.push(new int[]{r,c});
        }
        
        int[][] neighbours = new int[][]{
            {r+1,c}, {r-1,c}, {r,c+1},{r,c-1}
        };
        
        for(int[] arr: neighbours){
            open.push(arr);
            if(solve(arr[0], arr[1])){
                return true;
            }
        }
        open.pop();
        return false;
    }
    
    static void fill(){
        while(!open.isEmpty()){
            int[] temp= open.pop();
            maze[temp[0]][temp[1]] = '.';
        }
    }
}
