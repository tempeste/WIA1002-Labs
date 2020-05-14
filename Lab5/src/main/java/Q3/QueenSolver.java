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
import java.util.Stack;

public class QueenSolver {
    private static final int NUM_QUEENS = 8;
    private static int[] board = new int[NUM_QUEENS];

    public static void solve(int n) {
        int current = 0;
        int numSolutions = 0;

        Stack<Integer> s = new Stack<>();

        while (true) {
            while (current < n) {
                if (isBoardCorrect(s, current)) {
                    s.push(current);
                    board[s.size() - 1] = current;
                    current = 0;
                } else {
                    current++;
                }
            }

            if (s.size() == n) {
                printSolution(++numSolutions);
            }

            if (s.isEmpty()) {
                break;
            }

            if (s.peek() == n) {
                s.pop();
            }

            current = s.pop() + 1;
        }
    }

    private static boolean isBoardCorrect(Stack<Integer> s, int currentPosition) {
        for (int i = 0; i < s.size(); i++) {
            if (board[i] == currentPosition|| Math.abs(currentPosition - board[i]) == s.size() - i) {

                return false;
            }
        }
        return true;
    }

    private static void printSolution(int num) {
        System.out.print(num + ": ");
        for (int i = 0; i < board.length; i++) {
            System.out.print("(" + i + "," + board[i] + ")");
            if (i < board.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueenSolver.solve(6);
    }

}