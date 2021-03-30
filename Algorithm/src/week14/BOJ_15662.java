package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;


public class BOJ_15662 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int T, C;
    public static boolean[] visited;
    public static int[] filp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());

        List<List<Integer>> inputList = new ArrayList<>();


        // for(int i = 0; i < T; i++){
        //     inputList[i] = new ArrayList<Integer>();
        // }

        for(int i = 0; i < T; i++){
            List<Integer> temp = new ArrayList<Integer>();
            String tempStr = br.readLine();
            for(int j = 0; j < tempStr.length(); j++){
                int num = tempStr.charAt(j) - '0';
                temp.add(num);
            }
            inputList.add(temp);
        }
        
        C = Integer.parseInt(br.readLine());
        
        int TNum = 0;
        int roundDir =0;
        for(int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());
            
            if(st.hasMoreTokens()){
                TNum = Integer.parseInt(st.nextToken());
            }

            if(st.hasMoreTokens()){
                roundDir = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[T];
            filp = new int[T];
            int idx = TNum -1;
            filp[idx] = roundDir;

            for(int j = idx; j >= 1; j--){
                filp[j-1] = filp[j] * -1;
            }

            for(int j = idx; j < T-1; j++){
                filp[j+1] = filp[j] * -1;
            }
            // 각 톱니바퀴 N,S극 판단
            // 기준 톱니바퀴로부터 오른쪽, 왼쪽 판단
            // 기준 톱니로부터 왼쪽으로 진행할때
            for(int j = idx; j >= 1; j--){
                if(inputList.get(j).get(6) != inputList.get(j-1).get(2)){
                    visited[j-1] = true;
                } else {
                    break;
                }
            }
            //기준 톱니로부터 오른쪽 진행
            for(int j = idx; j < T-1; j++){
                if(inputList.get(j).get(2) != inputList.get(j+1).get(6)){
                    visited[j+1] = true;
                } else {
                    break;
                }
            }

            for(int j = 0; j < T; j++){
                if(visited[j]){
                    visited[idx] = true;
                    break;
                }
            }

            for(int j = 0; j < T; j++){
                if(visited[j]){
                    rotate(inputList.get(j), filp[j]);
                }
            }
        }
    
        int result = 0;
        
        for (int j = 0; j < T; j++) {
            result += inputList.get(j).get(0);
        }
        System.out.println(result);
    }
    
    public static void rotate(List<Integer> list, int direction){
        // direction 1이면 시계방향, -1이면 반시계방향
        if(direction == -1){
            int temp = list.get(0); // element 보관
            for(int i = 0 ; i < list.size()-1; i++){
                list.set(i, list.get(i+1));
            }
            list.set(list.size()-1, temp);
        }else{
            int temp = list.get(list.size()-1); //마지막 element 보관
            for(int i = list.size()-1; i > 0; i--){
                list.set(i, list.get(i-1));
            }
            list.set(0, temp);


        }
    }
}
