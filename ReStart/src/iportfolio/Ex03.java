package iportfolio;
/**
 * 
 * n개의 공을 바구니에 나누어 담으려고 합니다. 이 때, 각 바구니에는 K2 개의 공을 담아야 합니다. (K는 자연수)
바구니에 나누어 담는 방법은 여러가지가 될 수 있지만 가장 적은 바구니를 이용해서 나누어 담는 방법을 찾으려고 합니다.
공의 개수 n이 매개변수로 주어질 때, 필요한 바구니 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.

제한사항
공의 개수 n : n은 1이상 100,000이하의 자연수
입출력 예
n	result
9	1
15	4
41	2
입출력 예 설명
입출력 예 #1
9개의 공을 1개의 바구니에 담으면 32 = 9를 만족하며 1개보다 더 적은 바구니를 사용하는 방법은 없습니다.

입출력 예 #2
15개의 공을 4개의 바구니에 각각 1, 1, 4, 9개씩 나누어 담으면 12 + 12 + 22 + 32 = 15를
 만족하며 4개보다 더 적은 바구니를 사용하는 방법은 없습니다.

입출력 예 #3
41개의 공을 2개의 바구니에 각각 16, 25개씩 나누어 담으면 4^2 + 5^2 = 41를
 만족하며 2개보다 더 적은 바구니를 사용하는 방법은 없습니다.
 */

public class Ex03 {
    public static void main(String[] args) {
        Ex03.Solution solution = new Ex03().new Solution();
        System.out.println(solution.solution(41)); 
    }
    class Solution{
        private int resultMin = 100;
        
        public int solution(int n) {
            
            int substractValue = (int) Math.sqrt(n);
            int startN = n- substractValue*substractValue;
            int resultCnt = 1;

            // dfs(startN,substractValue,1);
            while(startN != 0){
                substractValue = (int) Math.sqrt(startN);
                while(startN < substractValue*substractValue){
                    substractValue -= 1;
                }
                startN -= substractValue*substractValue;
                resultCnt += 1;
            }

            return resultCnt;
        }

        // public void dfs(int curValue, int substractValue, int depth){
            
        //     if(curValue == 0) {
        //         //break 포인트
        //         if(resultMin > depth){
        //             resultMin = depth;
        //         }
        //         return;
        //     }
        //     if(curValue < 0) return;

        //     int nearValue = (int) Math.sqrt(curValue);
        //     for(int i = nearValue; i >=1; i++){
        //         if(curValue >= (i * i) ){
        //             dfs(curValue -(i*i), i, depth+1);
        //         }
        //     }
        // }
    }
}
