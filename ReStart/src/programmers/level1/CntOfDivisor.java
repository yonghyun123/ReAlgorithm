package programmers.level1;
/**
 * 두 정수 left와 right가 매개변수로 주어집니다. 
 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 
 * 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ left ≤ right ≤ 1,000
입출력 예
left	right	result
13	17	43
24	27	52
 */
public class CntOfDivisor {
    public static void main(String[] args) {
        CntOfDivisor.Solution solution = new CntOfDivisor().new Solution();
        System.out.println(solution.solution(13, 17)); 
    }

    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for(int num = left; num <= right; num++){
                int cnt = 0;
                for(int i = 1; i <= num; i++){
                    if(num % i == 0) cnt += 1;
                }
                //짝수일때
                if(cnt % 2 == 0){
                    answer += num;
                } else {
                    answer -= num;
                }
            }
            return answer;
        }
    }
}
