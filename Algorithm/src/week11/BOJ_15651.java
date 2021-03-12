package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율 1 초 512 MB 20084 13126 10097 65.907% 문제 자연수 N과
 * M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 
 * 1부터 N까지 자연수 중에서 M개를 고른 수열 같은 수를 여러 번 골라도 된다.
 */

public class BOJ_15651 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n,r;
    public static int[] result;
    public static boolean[] visited;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        result = new int[r];
        visited = new boolean[n];

        permutation(result,0);

        System.out.println(sb);

    }

    public static void permutation(int[] result, int depth){
        if(depth == r){
            for(int i =0 ; i < result.length; i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            result[depth] = i+1;
            permutation(result, depth+1);    
        }
    }
}
