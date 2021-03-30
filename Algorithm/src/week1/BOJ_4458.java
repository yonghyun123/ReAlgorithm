package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*각 줄의 첫글자를 대문자로 바꾼뒤 출력한다.
 * 
 * 5
powdered Toast Man
skeletor
Electra Woman and Dyna Girl
she-Ra Princess of Power
darth Vader

Powdered Toast Man
Skeletor
Electra Woman and Dyna Girl
She-Ra Princess of Power
Darth Vader
 */
public class BOJ_4458 {
	
	
	public static int inputNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputNum = Integer.parseInt(br.readLine());
		
		String[] inputStr = new String[inputNum];
		
		for(int i = 0; i < inputNum; i++){
			inputStr[i] = br.readLine();
			char tempChar = Character.toUpperCase(inputStr[i].charAt(0));
			System.out.println(tempChar + inputStr[i].substring(1));
		}
		
	}
}
