package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤
 * 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로
 * 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * 
 * 입력 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 * 
 * 출력 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * 
 * 둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.
 */

public class BOJ_13913 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static Queue<int[]> q;
    public static boolean[] visited;
    public static int[] record,result;
    public static int depth;
    public static int[] distance = {-1,1,0};

    public static void main(String[] args) throws Exception {
        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        visited = new boolean[100001];
        record = new int[100001];
        List<Integer> result = new ArrayList<>();

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
                    record[nextPos] = popNum;
                    q.add(nextPosition);
                }
            }   
        }
        int idx = secondInput;
        while(idx != firstInput){
            result.add(idx);
            idx = record[idx];
        }
        result.add(firstInput);


        System.out.println(depth);
        for(int i = result.size()-1; i >=0; i--){
            System.out.print(result.get(i) + " ");
        }
    }  
}
