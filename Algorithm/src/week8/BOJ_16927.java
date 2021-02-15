package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16927 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int row, col, rotate, S;
    public static int[][] board;
    public static List<Long> dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        rotate = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        int[][] tempBoard = new int[row][col];
        int[][] resultBoard = new int[row][col];
        dp = new ArrayList<>(); 

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


		int rowStart = 0;
		int rowEnd = row-1;
		
		int colStart = 0;
		int colEnd = col-1;
		while(true) {
			int size = (rowEnd-rowStart+1)*2 + (colEnd-colStart+1)*2 -4;
			spin(rowStart,rowEnd,colStart,colEnd,rotate%size);
			rowStart+=1;
			rowEnd-=1;
			colStart+=1;
			colEnd-=1;
			if(rowStart>rowEnd || colStart>colEnd) break;
		}
        
        printArray(board);

    }

    public static void printArray(int[][] board){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void spin(int rowStart, int rowEnd, int colStart, int colEnd, int cnt) {
		for(int k=0;k<cnt;k++) {
			int temp = board[rowStart][colStart];

			for(int j=colStart;j<colEnd;j++) {
				board[rowStart][j] = board[rowStart][j+1]; 
			}
			
			for(int i=rowStart;i<rowEnd;i++) {
				board[i][colEnd] = board[i+1][colEnd];
			}
			
			for(int j=colEnd;j>colStart;j--) {
				board[rowEnd][j] = board[rowEnd][j-1];
			}
			
			for(int i=rowEnd;i>rowStart;i--) {
				board[i][colStart] = board[i-1][colStart];
			}
			board[rowStart+1][colStart] = temp;
		}
    }
    
}
