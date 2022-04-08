import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {

	static int R, C, D, size, ans;
	static int map[][], numbers[];
	
	static class Enemy implements Comparable<Enemy>{
		int r;
		int c;
		int d;
		
		public Enemy(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Enemy o) {	// 가장 가까운 적을 공격하기 위해서 거리순으로 오름차순 정렬
			if(this.d == o.d) {
				return this.c - o.c;
			} else {
				return this.d - o.d;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 st = new StringTokenizer(br.readLine());
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 D = Integer.parseInt(st.nextToken());
		 
		 map = new int[R+1][C];
		 numbers = new int[3];
		 
		 for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) size++;	// 적의 수를 카운트
			}
		}
		 
		 comb(0, 0);
		 System.out.println(ans);

	}

	
	// 1. 궁수 3명 배치하기
	public static void comb(int cnt, int start) {
		
		if(cnt == 3) {
			ans = Math.max(ans, bfs());
			return;
		}
		
		for (int i = start; i < C; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	
	// 2. 궁수가 적 공격하기 => 거리 D 이하 적 중 가장 가까운 적
	public static int bfs() {
		Queue<Enemy> deathNote = new LinkedList<>();	// 여러 궁수의 가까운 적
		
		int kill = 0;	// 궁수의 공격으로 제거된 적의 수
		int[][] copy_map = new int[R+1][C];
		
		// 배열 복사하기
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j < C; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
		
		while(remain(copy_map)) {	// 적이 맵에서 모두 제외될때까지 반복
			
			for (int a = 0; a < 3; a++) {	// 궁수 3명
				int c = numbers[a];	// 궁수의 열 위치
				
				PriorityQueue<Enemy> que = new PriorityQueue<>();
				
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(copy_map[i][j]==1) {	 // 남아있는 모든 적의 위치를 큐에 저장
							int d = Math.abs(R-i) + Math.abs(c - j);
							if(d<=D) {	// 궁수와 거리 D 이하인 적을 큐에 저장
								que.add(new Enemy(i, j, d));
							}
						}
						
					}
				}
				
				if(que.size()>0) {
					deathNote.offer(que.poll());	// 궁수 한명의 가까운 적을 저장
				}
			}
			
			// 공격받은 적 -> 게임에서 제외 => 0으로 갱신
			if(deathNote.size()>0) {
				for(Enemy pos : deathNote) {	// 여러 궁수의 가까운 적 
					if(copy_map[pos.r][pos.c] == 0) kill--;
					copy_map[pos.r][pos.c] = 0;
					kill++;
				}
			}
			
			// 3. 적을 이동시키기
			move(copy_map);
			
			deathNote.clear();
		}
		
		return kill;
	}
	
	
	// 적 이동
	public static void move(int[][] gameMap) {
		for (int c = 0; c < C; c++) {
			for (int r = R; r > 0; r--) {
				gameMap[r][c] = gameMap[r-1][c];
			}
			gameMap[0][c] = 0;
		}
	}
	
	// 적이 격자판에 남아있다면 true, 모두 제외되면 false
	public static boolean remain(int[][] gameMap) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(gameMap[r][c] == 1) return true;
			}
		}
		return false;
	}
}
