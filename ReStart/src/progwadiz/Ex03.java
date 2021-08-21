package progwadiz;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 0 이상의 정수로 이루어진 배열 arr이 주어집니다. 당신은 arr과 길이가 같으며 모든 원소가 0으로 이루어진 배열 A를 다음 작업을 통해 
 * arr과 같게 만들려고 합니다.

인덱스 i부터 j까지의 구간에 속하는 모든 원소에 임의의 양의 정수 value를 더합니다.
0 ≤ i ≤ j < A의 길이
예를 들어 arr이 [1, 2, 4, 8, 4, 2, 1] 일 때, 다음 과정을 통해 A를 arr과 같게 만들 수 있습니다.

i	j	value	A
-	-	-	[0, 0, 0, 0, 0, 0, 0]
0	6	1	[1, 1, 1, 1, 1, 1, 1]
1	5	1	[1, 2, 2, 2, 2, 2, 1]
2	4	2	[1, 2, 4, 4, 4, 2, 1]
3	3	4	[1, 2, 4, 8, 4, 2, 1]
위와 같이, A를 arr과 같게 만들려면 최소 4번의 작업이 필요하며, 이보다 적은 횟수로 작업을 마칠 수 없습니다.

정수 배열 arr이 매개변수로 주어질 때, 0으로 이루어진 배열을 arr과 같은 배열로 만들기 위해 필요한 최소 작업 
횟수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ arr의 길이 ≤ 100,000
0 ≤ arr의 원소 ≤ 1,000,000,000
입출력 예
arr	result
[1, 2, 4, 8, 4, 2, 1]	4
[1, 3, 5, 7, 6, 8, 9, 5, 1]	7
[10, 0, 10, 0, 10, 0]	3
[5, 4, 5, 4, 5, 5]	4
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

다음과 같은 과정을 거쳐 작업을 마칠 수 있습니다.

i	j	value	A
-	-	-	[0, 0, 0, 0, 0, 0, 0, 0, 0]
0	8	1	[1, 1, 1, 1, 1, 1, 1, 1, 1]
1	7	2	[1, 3, 3, 3, 3, 3, 3, 3, 1]
2	7	2	[1, 3, 5, 5, 5, 5, 5, 5, 1]
3	6	1	[1, 3, 5, 6, 6, 6, 6, 5, 1]
3	3	1	[1, 3, 5, 7, 6, 6, 6, 5, 1]
5	6	2	[1, 3, 5, 7, 6, 8, 8, 5, 1]
6	6	1	[1, 3, 5, 7, 6, 8, 9, 5, 1]
위 방법 외에 다른 방법으로도 작업을 마칠 수 있으나, 7보다 적은 횟수로 작업을 마치는 방법은 없습니다. 따라서 7을 return 합니다.

입출력 예 #3

다음과 같은 과정을 거쳐 작업을 마칠 수 있습니다.

i	j	value	A
-	-	-	[0, 0, 0, 0, 0, 0]
0	0	10	[10, 0, 0, 0, 0, 0]
2	2	10	[10, 0, 10, 0, 0, 0]
4	4	10	[10, 0, 10, 0, 10, 0]
따라서 3을 return 합니다.

입출력 예 #4

다음과 같은 과정을 거쳐 작업을 마칠 수 있습니다.

i	j	value	A
-	-	-	[0, 0, 0, 0, 0, 0]
0	5	4	[4, 4, 4, 4, 4, 4]
0	0	1	[5, 4, 4, 4, 4, 4]
2	2	1	[5, 4, 5, 4, 4, 4]
4	5	1	[5, 4, 5, 4, 5, 5]
따라서 4를 return 합니다.
 */
public class Ex03 {
    
    public static void main(String[] args) {
        Ex03.Solution solution = new Ex03().new Solution();
        int[] arr = {5, 4, 5, 4, 5, 5};
        System.out.println(solution.solution(arr)); 

    }

    class Solution {
        private int[] inputArr;
        private boolean[] visited;
        public int solution(int[] arr) {
            int answer = 0;

            //배열 복사해놓고 시작
            
            inputArr = Arrays.copyOf(arr, arr.length);
            visited = new boolean[arr.length];

            for(int i = 0;i < inputArr.length; i++){
                System.out.print(inputArr[i] + " ");
            }

            int a = 0;
            while(a<10){
                int minSubstract = 1000000001;
                int idx = 0;
                for(int i = 0; i < inputArr.length; i++){
                    if(inputArr[i] != 0){
                        // minSubstract = Math.min(inputArr[i], minSubstract);
                        if(inputArr[i] < minSubstract){
                            minSubstract = inputArr[i];
                            idx = i;
                        }
                    }
                }

                //최소값 판단 후 배열 값 전체 수정
                calculateArray(minSubstract,idx);
                for(int i = 0; i < inputArr.length; i++){
                    System.out.print(visited[i] + " ");
                    System.out.println();
                    System.out.print(inputArr[i] + " ");
                }

                for(int i = 0; i < inputArr.length; i++){
                    visited[i] = false;
                }
                answer += 1;
                a++;
            }

            return answer;
        }

        public void calculateArray(int substractValue, int idx){
            if(idx < 0 || idx >= inputArr.length) return;

            visited[idx] = true;
            if(!visited[idx] && inputArr[idx] != 0){
                calculateArray(substractValue, idx+1);
                calculateArray(substractValue, idx-1);   
                return;    
            }
            return;

        }

        public void subArray(int substractValue){
            for(int i = 0; i < inputArr.length; i++){
                if(visited[i]){
                    if(inputArr[i]!=0){
                        inputArr[i] -= substractValue;
                    }
                }
            }
        }
        
        // 배열이 모두 0인지 판단
        public boolean isAllZero(){

            for(int i = 0; i < inputArr.length; i++){
                if(inputArr[i] != 0) return false;
            }
            return true;
        }
    }

}
