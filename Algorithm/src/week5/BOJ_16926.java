package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int row, col, rotate, S;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        rotate = Integer.parseInt(st.nextToken());
        board = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        S = Math.min(row, col) / 2;

        for (int i = 0; i < rotate; i++) {
            spin();
        }
        
        printArray(board);

    }

    public static void printArray(int[][] board){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void spin() {
        for (int i = 0; i < S; i++) {
            int T = i;
            int B = row - 1 - i;
            int R = col - 1 - i;
            int L = i;

            int tmp = board[i][i];
            for (int j = L; j < R; j++)    board[T][j] = board[T][j + 1];
            for (int j = T; j < B; j++)    board[j][R] = board[j + 1][R];
            for (int j = R; j > L; j--)    board[B][j] = board[B][j - 1];
            for (int j = B; j > T; j--)    board[j][L] = board[j - 1][L];
            board[T + 1][L] = tmp;

        }
    }
    
}
