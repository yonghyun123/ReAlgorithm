package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 * 
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다. remove x: S에서 x를
 * 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다. check x: S에 x가 있으면 1을, 없으면 0을
 * 출력한다. (1 ≤ x ≤ 20) toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다. empty: S를 공집합으로 바꾼다.
 */

public class BOJ_11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result=new StringBuilder();
        StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());
		int S=0;
		for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
			if(command.equals("add")){
                int inputNum = Integer.parseInt(st.nextToken());
                S=S|(1<<inputNum);
			}
			else if(command.equals("remove")){
                int inputNum = Integer.parseInt(st.nextToken());
				S=S&~(1<<inputNum);
			}
			else if(command.equals("check")){
                int inputNum = Integer.parseInt(st.nextToken());
				if((S&(1<<inputNum))>0) result.append("1\n");
				else result.append("0\n");
			}
			else if(command.equals("toggle")){
                int inputNum = Integer.parseInt(st.nextToken());
				S=S^(1<<inputNum);
			}
			else if(command.equals("all")){
				S=(1<<21) -1;
			}
			else
				S=0;
		}
		System.out.println(result);



        
    }
}
