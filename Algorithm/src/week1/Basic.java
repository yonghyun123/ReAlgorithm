package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Basic {
	
	public static Scanner sc;
	
	public static void main(String[] args) {
//		solving1000();
//		solving1330();
//		solving2752();
		solving2753();
	}
	
	public static void solving1000(){
		sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        System.out.println(num1+num2);
	}
	 
	public static void solving1330(){
        sc = new Scanner(System.in);
        
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        if(num1>num2){
            System.out.println(">");
        }else if(num1<num2){
            System.out.println("<");
        }else{
            System.out.println("==");
        }
	}
	
	public static void solving2752(){
        sc = new Scanner(System.in);
        
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        
        int[] arr = new int[3];
        
        arr[0] = num1;
        arr[1] = num2;
        arr[2] = num3;
        
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
	}
	
	public static void solving2753(){
        sc = new Scanner(System.in);
        
        int num1 = sc.nextInt();
        
        if(num1 % 4 == 0 && (num1 % 100 != 0 || num1 % 400 == 0)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
	}
}
