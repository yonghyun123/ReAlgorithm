package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고
 * 알려져 있다. 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을
 * 것이라고 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다
 * 
 * 4 6 a t c i s w
 * 
 * acis acit aciw acst acsw actw aist aisw aitw astw cist cisw citw istw istw
 */
public class BOJ_1759 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, r;
    private static char[] inputArr;
    private static char[] resultArr;
    private static boolean[] visited;
    private static ArrayList<String> compareList;
    private static char[] vowel = {'a','i','e','o','u'};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        inputArr = new char[n];
        resultArr = new char[r];
        char[] tempArr = new char[r];
        visited = new boolean[n];
        compareList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){    
            inputArr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(inputArr);
        solution(resultArr, 0, tempArr);
        
    }

    public static void solution(char[] resultArr, int depth, char[] tempArr){
        if(depth == r){
            // 모음이 몇개인지 판단하는 메서드
            int rightVowelCnt = checkVowel(resultArr);
            /**
             * 기저조건 1 : 모음이 0개일때,
             * 기저조건 2 : 배열크기에서 모음갯수를 뺐을때, 자음개수가 2 보다 작으면
             * 기저조건 3 : 모음갯수가 전체갯수보다 많을때 
             * 기저조건 4 : 기존에 담긴 결과값이라면 
             */
            if(rightVowelCnt == 0) return;
            if(r - rightVowelCnt < 2 || rightVowelCnt > r) return;
            if(!isAlreadyPasswd(resultArr, tempArr)) return;

            print(resultArr);
            return;

        }

        for(int i = depth; i < n; i++){
            if(!visited[i]){
                resultArr[depth] = inputArr[i];
                visited[i] = true;
                solution(resultArr, depth+1, tempArr);
                visited[i] = false;
            }
        }
    }

    //결과를 출력
    public static void print(char[] resultArr){
        
        for(int i = 0; i < r; i++){
            System.out.print(resultArr[i]);
        }
        System.out.println();
    }

    //모음 갯수 판단
    public static int checkVowel(char[] resultArr){
        int rightVowelCnt = 0;
        for(int i = 0; i < vowel.length; i++){
            for(int j = 0; j < resultArr.length; j++){
                if(vowel[i] == resultArr[j]) rightVowelCnt+=1;
            }
        }
        return rightVowelCnt;
    }

    // Array를 sort시켜 기존에 담겨있다면 return
    public static boolean isAlreadyPasswd(char[] resultArr, char[] tempArr){
        boolean returnFlag = true;

        for(int i = 0; i < r; i++){
            tempArr[i] = resultArr[i];
        }
        Arrays.sort(tempArr);
        String resultStr = String.valueOf(tempArr);
        tempArr = null;

        if(!compareList.contains(resultStr)){
            compareList.add(resultStr);
        } else {
            returnFlag = false;
        }
        return returnFlag;
    }
}
