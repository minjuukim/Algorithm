import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			int max=0;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int sum=0;
					
					for(int x=0; x<M; x++) {
						for(int y=0; y<M; y++) {
							
							int[][] arr = new int[M][M];
							arr[x][y] = map[i+x][j+y];
							
							sum += arr[x][y];
						}
					}
					if( sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+max);
		}

	}

}
