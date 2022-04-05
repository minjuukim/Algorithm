import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];	// 거리 저장
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && dist[i][j] == 0) {		// 자기자신으로의 인접 정보가 아니고 인접해있지 않은 경우
						dist[i][j] = 9999999;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {	// 경유지
				for (int i = 0; i < N; i++) {	// 출발지
					if(i==k) continue;	// 출발지와 경유지가 같으면 갈 필요 없음
					for (int j = 0; j < N; j++) {	// 도착지
						if(i==j || k==j) continue;
						
						if(dist[i][k] + dist[k][j] < dist[i][j]) {	// 바로 가는 것보다 k를 거쳐서 가는게 더 빠른 경우 업데이트
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
			}
			System.out.println("#"+tc+" "+min);
		}
	}
}
