package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10866 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static LinkedList<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String inputCommand = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            } 
            switch(inputCommand){
                
                case "push_front": pushFront(num);
                break;
                case "push_back": pushBack(num);
                break;
                case "pop_front":  sb.append(popFront()); sb.append("\n");
                break;
                case "pop_back":  sb.append(popBack()); sb.append("\n");
                break;
                case "size": sb.append(getSize()); sb.append("\n");
                break;
                case "empty": sb.append(getEmpty()); sb.append("\n");
                break;
                case "front": sb.append(getFront()); sb.append("\n");
                break;
                case "back": sb.append(getBack()); sb.append("\n");
                break;
                
            }
        }
        System.out.println(sb);
    }
    public static void pushFront(int num){
        deque.addFirst(num);
    }

    public static void pushBack(int num){
        deque.addLast(num);
    }

    public static int popFront(){
        if(deque.isEmpty()){
            return -1;
        } else {
            return deque.pollFirst();
        }
    }

    public static int popBack(){
        if(deque.isEmpty()){
            return -1;
        } else {
            return deque.pollLast();
        }
    }

    public static int getSize(){
        return deque.size();
    }

    public static int getEmpty(){
        if(deque.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }

    public static int getFront(){
        if(deque.isEmpty()){
            return -1;
        } else {
            return deque.peekFirst();
        }
    }


    public static int getBack(){
        if(deque.isEmpty()){
            return -1;
        } else {
            return deque.peekLast();
        }
    }
    
}
