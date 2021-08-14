package week34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 실패율
 * 
 * 실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4,4,4,4,4]	[4,1,2,3]
 */

public class ProgFailRate {
    

    public static void main(String[] args) {
        ProgFailRate.Solution solution = new ProgFailRate().new Solution();
        int N = 4;
        int[] stages = {4,4,4,4};

        System.out.println(solution.solution(N, stages));
        for(int item: solution.solution(N, stages)){
            System.out.print(item+ " ");
        }
        System.out.println();
        
    }

    class Solution {
        private Map<Integer,Double> map;
        public int[] solution(int N, int[] stages) {
            int[] answer = {};
            map = new HashMap<>();
            
            for(int stage = 1; stage <= N; stage++){

                int cntClear = 0;
                int totalStage = 0;
                double failRate = 0;
                for(int clearNum = 0; clearNum < stages.length; clearNum++){
                    if(stage <= stages[clearNum]){
                        totalStage += 1;
                    }
                    if(stage == stages[clearNum]){
                        cntClear += 1;
                    }
                }
                // System.out.println("cntClear="+cntClear+", totalStage="+totalStage);
                if(totalStage != 0){
                    failRate = (double)cntClear / (double)totalStage;
                } else {
                    failRate = 0;
                }
                map.put(stage, failRate);
            }
            
            List<Entry<Integer,Double>> entry = new ArrayList<>(map.entrySet());

            Collections.sort(entry, (t1,t2) -> {
                return t2.getValue().compareTo(t1.getValue());
            });

            answer = new int[entry.size()];

            for(int i = 0; i < entry.size(); i++){
                answer[i] = entry.get(i).getKey();
            }
            

            return answer;
        }
    }
}
