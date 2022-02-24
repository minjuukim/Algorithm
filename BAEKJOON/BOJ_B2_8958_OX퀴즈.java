import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			
			int score = 0;
			int count = 0;
			for(int i=0; i<c.length; i++) {
				if(c[i]=='O') {
					count++;		// O : 연속된 점수에서 증가
					score += count;
				} else count = 0;	// X : 연속된 점수 초기화
			}
			
			sb.append(score).append("\n");
		}
		
		System.out.println(sb);
	}

}
