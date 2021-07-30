package week32;

import java.util.Arrays;

/**
 * k번째 수
 * 
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

public class ProgNumberOfK {
    public static void main(String[] args) {
        ProgNumberOfK.Solution solution =  new ProgNumberOfK().new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };
        int[] result = solution.solution(array, commands);
        for(int i = 0; i < commands.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    class Solution{
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            int[] result = new int[commands.length];

            for(int i = 0; i <commands.length; i++){
                int[] command = commands[i];

                int firstIdx = command[0]-1;
                int lastIdx = command[1]-1;
                int findIdx = command[2]-1;

                int arraylength = lastIdx - firstIdx +1;
                answer = new int[arraylength];

                for(int j = firstIdx,k = 0; j <= lastIdx; j++,k++){
                    answer[k] = array[j];
                }
                Arrays.sort(answer);
                result[i] = answer[findIdx];

            }
            return result;
        }
    }
}
