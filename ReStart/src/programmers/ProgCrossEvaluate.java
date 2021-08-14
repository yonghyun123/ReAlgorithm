package programmers;
/**
 * 상호평가
 * 
 * 대학 교수인 당신은, 상호평가를 통하여 학생들이 제출한 과제물에 학점을 부여하려고 합니다. 
 * 아래는 0번부터 4번까지 번호가 매겨진 5명의 학생들이 자신과 다른 학생의 과제를 평가한 점수표입니다.

No.	0	1	2	3	4
0	100	90	98	88	65
1	50	45	99	85	77
2	47	88	95	80	67
3	61	57	100	80	65
4	24	90	94	75	65
평균	45.5	81.25	97.2	81.6	67.8
학점	F	B	A	B	D
위의 점수표에서, i행 j열의 값은 i번 학생이 평가한 j번 학생의 과제 점수입니다.

0번 학생이 평가한 점수는 0번 행에담긴 [100, 90, 98, 88, 65]입니다.
0번 학생은 자기 자신에게 100점, 1번 학생에게 90점, 2번 학생에게 98점, 3번 학생에게 88점, 4번 학생에게 65점을 부여했습니다.
2번 학생이 평가한 점수는 2번 행에담긴 [47, 88, 95, 80, 67]입니다.
2번 학생은 0번 학생에게 47점, 1번 학생에게 88점, 자기 자신에게 95점, 3번 학생에게 80점, 4번 학생에게 67점을 부여했습니다.
당신은 각 학생들이 받은 점수의 평균을 구하여, 기준에 따라 학점을 부여하려고 합니다.
만약, 학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외하고 평균을 구합니다.

0번 학생이 받은 점수는 0번 열에 담긴 [100, 50, 47, 61, 24]입니다. 자기 자신을 평가한 100점은 자신이 받은 점수 중에서
 유일한 최고점이므로, 평균을 구할 때 제외합니다.
0번 학생의 평균 점수는 (50+47+61+24) / 4 = 45.5입니다.
4번 학생이 받은 점수는 4번 열에 담긴 [65, 77, 67, 65, 65]입니다. 자기 자신을 평가한 65점은 자신이 받은 점수 중에서 최저점이지만 같은 점수가 2개 더 있으므로, 유일한 최저점이 아닙니다. 따라서, 평균을 구할 때 제외하지 않습니다.
4번 학생의 평균 점수는 (65+77+67+65+65) / 5 = 67.8입니다.
제외할 점수는 제외하고 평균을 구한 후, 아래 기준에 따라 학점을 부여합니다.
 */
public class ProgCrossEvaluate {
    
    //[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]
    //[75, 50, 100], [75, 100, 20], [100, 100, 20]] "BBF"
    public static void main(String[] args) {
        ProgCrossEvaluate.Solution solution = new ProgCrossEvaluate().new Solution();
        int[][] inputArr = {
            {50, 51, 49},
            {49, 50, 51},
            {51, 49, 50}
        };
        System.out.println(solution.solution(inputArr));        
    }

    class Solution {
        
        public String solution(int[][] scores) {
            String answer = "";
            
             
            for(int i = 0; i < scores.length; i++){
                int sum = 0;
                int max = 0;
                int min = 100;
                double avg = 0;
                int maxIdx = -1;
                int minIdx = -1;
                int dividedN = scores.length;
                int selfScore = scores[i][i];
                boolean isSelf = true;
                for(int j = 0; j < scores[i].length; j++){
                    sum += scores[j][i];
                    // System.out.println("i="+i+", sum="+sum+", maxIdx="+maxIdx+", minIdx="+minIdx);
                    // System.out.println("max="+max+", scores[j][i]="+scores[j][i]);
                    if(max <= scores[j][i]){
                        maxIdx = j;
                        max = scores[j][i];
                    }

                    if(min >= scores[j][i]){
                        minIdx = j;
                        min = scores[j][i];
                    }
                    if(i != j && selfScore == scores[j][i]) isSelf = false;
                }
                // System.out.println("i="+i+", sum="+sum+", maxIdx="+maxIdx+", minIdx="+minIdx);
                

                if(maxIdx == i && isSelf){
                    sum -= max;
                    dividedN = scores.length-1;
                }

                if(minIdx == i && isSelf){
                    sum -= min;
                    dividedN = scores.length-1;
                } 
                avg = sum / dividedN;
                
                // System.out.println("i="+i+", sum="+sum+", maxIdx="+maxIdx+", minIdx="+minIdx+", avg="+avg);
                answer += calculateGrade(avg);

            }
            return answer;
        }

        public String calculateGrade(double avg){
            if(avg >= 90 ) return "A";
            else if( avg >= 80) return "B";
            else if( avg >= 70) return "C";
            else if( avg >= 50) return "D";
            else return "F";
        }
    }
}
