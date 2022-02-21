import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759_암호만들기 {
	
	static int L, C;
	static char input[], password[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());	// 암호 알파벳 소문자 개수
		C = Integer.parseInt(st.nextToken());	// 문자 종류 개수
		
		st = new StringTokenizer(br.readLine());
		
		input = new char[C];
		password = new char[L];		
		
		for(int c=0; c<C; c++) {
			input[c] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(input); 	// 입력 배열을 오름차순으로 정렬
		
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int cnt, int start) {
		
		if(cnt==L) {
			int vowel = 0;		// 모음
			int consonant=0;	// 자음
			for(char p: password) {		// 생성된 암호에서 모음과 자음개수를 카운트
				if(p=='a' || p=='e' || p=='i' || p=='o' || p=='u') {
					vowel++;
				} else consonant++;
			}
			
			if(vowel>=1 && consonant>=2) {	// 조건에 맞는 문자열을 저장
				for(char p : password) {
					sb.append(p);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			
			password[cnt] = input[i];
			dfs(cnt+1, i+1);
		}
	}
}
