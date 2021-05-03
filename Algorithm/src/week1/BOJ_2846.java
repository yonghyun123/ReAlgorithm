package week1;
/*
 * 상근이는 자전거를 타고 등교한다. 자전거 길은 오르막길, 내리막길, 평지로 이루어져 있다. 
 * 상근이는 개강 첫 날 자전거를 타고 가면서 일정 거리마다 높이를 측정했다. 상근이는 가장 큰 오르막길의 크기를 구하려고 한다.

측정한 높이는 길이가 N인 수열로 나타낼 수 있다. 여기서 오르막길은 적어도 2개의 수로 이루어진 
높이가 증가하는 부분 수열이다. 오르막길의 크기는 부분 수열의 첫 번째 숫자와 마지막 숫자의 차이이다.

예를 들어, 높이가 다음과 같은 길이 있다고 하자. 12 3 5 7 10 6 1 11. 이 길에는 2 개의 오르막길이 있다.
 밑 줄로 표시된 부분 수열이 오르막길이다. 첫 번째 오르막길의 크기는 7이고, 두 번째 오르막길의 크기는 10이다. 
 높이가 12와 6인 곳은 오르막길에 속하지 않는다.

가장 큰 오르막길을 구하는 프로그램을 작성하시오.
 * 8
 * 12 20 1 3 4 4 11 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2846 {
	
	private static BufferedReader br;
	private static StringTokenizer st;
	private static int[] inputArr;
	private static int inputNum;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		inputNum = Integer.parseInt(br.readLine());
		List<Integer> resultList = new ArrayList<>();
		inputArr = new int[inputNum];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < inputNum; i++){
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1, idx = 0; i < inputNum; i++){
			if(inputArr[i-1] >= inputArr[i]){
				resultList.add(inputArr[i-1] - inputArr[idx]);
				idx = i;
			}
			//마지막 값 처리
			if(i == (inputNum -1)){
				if(inputArr[i] > inputArr[i-1]){
					resultList.add(inputArr[i] - inputArr[idx]);
				}
			}
		}
		
		
		if(resultList.isEmpty()){
			System.out.println("0");
		}else{
			resultList.sort(Comparator.reverseOrder());
			System.out.println(resultList.get(0));
		}
		
		
	}
}
