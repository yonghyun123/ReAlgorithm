package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 */
public class BOJ_10974 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] board;
    private static boolean[] visited;
    private static int R;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        R = Integer.parseInt(br.readLine());

        board = new int[R];
        visited = new boolean[R];

        permutation(0);
    }

    public static void permutation(int depth){
        if(depth == R){
            for(int i = 0; i < R; i++){
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < R; i++){
            if(!visited[i]){
                visited[i] = true;
                board[depth] = i+1;
                permutation(depth+1);
                visited[i] = false;
            }

        }
    }
}
