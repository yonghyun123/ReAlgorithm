package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javafx.scene.layout.Border;

/**
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 * 
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 * 
 * A는 B와 친구다. B는 C와 친구다. C는 D와 친구다. D는 E와 친구다. 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을
 * 작성하시오.
 * 
 * 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
 * 
 * 5 4 
 * 0 1 
 * 1 2 
 * 2 3 
 * 3 4
 * 
 * 1
 * 
 * bfs 시간초과
 * 일단 배열 시간초과 -> arraylist 변경
 * 
 * 
 */
public class BOJ_13023 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static boolean[] visited;
    private static List<Integer>[] board;
    private static int n, relationCnt;
    private static int answerFlag = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        relationCnt = Integer.parseInt(st.nextToken());
        board = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0 ; i <relationCnt; i++){
            board[i] = new ArrayList<>();
        }

        for(int i = 0; i < relationCnt; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row].add(col);
            board[col].add(row);
        }
        // printArr();
        //  bfs(0); bfs 못품..

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, 0);
                if(answerFlag == 1) break;
            }
        }


        System.out.println(answerFlag); 
        

    }

    // public static void bfs(int node){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(node);
                         
        
    //     while(!q.isEmpty()){
    //         int curNode = q.poll();
    //         visited[curNode] = true;   
    //         // printVisited();
    //         if(isAnswer() == 1){
    //             answerFlag = 1;
    //             break;
    //         } 

    //         for(int i = 0; i < visited.length; i++){
    //             if(curNode!=i && !visited[i] && board[curNode][i] == 1){
    //                 q.add(i);
    //             }
    //         }
    //     }
    // }

    public static void dfs(int start, int depth){
        visited[start] = true;
        if(depth == 4){
            answerFlag = 1;
            return;
        }
        for(int i = 0; i < visited.length; i++){
            if(!visited[i] && board[start][i] == 1){
                dfs(i, depth + 1);
                if(answerFlag == 1) break;
            }
        }
        visited[start]= false;
    }

    public static int isAnswer(){
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false) return 0;
        }
        return 1;
    }

    public static void printArr(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printVisited(){
        for(int i = 0; i < n; i++){
            System.out.print(visited[i]+" ");
        }
        System.out.println();
    }
}
