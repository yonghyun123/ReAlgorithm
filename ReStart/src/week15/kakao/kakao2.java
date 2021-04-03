package week15.kakao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 봇을 이용하여 여러 종류의 완제품을 만드는 공장을 운영하려고 합니다. 로봇 한 대는 부품 한 종류만 처리할 수 있으며, 
 * 완제품의 종류에 따라 필요한 부품이 다를 수 있습니다. 이때, 로봇 r대로 최대한 다양한 완제품을 만들려 합니다.

예를 들어, 각 완제품을 만들 때 다음과 같은 부품이 필요하고, 살 수 있는 로봇은 최대 두 대라고 가정하겠습니다(번호는 0번부터 시작합니다).

완제품 번호	필요한 부품 번호
0	0
1	0, 1
2	0, 1
3	0, 2
4	0, 1
5	1, 2
두 로봇을 이용해 완제품을 만드는 경우는 모두 다음과 같습니다.

구매할 첫 번째 로봇	구매할 두 번째 로봇	만들 수 있는 완제품
부품 0을 처리하는 로봇	부품 1을 처리하는 로봇	0, 1, 2, 4번 완제품
부품 0을 처리하는 로봇	부품 2를 처리하는 로봇	0, 3번 완제품
부품 1을 처리하는 로봇	부품 2를 처리하는 로봇	5번 완제품
따라서, 최대한 다양한 완제품을 만들려면 부품 0을 처리하는 로봇과 부품 1을 처리하는 로봇을 구매해야 합니다.

완제품을 만드는 데 필요한 부품의 정보 needs와 최대로 구매 가능한 로봇 수 r이 매개변수로 주어질 때, 
최대 몇 종류의 완제품을 만들 수 있는지 return 하도록 solution 함수를 완성해 주세요.
 */
public class kakao2 {

    public static boolean[] visited;
    public static int[][] board;
    public static int[] calOfFlat;


    public static void main(String[] args) {
        int n =5;
        int []passenger = {1,1,2,3,4};
        int [][] train = {
            {1,2},{1,3},{1,4},{1,5}
        };
        visited = new boolean[100000];
        int[] result = solution(n, passenger, train);
         System.out.print(result[0]);
         System.out.println(result[1]);
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];

        board = new int[n][n];
        calOfFlat = new int[n];
        for(int i =0 ; i < n-1; i++){
            int trainFirst = train[i][0]-1;
            int trainSecond = train[i][1]-1;
            // System.out.println(trainFirst + " " +trainSecond);
            board[trainFirst][trainSecond] = 1;
            board[trainSecond][trainFirst] = 1;
        }

        // for(int i =0 ; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int startNode = 0;
        int max = 0;
        int idx = -1;
        bfs(n,startNode,passenger);

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(calOfFlat[i] < calOfFlat[j]){
                    max = calOfFlat[j];
                    idx = j;

                }
            }
        }
        if(idx == -1) {
            max = calOfFlat[0];
            idx = 0;
        };
        answer[0] = idx+1;
        answer[1] = max;

        return answer;
    }

    public static void bfs(int n, int startNode, int[] passenger){
        Queue<int[]> q = new LinkedList<>();
        int numOfPass = passenger[startNode];
        int[] depthNode = {startNode, numOfPass};
        // calOfFlat = new int[n];

        calOfFlat[startNode] = numOfPass;

        visited[startNode] = true;

        q.add(depthNode);

        while(!q.isEmpty()){
            int curNode = q.peek()[0];
            int curNumOfPass = q.peek()[1];

            q.poll();

            for(int i = 0; i < n; i++){
                if(!visited[i] && board[curNode][i] == 1){
                    int nextNumOfPass = curNumOfPass + passenger[i];
                    calOfFlat[i] = nextNumOfPass;
                    int nextNode = i;
                    visited[i] = true;
                    int[] nextDepth = {nextNode, nextNumOfPass};
                    q.add(nextDepth);
                    
                }
            }
        }

    }

}
