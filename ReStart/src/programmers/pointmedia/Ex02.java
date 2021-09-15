package programmers.pointmedia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * N개의 마을로 이루어진 나라가 있습니다. 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다. 
 * 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다.
 *  도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 
 * 각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다. 
 * 다음은 N = 5, K = 3인 경우의 예시입니다.


위 그림에서 1번 마을에 있는 음식점은 [1, 2, 4, 5] 번 마을까지는 3 이하의 시간에 배달할 수 있습니다.
 그러나 3번 마을까지는 3시간 이내로 배달할 수 있는 경로가 없으므로 3번 마을에서는 주문을 받지 않습니다. 
 따라서 1번 마을에 있는 음식점이 배달 주문을 받을 수 있는 마을은 4개가 됩니다.
마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때,
 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
마을의 개수 N은 1 이상 50 이하의 자연수입니다.
road의 길이(도로 정보의 개수)는 1 이상 2,000 이하입니다.
road의 각 원소는 마을을 연결하고 있는 각 도로의 정보를 나타냅니다.
road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다.
a, b(1 ≤ a, b ≤ N, a != b)는 도로가 연결하는 두 마을의 번호이며, c(1 ≤ c ≤ 10,000, c는 자연수)는 도로를 지나는데 걸리는 시간입니다.
두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
K는 음식 배달이 가능한 시간을 나타내며, 1 이상 500,000 이하입니다.
임의의 두 마을간에 항상 이동 가능한 경로가 존재합니다.
1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return 하면 됩니다.
입출력 예
N	road	K	result
5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4
6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
 */
public class Ex02 {
    public static void main(String[] args) {
        Ex02.Solution solution = new Ex02().new Solution();
        //[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]
        int N = 6;
        int[][] road = 	{
            {1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}
        };
        int K = 4;
        System.out.println(solution.solution(N, road, K)); 
    }

    class Solution {
        private ArrayList<ArrayList<Integer>> nodeList;
        private ArrayList<Integer> resultNodes;
        private boolean[] visited;
        private int[][] distanceBoard;
        

        public int solution(int N, int[][] road, int k) {
            // int answer = 0;
            nodeList = new ArrayList<>();
            resultNodes = new ArrayList<>();
            visited = new boolean[N];
            distanceBoard = new int[N][N];


            for(int i = 0; i < N; i++){
                nodeList.add(new ArrayList<>());
            }

            for(int i = 0; i < road.length; i++){
                int preNode = road[i][0];
                int nextNode = road[i][1];
                int distance = road[i][2];
                nodeList.get(preNode-1).add(nextNode-1);
                nodeList.get(nextNode-1).add(preNode-1);
                //이미 존재한다면 낮은수로 치환
                if(distanceBoard[preNode-1][nextNode-1] != 0){
                    distanceBoard[preNode-1][nextNode-1] = Math.min(distanceBoard[preNode-1][nextNode-1], distance);
                    distanceBoard[nextNode-1][preNode-1] = Math.min(distanceBoard[preNode-1][nextNode-1], distance);
                } else {
                    distanceBoard[preNode-1][nextNode-1] = distance;
                    distanceBoard[nextNode-1][preNode-1] = distance;
                }
            }

            // System.out.println(nodeList);
            // for(int i = 0; i < distanceBoard.length; i++){
            //     for(int j = 0; j < distanceBoard[i].length; j++){
            //         System.out.print(distanceBoard[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            bfs(0, k, 0);
            // System.out.println(resultNodes);

    
            return resultNodes.size();
        }

        public void bfs(int startNode, int k, int startDistance){

            Queue<int[]> q = new LinkedList<>();
            int[] startPos = {startNode, startDistance};

            //q에 첫번째 노드 및 현재 거래 담는다
            q.add(startPos);
            resultNodes.add(startNode+1);
            visited[startNode] = true;

            while(!q.isEmpty()){
                int curNode = q.peek()[0];
                int curDistance = q.peek()[1];
                q.poll();

                //자신과 연결된 노드 탐색
                for(int node : nodeList.get(curNode)){
                    if(!visited[node]){
                        int nextDistance = curDistance + distanceBoard[curNode][node];
                        if(nextDistance <= k ){
                            visited[node] = true;
                            // System.out.println("curNode=" + node + ", nextD=" + nextDistance);
                            int[] nextNodes = {node, nextDistance};
                            q.add(nextNodes);
                            if(resultNodes.contains(node+1)) continue;
                            resultNodes.add(node+1);
                        }
                    }
                }
            }

        }
    }
}
