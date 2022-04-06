import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {
	static int N;
	static int[][] adj;		//  플로이드 와샬을 위한 2차원 배열
	static final int INF = 9999999;	// 초기화를 위한 불가능한 최댓값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 2차원 배열에 INF(최댓값)으로 초기화
		adj = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = INF;
			}
			
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;	// 키 순서를 아는 경우 1로 입력
		}
		
		// 특정 학생이 모든 학생과의 거리를 체크해야하므로 플로이드 와샬 수행
		// 플로이드 와샬 : 경유지  -> 출발지 -> 도착지
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;	// 출발지와 경유지가 같다면 다음 출발지
				for (int j = 1; j <= N; j++) {
					if(i==j || k==j) continue;	// 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					
					// adj[i][j] 보다 작은 값이 나올 경우 갱신
					if(adj[i][j] > adj[i][k]+adj[k][j]) {
						adj[i][j] = adj[i][k] + adj[k][j];
					}
				}
			}
		}
		
		// 모든 학생과의 비교가 가능한 경우
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(toKnow(i)) count++;
		}
		
		System.out.println(count);
		
	}
	
	// x번째 학생이 자신의 키가 몇번째인지 알수 있는지 여부를 확인
	// 모두 연결되어있는지 확인
	static boolean toKnow(int x) {
		boolean[] check = new boolean[N+1];
		check[x] = true;
		for (int i = 1; i <= N; i++) {
			if(check[i]) continue;
			if(adj[i][x] != INF || adj[x][i]!=INF) check[i] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!check[i]) return false;
		}
		return true;
	}

}
