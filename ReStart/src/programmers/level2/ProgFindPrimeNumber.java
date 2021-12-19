package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;



/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 
return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
"17"	3
"011"	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 */
public class ProgFindPrimeNumber {
    public static void main(String[] args) {
        ProgFindPrimeNumber.Solution solution = new ProgFindPrimeNumber().new Solution();
        String numbers = "011";
        System.out.println(solution.solution(numbers));
    }

    class Solution {
        
        public Set<Integer> resultSet = new HashSet<>();
        public int solution(String numbers) {
            
            int[] number = new int[numbers.length()];
            List<Integer> selectList = new ArrayList<>();
            
            for(int i = 0; i < numbers.length(); i++){
                number[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            }
            // Arrays.stream(board).forEach(v ->  System.out.print(v + " "));
            for(int i = 1; i <= numbers.length(); i++){
                combination(number, selectList, 0, 0, i);    
            }
            
            

            return resultSet.size();
        }

        public void combination(int[] number, List<Integer> selectList, int depth, int idx, int size){

            if(depth == size){
                // System.out.println(selectList);
                boolean[] visited = new boolean[size];
                int[] board = new int[size];
                permutation(selectList, board, visited, 0, size);
                return;
            }

            for(int i = idx; i < number.length; i++){
                selectList.add(number[i]);
                combination(number, selectList, depth+1, i+1, size);
                selectList.remove(selectList.size()-1);
            }
        }

        public void permutation(List<Integer> selectList, int[] board, boolean[] visited, int depth, int size ){

            if(depth == size){
                String concatedStr = Arrays.stream(board)
                                           .mapToObj(v -> String.valueOf(v))
                                           .collect(Collectors.joining()); 
                int concatedNum = Integer.parseInt(concatedStr);
                // System.out.println(concatedNum);
                if(isPrimeNumber(concatedNum)) {
                    resultSet.add(concatedNum);
                }
                return;
            }

            for(int i = 0; i < selectList.size(); i++){
                if(!visited[i]){
                    board[depth] = selectList.get(i);
                    visited[i] = true;
                    permutation(selectList, board, visited, depth+1, size);
                    visited[i] = false;
                }
            }
        }

        public boolean isPrimeNumber(int number){
            if(number < 2) return false;
            if(number == 2) return true;
            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number % i == 0) return false;
            }
            return true;
        }
    }
}
