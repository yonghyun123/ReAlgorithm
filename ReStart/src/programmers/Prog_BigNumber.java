package programmers;

import java.util.ArrayList;


public class Prog_BigNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("0007252841", 4));
        ;

    }
}

class Solution{
    public boolean []visited; 
    public int[] board;
    public ArrayList<Integer> resultArr;
    public int maxResult;

    public String solution(String number, int k){
        String answer = "";

        visited = new boolean[number.length()];
        board = new int[number.length()];
        resultArr = new ArrayList<>();
        int len = number.length();
        for(int i = 0; i < len; i++){
            if(number.charAt(i) -'0' == 0){
                k--;
                len--;
                continue;
            }
            board[i] = number.charAt(i) - '0';
        }        

        int r = number.length()-k;
        
        dfs(resultArr,0,r);

        answer = maxResult+"";
        return answer;
    }
    public void dfs(ArrayList<Integer> resultArr, int depth, int r){
        if(depth == r){
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < depth; i++){
                result.append(resultArr.get(i));
            }
            
            maxResult = Math.max(Integer.parseInt(result.toString()), maxResult);
            return;
        }

        if(depth >= r) return;

        for(int i = 0; i < board.length; i++){
            if(!visited[i]){
                resultArr.add(board[i]);
                visited[i] = true;
                for(int j = 0; j < i; j++){
                    visited[j] = true;
                }
                dfs(resultArr, depth+1, r);
                visited[i] = false;
                for(int j = 0; j < i; j++){
                    visited[j] = false;
                }
                resultArr.remove(resultArr.size()-1);
            }
        }
    }
}
