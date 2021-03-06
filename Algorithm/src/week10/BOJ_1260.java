package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * 
 * 
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * 4 5 1
	1 2
	1 3
	1 4
	2 4
	3 4
	
	1 2 4 3
	1 2 3 4
 */
public class BOJ_1260 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[][] inputArr;
	private static boolean[] visited;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		inputArr = new int[nodeNum][nodeNum];
		visited = new boolean[nodeNum];
		
		for(int i = 0; i < edgeNum; i++){
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			inputArr[m-1][n-1] = 1;
			inputArr[n-1][m-1] = 1;
		}
		
		//인접행렬에 초기값 셋팅 완료
		
		// DFS 호출
		
//		System.out.println(visited.length);
//		for(int i = 0 ; i < inputArr.length; i++){
//			for(int j = 0; j < inputArr[i].length; j++){
//				System.out.print(inputArr[i][j]);
//			}
//			System.out.println();
//		}
		dfs(startNode-1);
		System.out.println();
		
		initVisited();
		bfs(startNode-1);
		
	}
	
	public static void dfs(int startNode){
		
		visited[startNode] = true;
		System.out.print(startNode+1 + " ");
		
		for(int i = 0; i < visited.length; i++){
			if(startNode != i && !visited[i] && inputArr[startNode][i] == 1){
				dfs(i);
			}
		}
	}
	
	public static void initVisited(){
		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
	}
	
	public static void bfs(int startNode){
		Queue<Integer> q = new LinkedList<>();
		q.add(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()){
			
			int popNum = q.poll();
			
			System.out.print(popNum+1 + " ");
			
			for(int i = 0; i < visited.length; i++){
				if(popNum != i && !visited[i] && inputArr[popNum][i] == 1){
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}

