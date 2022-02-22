package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_미로탐색 {
	
	static int N, M, count;	
	static int[][] map;
					// 상     하    좌      우
	static int[] dx = {-1, 1, 0 , 0};
	static int[] dy = {0, 0, -1 , 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}

	public static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {x, y});	// queue에 시작값 넣어주기 (0, 0)
		visited[x][y] = true;	// 방문 체크
		
		while(!queue.isEmpty()) {	// 큐가 비어있지 않다면
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			
			// map[curX][curY]의 인접인덱스 처리(단, 방문하지 않은 인접인덱스만)
			for(int d=0; d<4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visited[nx][ny] && map[nx][ny]==1) {
						queue.offer(new int[] {nx, ny});
						map[nx][ny] = map[curX][curY] + 1;	// depth 표시
						visited[nx][ny] = true;
					}
				}
			}
			
		}
	}
}
