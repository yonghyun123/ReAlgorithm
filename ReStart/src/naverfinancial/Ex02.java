package naverfinancial;

import java.util.ArrayList;
import java.util.List;


/**
 * 각 자릿수 수의 합이 같은 두개의 수를 골라서 더해서 최대값을 더하자
 * 각 자릿수 수의 합이 같은 수가 없으면 return -1
 */
public class Ex02 {
    public static void main(String[] args) {
        //{42, 33, 60}
        //{51, 32, 43}
        int[] temp = {51, 32, 43};

        Ex02.Solution solution = new Ex02().new Solution();
        System.out.println(solution.solution(temp));
    }

    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            List<Integer> digitList = new ArrayList<>();
            int result = -1;

            for(int i = 0; i < A.length; i++){
                String inputA = String.valueOf(A[i]);
                int sum = 0;
                //각자릿수의 합을 계산해서 리스트에 담는다.
                for(int j = 0; j < inputA.length(); j++){
                    sum += Integer.parseInt(String.valueOf(inputA.charAt(j)));
                }
                
                digitList.add(sum);
            }

            System.out.println(digitList);

            for(int i = 0; i < digitList.size(); i++){
                for(int j = i+1; j < digitList.size(); j++){
                    //자리수가 같은것을 만났을때, 
                    if(digitList.get(i) == digitList.get(j)){
                        result = Math.max(A[i]+A[j], result);
                    }
                }
            }

            return result;
        }
    }
}
