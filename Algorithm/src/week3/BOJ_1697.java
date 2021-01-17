package week3;

/**
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
 *  만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 
수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static Queue<int[]> q;
    public static boolean[] visited;
    public static int depth;
    public static int[] distance = {-1,1,0};

    public static void main(String[] args) throws Exception {
        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        visited = new boolean[100001];
        depth = 0;

        int firstInput = Integer.parseInt(st.nextToken());
        int secondInput = Integer.parseInt(st.nextToken());


        int[] postition = {firstInput, 0};
        q.add(postition);

        while(!q.isEmpty()){
            int popNum = q.peek()[0];
            int curDepth = q.peek()[1];

            q.poll();

            if(popNum == secondInput){
                depth = curDepth;
                break;
            }
            
            for(int i = 0; i < distance.length; i++){
                int nextPos = 0;
                if(distance[i] == 0){
                    nextPos = popNum*2;
                } else {
                    nextPos = popNum+distance[i];
                }
                if(nextPos > 100000 || nextPos < 0) continue;

                if(!visited[nextPos]){
                    int[] nextPosition = {nextPos, curDepth+1};
                    visited[nextPos] = true;
                    q.add(nextPosition);
                }
            }   
        }
        System.out.println(depth);
    }

}
