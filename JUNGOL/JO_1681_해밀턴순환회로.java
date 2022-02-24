import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {
	
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 배달해야 하는 장소의 수
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int x, int cnt, int cost) {
		
		// 기저조건
		if(cost >= ans) return;		// 중간 비용이 정답보다 크다면 더이상 볼 필요가 없으므로 반환.
		
		if(cnt == N-1) {
			// 다시 회사로 돌아오는 길이 있으면
			if(map[x][0] != 0) {
				ans = Math.min(ans, cost+map[x][0]);
			}
			return;
		}
		
		
		for (int i = 1; i < N; i++) {	// 0은 회사
			
			if(!visited[i] && map[x][i]!=0) {	// 방문한 적이 없고, 그쪽으로 가는 길이 있으면
				visited[i] = true;	// 방문 처리
				dfs(i, cnt+1, map[x][i] + cost);
				visited[i] = false;
			}
		}
	}

}
