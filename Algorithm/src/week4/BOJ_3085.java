package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 
상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.


5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ

4
*/
public class BOJ_3085 {
    private static int n;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[][] board;
    private static boolean[][] visited;
    private static int[] verticalY = { 1, -1 };
    private static int[] horizonX = { 1, -1 };
    private static int maxCnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        n = Integer.parseInt(br.readLine());

        String[][] resultBoard = new String[n][n];
        board = new String[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String rowStr = br.readLine();
            for(int j = 0; j < rowStr.length(); j++){
                board[i][j] = String.valueOf(rowStr.charAt(j));
            }
        }
        

        copyBoard(resultBoard, board);

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n-1; j++){
                if(board[i][j] != board[i][j+1]){
                    resultBoard[i][j+1] = board[i][j];
                    resultBoard[i][j] = board[i][j+1];

                    //bfs
                    int[] pos = {i,j};
                    solutions(resultBoard, visited, pos);
                    pos[0] = i;
                    pos[1] = j+1;
                    solutions(resultBoard, visited, pos);
                    copyBoard(resultBoard,board);
                }
            }

            for(int j = 0; j < n-1; j++){
                if(i < n-1 && board[i][j] != board[i+1][j]){
                    resultBoard[i+1][j] = board[i][j];
                    resultBoard[i][j] = board[i+1][j];

                    //bfs
                    int[] pos = {i,j};
                    solutions(resultBoard, visited, pos);
                    pos[0] = i+1;
                    pos[1] = j;
                    solutions(resultBoard, visited, pos);
                    copyBoard(resultBoard,board);
                }
            }
        }

        System.out.println(maxCnt);

    }

    public static void solutions(String[][] resultBoard, boolean[][] visited, int[] pos){
        int horizonCnt = calHorizonCnt(resultBoard,visited,pos);
        visitClear(visited);
        maxCnt = Math.max(maxCnt, horizonCnt);

        // printBoard(resultBoard);

        int verticalCnt = calVerticalCnt(resultBoard,visited,pos);
        maxCnt = Math.max(maxCnt, verticalCnt);
    }

    public static int calVerticalCnt(String[][] resultBoard, boolean[][] visited, int[] pos){
        int resultCnt = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[pos[0]][pos[1]] = true;
        q.add(pos);
        resultCnt += 1;

        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];

            q.poll();

            String curStr = resultBoard[row][col];
            for(int i = 0; i < 2; i++){
                int nextRow = row + verticalY[i];
                int nextCol = col;

                if(nextRow < 0 || nextCol < 0 || nextCol >= n || nextRow >= n)continue;
                if(!visited[nextRow][nextCol] && resultBoard[nextRow][nextCol].equals(curStr)){
                    int[] nextPos = {nextRow, nextCol};
                    visited[nextRow][nextCol] = true;
                    q.add(nextPos);
                    resultCnt += 1;
                }
            }

        }
        return resultCnt;
    }

    public static int calHorizonCnt(String[][] resultBoard, boolean[][] visited, int[] pos){
        int resultCnt = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[pos[0]][pos[1]] = true;
        q.add(pos);
        resultCnt += 1;

        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];

            q.poll();

            String curStr = resultBoard[row][col];
            for(int i = 0; i < 2; i++){
                int nextRow = row; 
                int nextCol = col + horizonX[i];
                if(nextRow < 0 || nextCol < 0 || nextCol >= n || nextRow >= n)continue;
                if(!visited[nextRow][nextCol] && resultBoard[nextRow][nextCol].equals(curStr)){
                    int[] nextPos = {nextRow, nextCol};
                    visited[nextRow][nextCol] = true;
                    q.add(nextPos);
                    resultCnt += 1;
                }
            }

        }
        return resultCnt;
    }

    public static void visitClear(boolean[][] visited){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void printBoard(String[][] resultBoard){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(resultBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void copyBoard(String[][] resultBoard, String[][] board){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                resultBoard[i][j] = board[i][j];
            }
        }
    }
    
}
