package programmers.level1;

/**
 * 0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다. 
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class plusOffNumber {
    public static void main(String[] args) {
        plusOffNumber.Solution solution = new plusOffNumber().new Solution();
        int[] numbers = {5,8,4,0,6,7,9};
        ;
        System.out.println(solution.solution(numbers));
    }

    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            boolean[] visited = new boolean[10];
            for(int item: numbers){
                visited[item] = true;
            }
            for(int i = 0; i < 10; i++){
                if(!visited[i]) answer+=i;
            }

            return answer;
        }
    }
}
