package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int n;
    private static int[] perm;
    private static int[] inputArr;
    private static boolean[] visited;
    private static boolean isContinue, isAns;
    private static boolean isBreak;
    private static StringBuffer sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        perm = new int[n];
        inputArr = new int[n];
        visited = new boolean[n];
        isContinue = false;
        isBreak = false;
        int breakIdx = 0;

        for(int i = 0; i < n; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        //재귀로 돌리면 타임아웃나므로 규칙 찾는걸로 변경

        /**
         *  수를 뒤에서부터 오름차순 읽어서 오름차순 아닌 인덱스 판별
         *  해당 인덱스에 배열값과 지나온 배열 수 중에 가장 가까운수를 swap
         *  ex) 1 3 4 2   ->  3에서 인덱스를 멈춘후 2,4중 3보다 큰 가까운수를 swap
         *  나머지 배열들은 sort
         */
         // solution(perm, visited, 0);
        // if(sb == null || sb.length() == 0){
        //     System.out.println("-1");
        // }else{
        //     System.out.println(sb);
        // }

        for(int i = n; i > 1; i--){
            if(inputArr[i-1] > inputArr[i-2]){
                isContinue = true;
                breakIdx = i-2;
                
                // System.out.println("breakIdx = " + breakIdx);
                break;
            }
        }
        if(!isContinue){
            System.out.println("-1");
            return;
        } else {
            long overNum = 99999999999L;
            int idx = 0;
            for(int i = breakIdx; i < n; i++){
                if((inputArr[breakIdx] < inputArr[i]) && inputArr[i] < overNum){
                    
                    overNum = inputArr[i];
                    idx = i;
                }
            }

            int temp = inputArr[breakIdx];
            inputArr[breakIdx] = inputArr[idx];
            inputArr[idx] = temp;

            Arrays.sort(inputArr,breakIdx+1,inputArr.length);

            for(int i = 0 ; i < n; i++){
                System.out.print(inputArr[i]+" ");
            }
        }



    }

    public static void solution(int[] perm, boolean[] visited, int depth){
        if(depth == n){
            if(Arrays.equals(perm, inputArr)){
                isAns = true;
                return;
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
