package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10973 {

    private static int n;
    private static int[] inputArr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        inputArr = new int[n];
        for(int i = 0; i < n; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        int breakIdx = -1;
        for(int i = n-1; i >0; i--){
            
            if(inputArr[i] < inputArr[i-1]){
                breakIdx = i-1;
                break;
            }
        }
        if(breakIdx == -1){
            System.out.println("-1");
        } else {
            int maxNum = -1;
            int swapIdx = 0;
            for(int i = breakIdx; i < n; i++){
                if(inputArr[breakIdx] > inputArr[i] && maxNum <= inputArr[i]){
                    maxNum = inputArr[i];
                    swapIdx = i;
                }
            }
            int temp = inputArr[breakIdx];
            inputArr[breakIdx] = inputArr[swapIdx];
            inputArr[swapIdx] = temp;
            bubbleSort(inputArr, breakIdx+1);
            printArray(inputArr);
        }
        
    }

    public static void bubbleSort(int[] inputArr, int idx){
        for(int i = idx; i < n; i++){
            for(int j = idx; j < (n-1); j++){
                if(inputArr[j] <inputArr[j+1]){
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] inputArr){
        for(int i = 0; i < n; i++){
            System.out.print(inputArr[i] + " ");
        }
    }
}
