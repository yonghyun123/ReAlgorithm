package Zoom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ex03 {
    public static void main(String[] args) {
        ex03.Solution solution = new ex03().new Solution();
        //[1, 0, 5],[2, 2, 2],[3, 3, 1],[4, 4, 1],[5, 10, 2]
        //[1, 2, 10], [2, 5, 8], [3, 6, 9], [4, 20, 6], [5, 25, 5]
        int[][] data = {
            {1,2,10},
            {2,5,8},
            {3,6,9},
            {4,20,6},
            {5,25,5}
        };
        int[] result = solution.solution(data);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    class Solution {

        public Queue<int[]> q = new LinkedList<>();
        public List<int[]> waitQ =  new LinkedList<>();
        public List<Integer> resultList;

        public int[] solution(int[][] data) {
            int[] answer = {};
            resultList = new ArrayList<>();
            int timePerPage = 0;
            int totalTime = 0;
            int min_page = 100001;
            
            q.add(data[0]);
            int maxTime = 0;
            for (int i = 0; i < data.length; i++) {
                maxTime = maxTime + data[i][1];
            }

            while (/*!q.isEmpty()  || resultList.size() != data.length*/ maxTime != totalTime) {
                for (int i = 1; i < data.length; i++) {
                    // 해당 작업 끝나기 전에 요청시각에 맞는 작업 waitingQ에 적재
                    if (totalTime == data[i][1]) {
                        if(min_page > data[i][2]) min_page = data[i][2];
                        waitQ.add(data[i]);
                        System.out.println("wait " + data[i][0] + "번");
                    }
                }
                // 각 문서에 페이지수랑 시간이 같아지면 pop
                int numOfPage = 0;
                if(q.isEmpty() && !waitQ.isEmpty()){
                    // q.add(waitQ.get(0));
                    // waitQ.remove(0);
                    int calPage = 100001;
                    int idx = -1;
                    for (int i = 0; i < waitQ.size(); i++) {
                        if (calPage > waitQ.get(i)[2]) {
                            calPage = waitQ.get(i)[2];
                            idx = i;
                        }
                    }
                    q.add(waitQ.get(idx));
                    waitQ.remove(idx);
                }

                if (!q.isEmpty()) {
                    numOfPage = q.peek()[2];
                    if (timePerPage == numOfPage) {
                        // 각 작업에 페이지 인쇄가 끝나면 q.pop() 후 해당 작업 list에 적재
                        // 각 작업에 대한 시간 초기화 및 watingQ에 있는 작업 적재
                        
                        resultList.add(q.peek()[0]);
                        int[] tmp = q.poll();
                        //chk++;
                        System.out.println("tmp " + tmp[0]);
                        //System.out.println("waitQ 길이 : " + waitQ.size());
                        if (!waitQ.isEmpty()) {
                            min_page = 100001;
                            int idx = -1;
                            for (int i = 0; i < waitQ.size(); i++) {
                                if (min_page > waitQ.get(i)[2]) {
                                    min_page = waitQ.get(i)[2];
                                    idx = i;
                                }
                            }
                            q.add(waitQ.get(idx));
                            waitQ.remove(idx);
                            timePerPage = 0;
                        }
                        timePerPage = 0;
                    }
                    timePerPage += 1;
                }
                totalTime += 1;
            }

            answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i);
            }

            return answer;
        }
    }
}
