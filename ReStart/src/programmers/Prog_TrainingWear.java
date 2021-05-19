package programmers;


/**
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 */
public class Prog_TrainingWear {
    public static void main(String[] args) {
        Solutions solution = new Solutions();
        int n = 6;
        int[] lost = {1,2,3,4,5};
        int[] reserve = {6};

        int result = 0;
        result = solution.solution(n, lost, reserve);

        System.out.println(result);
        
    }
}


class Solutions{


    public int solution(int n, int[] lost, int[] reserve){
        int answer=0;

        int[] stateTraining = new int[n];

        for(int i = 0; i < lost.length; i++){
            stateTraining[lost[i]-1] -= 1;
        }

        for(int i = 0; i < reserve.length; i++){
            stateTraining[reserve[i]-1] += 1;
        }

        for(int i = 0; i < stateTraining.length; i++){
            if(stateTraining[i] < 0){
                if(i != stateTraining.length-1 && stateTraining[i+1] > 0){
                    stateTraining[i] += 1;
                    stateTraining[i+1] -= 1;
                } else if(i != 0 && stateTraining[i-1] > 0){
                    stateTraining[i] += 1;
                    stateTraining[i-1] -= 1;
                }
            }
        }

        for(int i = 0; i < stateTraining.length; i++){
            if(stateTraining[i] >= 0){
                answer +=1;
            }
        }
        
        return answer;

    }
}
