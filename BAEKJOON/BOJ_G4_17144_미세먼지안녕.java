import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_17144_미세먼지안녕 {
	
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[] cleaner = new int[2];	// 공기청정기 위치 ([0]-상부 [1]-하부)
	static Queue<Dust> queue = new LinkedList<Dust>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static class Dust {
		int x;
		int y;
		int amount;
		
		public Dust(int x, int y, int amount) {
			super();
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 행 수
		C = Integer.parseInt(st.nextToken());	// 열 수
		int T = Integer.parseInt(st.nextToken());	// 시간
		
		map = new int[R][C];	// 기본방에 대한 표현
		visited = new boolean[R][C];	
		int idx = 0;
		
		for(int i=0; i<R; i++) {	
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {	
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) { // 공기청정기의 위치 저장
					cleaner[idx++] = i;
				}
			}
		}
		
		
		// 1초마다 한번씩 반복
		for(int t=0; t<T; t++) {
			setQueue();	// 처음 미세먼지가 있는 곳 (좌표, 값)을 큐에 전부 넣기
			bfs();		// 미세먼지 확산시키기
			play();		// 공기 청정기 작동 (미세먼지 이동 시키기)
		}
		
		// 남아있는 미세먼지 양 출력
		int ans = 0;
		for(int i=0; i<R; i++) {	
			for(int j=0; j<C; j++) {	
				if(map[i][j]!=-1 && map[i][j]!=0) ans += map[i][j];
			}
		}
		System.out.println(ans);
		
	}
	
	// 처음 미세먼지의 좌표와 값을 큐에 넣기
	public static void setQueue() {
		
		for(int i=0; i<R; i++) {	
			for(int j=0; j<C; j++) {	
				if(map[i][j]!=-1 && map[i][j]!=0) {	// 먼지의 좌표와 양을 큐에 저장
					queue.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}
	
	// 미세먼지 확산시키기
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			Dust current = queue.poll();
			int curx = current.x;
			int cury = current.y;
			int curAmount = current.amount;
			
			int count = 0;	// 확산된 개수
			int spreadAmount = curAmount/5;
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = curx + dx[d];
				int ny = cury + dy[d];
				
				if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!=-1) {
					map[nx][ny] += spreadAmount;
					count++;
				}
			}
			
			// 확산 후 남은 미세먼지 양
			if(map[curx][cury] - spreadAmount*count >= 0)
				map[curx][cury] -= spreadAmount*count;
			else map[curx][cury] = 0;
		}
	}
	
	// 미세먼지 이동시키기 ==> 배열 돌리기
	public static void play() {
		int up = cleaner[0];
		int down = cleaner[1];
		
		// 위쪽 공기청정기 => 시계 반대 방향
		// 위->아래
		for(int i=up; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 오른쪽->왼쪽
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 아래->위
		for(int i=0; i<up; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 왼쪽->오른쪽
		for(int i=C-1; i>1; i--) {
			map[up][i] = map[up][i-1];
			if(i==2) map[up][i-1] = 0;
		}
		
		map[up][0] = -1;	// 공기청정기 위치에 있는 먼지 없애기
		
		// 아래쪽 공기청정기 => 시계 방향
		// 아래->위
		for(int i=down+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 왼쪽->오른쪽
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 위->아래
		for(int i=R-1; i>down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 오른쪽->왼쪽
		for(int i=C-1; i>1; i--) {
			map[down][i] = map[down][i-1];
			if(i==2) map[down][i-1] = 0;
		}
		map[down][0] = -1;	// 공기청정기 위치에 있는 먼지 없애기
	}

}
