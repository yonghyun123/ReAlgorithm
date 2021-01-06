package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * 이문제는 다시 풀어봐야함
 * 집중을 잘 못했어 순열을 깊이우선탐색 문제 적용
 * input
 * 4 2
 * output
 *  1 2
    1 3
    1 4
    2 1
    2 3
    2 4
    3 1
    3 2
    3 4
    4 1
    4 2
    4 3
 */
public class BOJ_15649 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] result;
    private static boolean[] visited;
    private static int n, r;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        result = new int[n];
        visited = new boolean[n];

        permutation(result, visited,  0);

    }
    public static void permutation(int[] result, boolean[] visited, int depth){
        if(depth == r){
            for(int i = 0; i < r; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        if(depth > r) return;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = i+1;
                permutation(result, visited, depth+1);
                visited[i] = false;
            }
        }
    }
}
