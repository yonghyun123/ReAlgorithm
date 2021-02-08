package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는
 * 프로그램을 작성하시오. 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
 * 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * 
 * 입력 
 * 5 0 
 * -7 -3 -2 5 8
 * 
 * 1
 * 
 */

public class BOJ_1182 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, answer, resultCnt;
    private static List<Integer>  inputArr, containArr;
    private static boolean[] visited;
        

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        answer =Integer.parseInt(st.nextToken());

        inputArr = new ArrayList<>();
        visited = new boolean[n];
        containArr = new ArrayList<>();
        

        st = new StringTokenizer(br.readLine());

        resultCnt = 0;
        for(int i = 0; i < n; i++){
            inputArr.add(Integer.parseInt(st.nextToken()));
        }
        containArr.sort(Comparator.naturalOrder());

        for(int i = 1; i <= n; i++){
            solutions(0, i, 0);
        }
        System.out.println(resultCnt);

    }

    public static void solutions(int start, int finalDepth, int depth){
        if(finalDepth == depth){
            int sum = 0;
            for(int i : containArr){
                sum += i;
                // System.out.print(i+" ");
            }
            if(answer == sum){
                resultCnt += 1;
            }
            // System.out.println();
            return;
        }

        if(finalDepth < depth) return;
        
        for(int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                containArr.add(inputArr.get(i));
                solutions(i+1,finalDepth, depth+1);
                containArr.remove(containArr.size()-1);
                visited[i] = false;
            }
        }
    }
    
}
