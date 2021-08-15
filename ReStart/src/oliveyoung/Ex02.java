package oliveyoung;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 설명
지하철을 타고 목적지까지 이동하려 합니다. 하지만, 시작 역과 도착 역이 한 노선 위에 존재하지 않는다면,
 환승 시스템을 이용해야 합니다.
환승 시스템은 하나의 역에 노선이 두 개 이상 존재할 때 다른 노선으로 갈아탈 수 있게 해주는 시스템입니다. 
지하철 노선도를 이용해 시작 역에서 도착 역까지 최소 몇 번 환승을 해야 하는지 알아보려고 합니다.

지하철 노선도가 다음과 같다고 가정해보겠습니다.

1호선: 1 2 3 4 5 6 7 8
2호선: 2 11
3호선: 0 11 10
4호선: 3 17 19 12 13 9 14 15 10
5호선: 20 2 21
주의사항: 역 이름은 0 이상의 정수로 나타냅니다. 
역 이름이 같으면, 호선이 달라도 동일한 역입니다. 예를 들어 1호선의 2역과 5호선의 2역은 같은 역입니다. 
따라서 두 개 이상의 호선에서 등장한 역은 환승이 가능한 역입니다.

1역에서 출발해 9역에 도착하는 방법은 다음과 같습니다.

1 → 2 → 2호선 환승 → 11 → 3호선 환승 → 10 → 4호선 환승 → 15 → 14 → 9
1 → 2 → 3 → 4호선 환승 → 17 → 19 → 12 → 13 → 9
위와 같이 1번 방법은 3번의 환승이 필요하고, 2번 방법은 1번의 환승이 필요합니다. 
시작 역인 1역과 도착 역인 9역이 한 노선 위에 있지 않기 때문에, 적어도 1번 환승을 해야 합니다. 
따라서 2번 방법이 환승 횟수를 최소로 하는 방법이며, 필요한 환승 횟수는 1번입니다.

지하철 노선도를 뜻하는 문자열 배열 subway, 시작 역을 뜻하는 정수 start,
도착 역을 뜻하는 정수 end가 매개변수로 주어질 때, 최소 환승 횟수를 return 하도록 solution함수를 완성해주세요.

제한사항
1 ≤ subway의 길이 ≤ 1,000
subway의 원소는 한 노선을 뜻하며, 공백 한 개를 기준으로 정수가 나열된 형태입니다.
각 정수는 역 이름을 뜻하며, 배열 상에서 인접한 수는 인접한 역을 뜻합니다.
각 노선은 2개 이상의 역을 갖습니다.
0 ≤ 역 이름을 뜻하는 정수 ≤ 1,000,000
모든 역의 개수는 200,000개 이하입니다.
0 ≤ start ≤ 1,000,000
0 ≤ end ≤ 1,000,000
start역과 end역은 같지 않습니다.
start역과 end역은 두 개 이상의 노선이 지나가지 않습니다. 즉, 환승역이 아닙니다.
항상 시작 역으로부터 출발하여 도착 역까지 도달 가능한 경우만 주어집니다.
입출력 예
subway	start	end	result
["1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"]	1	9	1
["1 2 3 4 5 6 7 8 9 10","2 8"]	1	10	0
["0 1 2 3 4","1 12 13 14"]	2	12	1
입출력 예 설명
입출력 예 #1

문제 예시와 동일합니다.

입출력 예 #2

subway의 첫 번째 원소를 1호선, 두 번째 원소를 2호선이라고 가정합니다. 1역에서 10역까지 가는 방법은 아래와 같습니다.

1 → 2 → 2호선 환승 → 8 → 1호선 환승 → 9 → 10
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
위와 같이 두 가지 방법이 존재하며, 2번 방법으로 이동할 때 환승 횟수를 최소로 할 수 있습니다. 따라서 정답은 0입니다.

입출력 예 #3

subway의 첫 번째 원소를 1호선, 두 번째 원소를 2호선이라고 가정합니다. 2역에서 12역까지 가는 방법은 아래와 같습니다.

2 → 1 → 2호선 환승 → 12
유일하게 위 경로를 따라 이동이 가능합니다. 따라서 정답은 1입니다.
 */


public class Ex02 {
    public static void main(String[] args) {
        Ex02.Solution solution = new Ex02().new Solution();
        String[] subway = {"1 2 3 4 5 6 7 8","2 11","0 11 10","3 17 19 12 13 9 14 15 10","20 2 21"};
        int start = 1;
        int end = 9;
        solution.solution(subway, start, end);
    }

    class Solution {
        private ArrayList<ArrayList<Integer>> subwayList;
        private ArrayList<ArrayList<Integer>> stationList;
        private int resultTransferCnt;
        private boolean[] visited;
        private StringTokenizer st;

        public int solution(String[] subway, int start, int end) {
            int answer = 0;
            //지하철 호선을 가지고 있는 nodeList
            subwayList = new ArrayList<>();
            stationList = new ArrayList<>();
            visited = new boolean[subway.length];

            //지하철 정거장을 담는 list 구현
            for(int i = 0; i < subway.length; i++){
                subwayList.add(new ArrayList<>());
                ArrayList<Integer> station = new ArrayList<>();

                st = new StringTokenizer(subway[i]);
                while(st.hasMoreTokens()){
                    station.add(Integer.parseInt(st.nextToken()));
                }

                stationList.add(station);
            }

            //지하철 호선이 link되는 list 구현
            for(int i = 0; i < stationList.size(); i++){
                ArrayList<Integer> temp = stationList.get(i);
                

                for(int j = i+1; j < stationList.size(); j++){
                    ArrayList<Integer> nextNode = stationList.get(j);

                    for(int k = 0; k < temp.size(); k++){
                        boolean breakFlag = false;
                        for(int l = 0; l < nextNode.size(); l++){
                            if(temp.get(k).equals(nextNode.get(l))){
                                subwayList.get(i).add(j);
                                subwayList.get(j).add(i);
                                breakFlag = true; 
                                break;
                            }
                        }
                        if(breakFlag) break;
                    }
                }
            }

            //탐색시작할 시작점
            List<Integer> startList = findSubwayLines(start);
            for(Integer startPoint : startList){
                bfs(startPoint, end, 0);
            }

            //station link 정상 확인
            for(int i = 0; i < subwayList.size(); i++){
                System.out.println(subwayList.get(i));
            }
            
            //결과 출력
            System.out.println(resultTransferCnt);

            return answer;
        }

        public void bfs(int subwayLine, int endPoint, int transferCnt){
            Queue<int[]> q = new LinkedList<>();
            int[] curPos = {subwayLine, endPoint, transferCnt};
            visited[subwayLine] = true;
            q.add(curPos);

            while(!q.isEmpty()){
                int currSubwayLine = q.peek()[0];
                int currEndPoint = q.peek()[1];
                int currTransCnt = q.peek()[2];
                q.poll();


                //노선에 해당하는 끝 정거장이 있을때 break;
                if(findStation(currSubwayLine,currEndPoint)){
                    resultTransferCnt = currTransCnt;
                    break;
                }

                //현재 환승노드에 방문하지 않는 환승노드가 있다면 q에 넣는다
                for(int subwayLineList : subwayList.get(currSubwayLine)){
                    if(!visited[subwayLineList]){
                        visited[subwayLineList] = true;
                        int nextSubwayLine = subwayLineList;
                        int nextEndPoint = currEndPoint;
                        int nextTransCnt = currTransCnt+1;
                        
                        int[] nextPos = {nextSubwayLine,nextEndPoint,nextTransCnt};
                        q.add(nextPos);
                    }
                }
            }
        }

        public List<Integer> findSubwayLines(int station){
            List<Integer> resultSubways = new ArrayList<>();

            for(int i = 0; i < stationList.size(); i++){
                ArrayList<Integer> stationItem = stationList.get(i);
                for(int j = 0; j < stationItem.size(); j++){
                    if(station == stationItem.get(j)){
                        resultSubways.add(i);
                        break;
                    }
                }
            }

            return resultSubways;

        }

        public boolean findStation(int subwayLine, int endStation){
            for(int station : stationList.get(subwayLine)){
                if(station == endStation) return true;
            }
            return false;
        }
    }
}
