import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	
	static int N, W, H, min;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 떨어뜨릴 구슬의 개수
			W = Integer.parseInt(st.nextToken());	// 가로 길이
			H = Integer.parseInt(st.nextToken());	// 세로 길이
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// end input
			
			min = Integer.MAX_VALUE;
			process(0, map);
			
			System.out.println("#"+t+" "+min);
		}// end t

	}
	
	// 중복순열 이용하여 구슬 던지기
	public static boolean process(int cnt, int[][] map) {
		
		int result = getRemain(map);
		
		if(result==0) {	// 모든 벽돌이 다 부서졌다면
			min = 0;
			return true;
		}
		
		if(cnt == N) {	// 모든 구슬을 다 던졌다면
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		// 모든 열에 구슬 던져보기
		for (int c = 0; c < W; c++) {
			
			// 구슬에 맞는 벽돌 찾기 (해당 열에서 가장 위에 있는 벽돌 위치 찾기)
			int r = 0;
			while(r<H && map[r][c]==0) ++r;	// 빈공간이면 계속해서 아래로 
			
			if(r==H) continue;	// 해당 열은 벽돌이 없으므로 pass
			
			// 벽돌이 있을 경우
			copy(map, newMap);	// 배열 상태를 백업
			
			boom(newMap, r, c);	// 해당 좌표로 구슬 떨어뜨려서 주변 가능한 모든 벽돌 부서뜨리기

			down(newMap);	// 벽돌 내리기
			
			// 다음 구슬 처리 (더이상 확인할 필요가 없다면 true)
			if(process(cnt+1, newMap)) return true;
		}
		return false;
	}
	
	// r,c 위치에서 주변 가능한 모든 벽돌도 함께 부수기 (bfs)
	public static void boom(int[][] map, int r, int c) {
		Queue<Point> que = new LinkedList<>();
		
		if(map[r][c] > 1) {	// 벽돌 크기가 2이상이면 큐에 추가
			que.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;	// 자신은 제거 처리 (빈공간으로) => visit 처리 역할
		
		while (!que.isEmpty()) {
			Point cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r;
				int nc = cur.c;
				
				for (int k = 0; k < cur.cnt-1; k++) {	// (벽돌의 크기 - 1) 만큼 반복
					nr += dr[d];
					nc += dc[d];
					
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
						if(map[nr][nc]>1) {	// 주변 벽돌에 영향을 주는 벽돌일 경우
							que.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;	// 벽돌 제거 처리
					}
				}
			}
		}
	}
	
	// 벽돌 내리기
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void down(int[][] map) {
		
		for (int c = 0; c < W; c++) {
			int r = H-1;	// 아래행 시작
			while(r>=0) {
				if(map[r][c] > 0) {	// 벽돌 찾기
					list.add(map[r][c]);	// 벽돌만 리스트에 추가
					map[r][c] = 0;	// 벽돌이 있던 자리는 빈공간으로 처리
				}
				r--;
			} // 남아있는 벽돌을 리스트에 다 담기
			
			r = H-1;
			for (int a : list) {	// 벽돌 리스트
				map[r--][c] = a;
			}
			list.clear();
		}
	}
	
	// 남은 벽돌 개수 세기
	public static int getRemain(int[][] map) {
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(map[r][c] > 0) count++;
			}
		}
		return count;
	}
	
	public static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
