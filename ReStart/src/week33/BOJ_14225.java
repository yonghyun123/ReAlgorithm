package week33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;




public class BOJ_14225 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static List<Integer> combiList,resultList;
    private static boolean[] visited;
    private static int[] board;
    private static int n;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        combiList = new ArrayList<>();
        resultList = new ArrayList<>();
        
        board = new int[n];
        visited = new boolean[n];

        int idx = 0;
        
        while(st.hasMoreTokens()){
            board[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        for(int i = 0; i < n; i++){
            dfs(0, i+1);
        }

        Collections.sort(resultList);

        for(int i = 0;i < resultList.size()-1; i++){
            if(resultList.get(i+1) - resultList.get(i) >= 2){
                System.out.println(resultList.get(i)+1);
                break;
            }
        }
        



    }

    public static void dfs(int start, int r){
        if(combiList.size() == r){
            int temp = 0;
            for(int i : combiList){
                temp += i;
            }
            if(!resultList.contains(temp)) resultList.add(temp);
        }

        for(int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                combiList.add(board[i]);
                dfs(i+1, r);
                combiList.remove(combiList.size()-1);
                visited[i] = false;;
            }
        }
    }
}
