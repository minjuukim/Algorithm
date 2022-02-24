import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String str = br.readLine();	// 문자열 입력받기
		int count = 0;	// 알파벳 개수
		
		for (int i = 0; i < word.length; i++) {
			if(str.contains(word[i])) {
				str = str.replaceAll(word[i], "*");
			}
		}
		
		count = str.length();
		System.out.println(count);
	}

}
