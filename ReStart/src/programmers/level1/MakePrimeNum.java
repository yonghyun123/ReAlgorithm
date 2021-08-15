package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class MakePrimeNum {
    public static void main(String[] args) {
        MakePrimeNum.Solution solution = new MakePrimeNum().new Solution();
        int[] nums = {1,2,7,6,4};
        System.out.println(solution.solution(nums));
    }

    class Solution {
        private List<Integer> list = new ArrayList<>();
        private int resultCnt = 0;

        public int solution(int[] nums) {
            // int answer = -1;
    
            combination(nums, 0, 3, 0);
    
            return resultCnt;
        }

        public void combination(int[] nums, int idx, int r, int depth){
            if(r == depth){
                int result = 0;
                for(int item : list){
                    result += item;
                }
                
                if(!isPrimeNumber(result)){
                    resultCnt += 1;
                };
                return;
            }

            for(int i = idx; i < nums.length; i++){
                list.add(nums[i]);
                combination(nums, i+1, r, depth+1);
                list.remove(list.size()-1);
            }
        }

        public boolean isPrimeNumber(int inputNum){
            for(int i = 2; i <= inputNum/2; i++){
                if(inputNum % i == 0) return true;
            }
            return false;
        }
    }
}
