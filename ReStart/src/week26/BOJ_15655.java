package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
 */

public class BOJ_15655 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, R; 
    private static List<Integer> result;
    private static boolean[] visited;
    private static int[] board;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if(st.hasMoreTokens()){
            R = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        board = new int[N];

        result = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            board[i] =Integer.parseInt(st.nextToken()); 
            i++;
            // board.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(board);

        // Collections.sort(board);

        combination(0, R);

    }

    public static void combination(int curDepth, int finalDepth){
        if(curDepth == finalDepth){
            for(int item : result){
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }

        for(int i = curDepth; i < board.length; i++){
            if(!visited[i]){
                if(!result.isEmpty()){
                    if(board[i] > result.get(result.size()-1)){
                        visited[i] = true;
                        result.add(board[i]);
                        combination(curDepth + 1, finalDepth);
                        result.remove((Integer)board[i]);
                        visited[i] = false;
                    }
                } else {
                    visited[i] = true;
                    result.add(board[i]);
                    combination(curDepth + 1, finalDepth);
                    result.remove((Integer)board[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
