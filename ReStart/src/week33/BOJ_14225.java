package week33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class BOJ_14225 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] board;
    private static boolean[] visited;
    private static int n;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        
        board = new int[n];
        visited = new boolean[2000001];

        int idx = 0;
        
        while(st.hasMoreTokens()){
            board[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        for(int i = 0; i < n; i++){
            dfs(i, board[i]);
        }

        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                System.out.println(i);
                break;
            }
        }


    }

    public static void dfs(int start, int sum){
        visited[sum] = true;
        for(int i = start+1; i < n; i++){
            dfs(i, board[i]+sum);
        }
    }
    
}
