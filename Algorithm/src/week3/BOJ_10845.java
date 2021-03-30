package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class BOJ_10845 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String inputStr = st.nextToken();
        
            switch(inputStr){   
                case "push": 
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "front": 
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(q.getFirst());
                    }
                    break;
                case "back": 
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(q.getLast());
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":  
                    if(q.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                   break;
                case "pop":  
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(q.pop());
                    }
                    break;
            }
        }
    }


}
