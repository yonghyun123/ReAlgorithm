package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15656 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb;
    private static int n,r;
    private static int[] board;
    private static List<Integer> result;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if(st.hasMoreTokens()){
            r = Integer.parseInt(st.nextToken());
        }

        board = new int[n];
        sb = new StringBuilder();
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int j = 0;
        while(st.hasMoreTokens()){
            board[j] = Integer.parseInt(st.nextToken());
            j++;
        }

        Arrays.sort(board);
        dupCombination(0);
        System.out.print(sb.toString());

    }

    public static void dupCombination(int depth){
        if(r == depth){
            for(int el: result){
                sb.append(el+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            result.add(board[i]);
            dupCombination(depth+1);
            result.remove(result.size()-1);
        }
    }
}
