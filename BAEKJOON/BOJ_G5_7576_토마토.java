import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7576_토마토 {
	
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// 가로칸수 (열)
		N = Integer.parseInt(st.nextToken());	// 세로칸수 (행)
		
		map = new int[N][M];
		queue = new LinkedList<>();
		
		boolean check = false;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) 	// 만약 토마토가 익은거라면 큐에 넣음.
					queue.add(new int[] {i, j});
			}
		}

		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					
					if(map[nx][ny] == 0) {	// 토마토가 안익었으면
						queue.add(new int[] {nx, ny});	// 익은 토마토에 추가
						map[nx][ny] = map[curX][curY]+1;	// 익은 날짜를 얻기위해 그 전 값에서 1 증가
					}
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;	// 최대 날짜
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return -1;	// 토마토가 안익은게 있으면 -1반환
				ans = Math.max(ans, map[i][j]);	// 날짜 최댓값 구하기
			}
		}
		
		if(ans == 1) return 0;	// 토마토가 모두 익은 상태인 경우
		else {
			return ans-1;	// 걸린 일수는 최대 날짜에서 1을 뺴줘야 함.
		}
		
	}

}
