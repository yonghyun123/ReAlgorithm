package week1;

import java.util.Scanner;

/*
 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 
 * 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 
 * 가깝게 만들어야 한다.
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, 
 * M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 * 
 * input
 * 5 21
   5 6 7 8 9
   
   output 
   21
 */
public class BOJ_2798 {
	
	public static Scanner sc;
	public static int[] inputArr;
	public static long resultNum;
	public static long result;
	
	public static void calculationOfResult(int idx, int prevVal, long depth){
		
//		System.out.println("idx = "+ idx);
//		System.out.println("prevVal=" +prevVal);
//		System.out.println("depth=" +depth);
		if(depth == 3){
			if(result <= prevVal && prevVal <= resultNum){
				result = prevVal;
			}
			return;
		}
		
		if((depth > 3) || (prevVal > resultNum) || (idx >= inputArr.length)){
			return;
		}
		
		calculationOfResult(idx+1, prevVal+inputArr[idx], depth+1);
		calculationOfResult(idx+1, prevVal, depth);
		
	}
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int inputNum = sc.nextInt();
		resultNum = sc.nextInt();
		inputArr = new int[inputNum];
		
		for(int i = 0; i < inputNum; i++){
			inputArr[i] = sc.nextInt();
		}
		
		
		calculationOfResult(0, 0, 0);
		System.out.println(result);
		
	}
	

}
