package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 고른 수열은 오름차순이어야 한다.
 * 
 * 4 2
 * 
 * 1 2 1 3 1 4 2 3 2 4 3 4
 */
public class BOJ_15650 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static ArrayList<Integer> resultArr;
    private static boolean[] visited;
    private static int n, r;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        resultArr = new ArrayList<>();
        combination(0);
    }

    public static void combination(int depth){
        if(depth == r){
            for (int item: resultArr){
                System.out.print(item+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(!resultArr.isEmpty()){
                    if(resultArr.get(resultArr.size()-1) < (i+1)){
                        visited[i] = true;
                        resultArr.add(i+1);
                        combination(depth+1);
                        resultArr.remove(resultArr.size()-1);
                        visited[i] = false;
                    }
                } else {
                    visited[i] = true;
                    resultArr.add(i+1);
                    combination(depth+1);
                    resultArr.remove(resultArr.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}
