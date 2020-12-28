package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫 번째 줄에는 9개의 정수가 주어지는데, 오늘 경기에서 울림 제미니스가 1회 초, 2회 초, ..., 9회 초에 낸 득점이 주어진다.

두 번째 줄에도 9개의 정수가 주어지는데, 스타트링크 걸리버스가 1회 말, 2회 말, ..., 9회 말에 낸 득점이 주어진다.

한 팀이 한 회에 낸 득점은 모두 0 이상 20 이하이며, 스타트링크 걸리버스의 총 득점이 울림 제미니스의 총 득점보다 많다.

경기는 1회 초->1회 말->2회 초->...->9회 초->9회 말 순서로 진행된다.


 *input
 * 1 0 0 0 0 0 2 2 1
 * 0 0 3 0 0 0 0 1 4
 * 
 * output 
 * Yes
 * 
 * input
 * 0 0 0 0 0 0 0 1 0
 * 1 0 0 0 0 0 0 4 0
 * 
 * output
 * No
 * 
 */

public class BOJ_14582 {
	
	private static int []arrA;
	private static int []arrB;
	private static StringTokenizer st;
	private static int resultA;
	private static int resultB;
	private static boolean isTrue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		isTrue = false;
		arrA = new int[9];
		arrB = new int[9];
		resultA = 0;
		resultB = 0;
		
		for(int i = 0; i < 9; i++){
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 9; i++){
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 9; i++){
			resultA += arrA[i];
			if(resultA > resultB) {
				isTrue = true;
				break;
			}
			resultB += arrB[i];
		}
		if(isTrue){
			System.out.println("Yes");
		}else{
			System.out.println("No");	
		}
		
		
	}
}
