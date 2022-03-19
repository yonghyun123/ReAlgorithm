package socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Ex01 {
    /**
     *             {5,4,6},
            {5,2,5},
            {0,4,2},
            {2,3,3},
            {1,2,7},
            {0,1,3}

            {0,1,2},
            {0,2,3}


     */
    public static void main(String[] args) {
        Ex01.Solution solution = new Ex01().new Solution();
        int n = 4;
        int k = 10;
        int [][]roads= {
            {0,1,2},
            {0,2,3}
        };

        
        System.out.println(solution.solution(n, k, roads)[0] + ", "+ solution.solution(n, k, roads)[1]);
    }

    class Solution{
        Set<Integer> resultSet = new HashSet<>();
        public int[] solution(int n, int k, int[][] roads){
            int[] answer = {};

            ArrayList<ArrayList<int[]>> roadList = new ArrayList<ArrayList<int[]>>();
            //입력값 정렬
            Arrays.sort(roads, (o1, o2) -> o1[0]- o2[0]);

            //리스트에 넣기
            for(int i = 0; i < n; i++){
                roadList.add(new ArrayList<int[]>());
            }

            //리스트 셋팅 완료
            for(int i = 0; i < roads.length; i++){
                int[] firstMinutes = {roads[i][1], roads[i][2]};
                int[] secondMinutes = {roads[i][0], roads[i][2]};
                roadList.get(roads[i][0]).add(firstMinutes);
                roadList.get(roads[i][1]).add(secondMinutes);
            }

            // showList
            // showList(roadList);

            //bfs 탐색 시작
            onTimeBfs(roadList, 0, k);

            // answer = new int[resultSet.size()];

            answer = resultSet.stream().mapToInt(v -> v).toArray();
            if(answer.length == 0) {
                answer = new int[]{-1};
            }
            return answer;
        }

        public void onTimeBfs(ArrayList<ArrayList<int[]>> roadList, int startNode, int limitTime){
            Queue<int[]> q = new LinkedList<>();
            int startTime = 0;
            int[] currPosInfo = {startNode, limitTime, startTime};
            
            q.add(currPosInfo);
            
            while(!q.isEmpty()){

                int currNode = q.peek()[0];
                // int currLimitTime = q.peek()[1];
                int currTime = q.peek()[2];
                q.poll();

                // limit 시간을 넘거나 똑같으면 그대로 pop
                for(int[] roadInfo : roadList.get(currNode)){
                    int nextNode = roadInfo[0]; //다음 노드
                    int nextTime = currTime + roadInfo[1];
                    int[] nextPosInfo = {nextNode, limitTime, nextTime};

                    if(nextTime < limitTime){
                        q.add(nextPosInfo);
                    }
                    else if(nextTime == limitTime){
                        resultSet.add(nextNode);
                    } 
                }
            }
        }
        public void showList(ArrayList<ArrayList<int[]>> roadList){
            for(ArrayList<int[]> item : roadList){
                for(int[] road : item) {
                    System.out.println(road[0] +", "+ road[1]);
                    
                }
                System.out.println();
            }

        }
    }
}
