import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 수열의 길이
			int[] arr = new int[N];
			int[] dp = new int[N];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					//기존 수까지의 최대길이에 현재수를 더한 길이값(+1)이 현재수의 최적길이(최대길이)보다 크다면 최대길이 갱신
					if(arr[j] < arr[i] && dp[j]+1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
