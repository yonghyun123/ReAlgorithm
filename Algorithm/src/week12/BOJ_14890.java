package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경사로 크기가 N×N인 지도가 있다. 지도의 각 칸에는 그 곳의 높이가 적혀져 있다.
 * 
 * 오늘은 이 지도에서 지나갈 수 있는 길이 몇 개 있는지 알아보려고 한다. 길이란 한 행 또는 한 열 전부를 나타내며, 한쪽 끝에서 다른쪽
 * 끝까지 지나가는 것이다.
 * 
 * 다음과 같은 N=6인 경우 지도를 살펴보자.
 * 
 * input 6 2 3 3 3 3 3 3 2 3 3 3 3 3 2 2 2 3 2 3 1 1 1 2 2 2 1 1 1 3 3 1 1 1 2 3
 * 3 2
 * 
 * output 3
 */
public class BOJ_14890 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static int leanCnt, n;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        leanCnt = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        visited = new boolean[n];

        int result = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        //Arrays row calculate
        for(int i = 0; i < n; i++){
            int[] tempArr = board[i].clone();
            // if(isCorrect(tempArr)) result += 1;
        }
        // printBoard();
        
    }

    // public static boolean isCorrect(int[] tempArr){
    //     for(int i = 0; i < n-1; i++){
    //         //기저조건
    //         if(Math.abs(tempArr[i] - tempArr[i+1]) >= 2) return false;
            
    //         if(tempArr[i] > tempArr[i+1]){ //내려갈때
    //             for(int j = i+1; j < n-1; j++){
    //                 if(tempArr[j] == tempArr[j+1]){
    //                     visited[j] = true;
    //                 }
    //             }
                

    //         }
    //     }

    // }

    public static void printBoard(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
