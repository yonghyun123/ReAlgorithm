package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.
 * 
 * 영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.
 * 
 * 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다. 화면에 있는 이모티콘 중
 * 하나를 삭제한다. 모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다.
 * 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를
 * 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.
 * 
 * 영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class BOJ_14226 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int inputNum;
    private static int[] nextElement;
    private static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        inputNum = Integer.parseInt(br.readLine());
        nextElement = new int[3];
        visited = new boolean[10001][10001];
        bfs();
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int screenEmotCount = 1;
        int clipCount = 0;
        int timeCount = 0;

        int[] tempElement = {screenEmotCount, clipCount, timeCount};
        q.add(tempElement);

         int i = 0;
        while(!q.isEmpty()){
            int currScreenCount = q.peek()[0];
            int currClipCount = q.peek()[1];
            int currTimeCount = q.peek()[2];

            
            q.poll();

            // System.out.println("currScreenCount"+currScreenCount);
            // System.out.println("currClipCount"+currClipCount);
            // System.out.println("currTimeCount"+currTimeCount);

            if(currScreenCount == inputNum){
                System.out.println(currTimeCount);
                break;
            }

            //화면 이모티콘 클립보드에 저장
            
            int nextClipCount = currScreenCount;
            if(!visited[currScreenCount][currScreenCount]){//이건 왜하는지 이해가 안되네..
                nextElement = new int[3];
                visited[currScreenCount][currScreenCount] = true;
                nextElement[0] = currScreenCount;
                nextElement[1] = nextClipCount;
                nextElement[2] = currTimeCount+1;
                q.add(nextElement);
            }


            
            //클립보드에 있는 이모티콘 화면에 저장
            int nextScreenCount = currClipCount + currScreenCount;
            if(currClipCount != 0 && !visited[nextScreenCount][currClipCount] && nextScreenCount<=1000){
                nextElement = new int[3];
                visited[nextScreenCount][currClipCount] = true;
                nextElement[0] = nextScreenCount;
                nextElement[1] = currClipCount;
                nextElement[2] = currTimeCount+1;
                q.add(nextElement);
            }
            


            //화면에 있는 이모티콘 중 하나 삭제
            
            int removeScreenCount = currScreenCount - 1;
            if(!visited[removeScreenCount][currClipCount] && removeScreenCount > 0){
                nextElement = new int[3];
                visited[removeScreenCount][currClipCount] = true;
                nextElement[0] = removeScreenCount;
                nextElement[1] = currClipCount;
                nextElement[2] = currTimeCount+1;
                q.add(nextElement);
            }

            //  i++;
        }
    }
}
