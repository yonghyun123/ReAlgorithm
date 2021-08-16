package iportfolio;

import java.util.Arrays;

import javax.swing.JList.DropLocation;

/**
 * n개의 문이 일렬로 닫혀있습니다.

처음에는 건너뛰는 문 없이 모든 문을 하나씩 열었습니다.
그 다음에는 2의 배수인 위치에 있는 문(2, 4, 6... )을 닫았습니다.
그 다음으로는 3의 배수인 위치에 있는 문(3, 6, 9... )에 대해 닫혀있는 문은 열고, 열려있는 문은 닫았습니다.
이렇게 n번 반복한다면 마지막에 열려있는 문은 모두 몇 개일까요? n이 주어졌을 때 위 과정을 모두 거친 후,
 마지막에 열려있는 문의 개수를 반환하는 solution 함수를 완성해 주세요.

제한사항
n은 100,000,000 이하의 자연수입니다.
입출력 예
n	result
2	1
5	2
입출력 예 설명
입출력 예 #1
처음에는 1, 2번 위치의 문을 열고, 다음으로 2번 위치의 문을 닫으면 열려있는 문은 1개가 됩니다.

입출력 예 #2
처음에는 모든 문을 순서대로 엽니다. 다음으로 2, 4번 위치의 문을 닫습니다. 
다시 3번 위치의 문을 닫습니다. 그다음 4번 위치의 문을 엽니다. 마지막으로 5번 위치의 문을 닫으면 열려있는 문은 2개가 됩니다.
 * 
 * 
 */
public class Ex01 {
    
    public static void main(String[] args) {
        Ex01.Solution solution = new Ex01().new Solution();
        System.out.println(solution.solution(5)); 
    }

    class Solution{
        private boolean[] doors;
        private int dp[];

        public int solution(int n) {
            int answer = 0;
            //false일때 문을 연 상태
            doors = new boolean[n+1];
            //-1은 문을 연 상태
            dp = new int[100000001];
            Arrays.fill(dp, -1);

            for(int idx = 2; idx <= n; idx+=2){
                doors[idx] = true;
                dp[idx] = 1;
            }
            //2의배수는 문을 닫은 상태(true)

            // for(int i  = 3; i <= n; i++){
            //     for(int j = 1; i*j <= n; j++){
            //         if(doors[i*j]) doors[i*j] = false;
            //         else doors[i*j] = true;;
            //     }
            // }
            if(n >= 3){
                dp[3] = dp[3]*-1;
                dp[5] = dp[5]*-1;
            }
            for(int i = 2; i <= n; i++){
                dp[i*2] = dp[i]*-1;
            }

            for(int i = 1; i <= n; i++){
                if(dp[i] == -1) {
                    // System.out.println("i="+i);
                    answer += 1;
                }
            }
            

            return answer;
        }
    }
}
