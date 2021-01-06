package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int n;
    private static int[] perm;
    private static int[] inputArr;
    private static boolean[] visited;
    private static boolean isAns;
    private static boolean isBreak;
    private static StringBuffer sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        perm = new int[n];
        inputArr = new int[n];
        visited = new boolean[n];
        isAns = false;
        isBreak = false;

        for(int i = 0; i < n; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        solution(perm, visited, 0);
        if(sb == null || sb.length() == 0){
            System.out.println("-1");
        }else{
            System.out.println(sb);
        }

    }

    public static void solution(int[] perm, boolean[] visited, int depth){
        if(depth == n){
            for(int i = 0; i < n; i++){
                if(perm[i] != inputArr[i]){
                    break;
                }
                if(i == n-1 && perm[i] == inputArr[i]){
                    isAns = true;
                    return;
                }
            }
            if(isAns){
                for(int i = 0; i < n; i++){
                    sb.append(perm[i]+" ");
                }
                isBreak = true;
                
            }
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                perm[depth] = i+1;
                solution(perm, visited, depth+1);
                if(isBreak) break;
                visited[i] = false;
                
            }
        }
    }
    
}
