package week1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1에서부터 6까지의 눈을 가진 4개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다. 

같은 눈이 4개가 나오면 50,000원+(같은 눈)*5,000원의 상금을 받게 된다. 
같은 눈이 3개만 나오면 10,000원+(3개가 나온 눈)*1,000원의 상금을 받게 된다. 
같은 눈이 2개씩 두 쌍이 나오는 경우에는 2,000원+(2개가 나온 눈)*500원+(또 다른 2개가 나온 눈)*500원의 상금을 받게 된다.
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다. 
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다


input 
4
3 3 3 3
3 3 6 3
2 2 6 6
6 2 1 5

output 
65000

 */


public class BOJ_2484 {
	public static Scanner sc;
	public static int resultAns;
	public static int[][] arr;
	
	//2,000원+(2개가 나온 눈)*500원+(또 다른 2개가 나온 눈)*500원
	public static int calculation(int sameCount, int maxFirstNum, int maxSecondNum){
//		System.out.println("=====In calculation input====");
//		System.out.println("=====sameCount===="+ sameCount);
//		System.out.println("=====maxFirstNum===="+ maxFirstNum);
//		System.out.println("=====maxSecondNum===="+ maxSecondNum);
		//같은숫자가 2개씩 존재할때
		int resultSum = 0;
		if(maxSecondNum != 0){
			if(sameCount == 2){
				resultSum = 2000 + (maxFirstNum*500) + (maxSecondNum*500);
			}
		}else{
			if(sameCount == 0){
				resultSum = maxFirstNum*100;
			}
			else if(sameCount == 1){
				resultSum = 1000 + (maxFirstNum*100);
			}else if(sameCount == 2){
				resultSum =  10000 + (maxFirstNum*1000);
			} else{
				resultSum =  50000 + (maxFirstNum*5000);
			}
		}
		return resultSum;
	}
	
	
	public static void solving(){
		resultAns = 0;
		
		for(int i = 0; i < arr.length; i++){
			int maxFirstNum = 0;
			int maxSecondNum = 0;
			int sameCount = 0;
			Arrays.sort(arr[i]); //first sorting
			
			for(int j = 1; j < arr[i].length; j++){
				if(arr[i][j-1] ==  arr[i][j]){
					
					if(j == 3 && sameCount == 1){
						maxSecondNum = arr[i][j];
					}else{
						maxFirstNum = arr[i][j];	
					}
					sameCount += 1;
					
				}
				if(j == 3 && sameCount == 0){
					maxFirstNum = arr[i][j];
				}
			}
			
//			System.out.println("===============input===============");
//			System.out.println("sameCount = " + sameCount);
//			System.out.println("maxFirstNum = " + maxFirstNum);
//			System.out.println("maxSecondNum = " + maxSecondNum);
//			System.out.println("sorted Arrays ==================== ");
//			for(int j = 0; j < arr[i].length; j++){
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println("");
//			System.out.println("===============input End===============");

			resultAns = Math.max(calculation(sameCount, maxFirstNum, maxSecondNum), resultAns);
			
		}
		
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		arr = new int[num][4];
		
		for(int i = 0; i < num; i++){
			for(int j = 0; j < 4; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		solving();
		System.out.println(resultAns);
	}
}
