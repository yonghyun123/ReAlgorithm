package week1;

import java.util.Scanner;

/*
 * 상근이는 A, B, C, A, B, C, A, B, C, A, B, C, ...와 같이 찍어야 통과할 수 있다고 생각한다. 
 * 하지만, 창영이는 B, A, B, C, B, A, B, C, B, A, B, C, ...와 같이 찍는 방법이 만점의 지름길이라고 생각한다.
 * 마지막으로, 현진이는 상근이와 창영이를 비웃으면서 C, C, A, A, B, B, C, C, A, A, B, B, ...와 같이 찍어야 통과한다고 말했다.
 * input
 * 5
   BAACC
   
   output
   3
   Bruno
   
   input
   9
   AAAABBBBB
   
   output
   4
	Adrian
	Bruno
	Goran
 */


public class BOJ_2966 {
	
	public static Scanner sc;

	public static void main(String[] args) {
		
		int AdrianResult = 0;
		int BrunoResult = 0;
		int GoranResult = 0;
		int maxResult = 0;
		String Adrian= "ABC";
		String Bruno ="BABC";
		String Goran ="CCAABB";
		
		
		sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String inputStr = sc.next();
	
		

		
		for(int i = 0; i < inputStr.length(); i++){
			
			if(Adrian.length() == i) Adrian += Adrian;
			if(Bruno.length() == i) Bruno += Bruno;
			if(Goran.length() == i) Goran += Goran;
			if(Adrian.charAt(i) == inputStr.charAt(i)){
				AdrianResult += 1;
			}
			
			if(Bruno.charAt(i) == inputStr.charAt(i)){
				BrunoResult += 1;
			}
			
			if(Goran.charAt(i) == inputStr.charAt(i)){
				GoranResult += 1;
			}
		}
		
		maxResult = Math.max(Math.max(AdrianResult, BrunoResult), GoranResult);
		
		System.out.println(maxResult);
		if(AdrianResult == maxResult){
			System.out.println("Adrian");
		}
		if(BrunoResult == maxResult){
			System.out.println("Bruno");
		}
		if(GoranResult == maxResult){
			System.out.println("Goran");
		}
		
	}
}
