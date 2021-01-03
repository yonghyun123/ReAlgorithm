package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int inputNum;
	public static String[] inputArr;
	public static int[] baseNum = {0,1,2,3,4,5,6,7,8,9};
	public static long resultMaxNum;
	public static long resultMinNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		inputNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		inputArr = new String[inputNum];
		for(int i = 0; i < inputNum; i++){
			inputArr[i] = st.nextToken();
		}
		
		
		resultMaxNum = 0;
		resultMinNum = 999999999;
		
		
		for(int i = 0; i < 10; i++){
			recursionMax(0,String.valueOf(i),0);
		}
		
		for(int i = 0; i < 10; i++){
			recursionMin(0,String.valueOf(i),0);
		}
		
		System.out.println(resultMaxNum);
		if(inputNum == String.valueOf(resultMinNum).length()){
			System.out.println("0"+resultMinNum);	
		}else{
			System.out.println(resultMinNum);
		}
		
	}
	
	public static void recursionMax(int idx, String nextStr, int depth){
		if(depth == inputNum){
			long nextNum = Long.parseLong(nextStr);
			if(resultMaxNum < nextNum){
				resultMaxNum = nextNum;
				return;
			}
		}
		//기저조건 
		if(idx >= baseNum.length-1){
			return;
		}
		

		for(int i = 0; i < baseNum.length; i++){
			if(!nextStr.contains(i+"")){
				if("<".equals(inputArr[depth])){
					if(Integer.parseInt(nextStr.substring(nextStr.length()-1)) < baseNum[i]){
						String temp = nextStr+baseNum[i];
						recursionMax(idx+1, temp, depth+1);
					}
				}else if(">".equals(inputArr[depth])){
					if(Integer.parseInt(nextStr.substring(nextStr.length()-1)) > baseNum[i]){
						String temp = nextStr+baseNum[i];
						recursionMax(idx+1, temp, depth+1);
					}
				}
			}
		}
	}
	
	public static void recursionMin(int idx, String nextStr, int depth){
		if(depth == inputNum){
			long nextNum = Long.parseLong(nextStr);
			if(resultMinNum > nextNum){
				resultMinNum = nextNum;
				
			}
			return;
		}
		//기저조건 
		if(idx >= baseNum.length-1){
			return;
		}
		

		for(int i = 0; i < baseNum.length; i++){
			if(!nextStr.contains(i+"")){
				if("<".equals(inputArr[depth])){
					if(Integer.parseInt(nextStr.substring(nextStr.length()-1)) < baseNum[i]){
						String temp = nextStr+baseNum[i];
						recursionMin(idx+1, temp, depth+1);
					}
				}else if(">".equals(inputArr[depth])){
					if(Integer.parseInt(nextStr.substring(nextStr.length()-1)) > baseNum[i]){
						String temp = nextStr+baseNum[i];
						recursionMin(idx+1, temp, depth+1);
					}
				}
			}
		}
	}

}
