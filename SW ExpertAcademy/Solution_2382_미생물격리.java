import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	static class Micro implements Comparable<Micro>{
		int r, c, cnt, dir;	// 행, 열, 군집크기, 이동방향

		public Micro(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Micro o) {
//			return this.cnt - o.cnt;	// 오름차순, 최소힙
			return o.cnt - this.cnt;	// 내림차순, 최대힙
		}
	}

	static int N, M, K;
	static Micro map[][];
	static int[] dr = {0, -1, 1, 0, 0};	// 0: 사용하지 않음, 상:1, 하:2, 좌:3, 우:4
	static int[] dc = {0, 0, 0, -1, 1};
	static PriorityQueue<Micro> pQueue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 구역크기
			M = Integer.parseInt(st.nextToken());	// 처리시간
			K = Integer.parseInt(st.nextToken());	// 초기군집개수
			map = new Micro[N][N];	// 매시간마다 각 셀에 이동한  미생물 정보
			pQueue = new PriorityQueue<Micro>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				pQueue.add(new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			System.out.println("#"+tc+" "+move());
		}
	}
	
	private static int move() {	// 주어진 M 시간동안 미생물 이동 처리
		int time = M, nr,nc,remainCnt=0;
		
		while(time-->0) {
			// 군집리스트에서 군집들을 하나씩 모두 꺼내어 처리
			Micro m;
			while(!pQueue.isEmpty()) {
				m = pQueue.poll();	// 군집 크기가 큰 것부터 나옴
				
				nr = m.r += dr[m.dir];
				nc = m.c += dc[m.dir];
				
				if(nr==0 || nr==N-1 || nc==0 || nc==N-1) {	// 가장자리 약품이 칠해진 셀
					if( (m.cnt = m.cnt/2) == 0 ) continue;	// 크기 줄인 후 0이면 소멸
					
					// 방향 반대로 턴
					if(m.dir %2 == 1) m.dir++;	// 상->하, 좌->우
					else m.dir--;	// 하->상, 우->좌
				}
				
				if(map[nr][nc] == null) {	// 해당 자리에 처음 이동한 미생물 군집이면 그자리에 세팅
					map[nr][nc] = m;
				} else {	// 해당 자리에 처음 이동한 미생물 군집이 아니면 기존 군집에 합치기
					map[nr][nc].cnt += m.cnt;
				}
			}
			
			// 1시간 처리
			remainCnt = reset();
		}
		return remainCnt;
	}
	
	private static int reset() {	// 매시간마다 필요한 정리, 초기화 작업
		int total = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] != null) {	// 살아있는 미생물이 있다면
					pQueue.offer(map[r][c]);
					total += map[r][c].cnt;	// 살아있는 미생물 군집의 크기 누적
					map[r][c] = null;
				}
			}
		}
		return total;
	}

}
