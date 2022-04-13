import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int R, C, M, total;
	static int[][] map, copy;
	static ArrayList<Shark> sharks = new ArrayList<>();
	static Queue<Integer> remove = new LinkedList<Integer>();
	
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,1,-1};
	
	static class Shark {
		int r;
		int c;
		int speed;
		int d;
		int size;
		
		public Shark(int r, int c, int speed, int d, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;	// 속력
			this.d = d;		// 이동방향
			this.size = size;	// 상어크기
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	// 상어의 수
		map = new int[R+1][C+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());	// 속력
			int d = Integer.parseInt(st.nextToken());	// 이동방향 : 1(위) 2(아래) 3(오) 4(왼)
			int z = Integer.parseInt(st.nextToken());	// 크기
			map[r][c] = z;	// 상어의 크기를 맵에 저장
			sharks.add(new Shark(r, c, s, d, z));	// 상어 정보를 추가
		}
		
		for (int i = 1; i <= C; i++) {	// 낚시왕의 위치를 오른쪽으로 이동하면서 반복
			
			fish(i);	// 상어 잡기 => 제거
			move();		// 상어 이동시키기
		}
		System.out.println(total);

	}

	private static void fish(int c) {	// 낚시왕있는 해당 열에서 가장 가까운 위치에 있는 상어 잡기
		Loop :
		for (int r = 1; r <= R; r++) {
			if(map[r][c] != 0) {
				
				for (int i = 0; i < sharks.size(); i++) {
					if(sharks.get(i).r==r && sharks.get(i).c==c) {
						total += sharks.get(i).size;		// 잡은 상어 크기를 합함
						map[r][c] = 0;		// 맵에서 상어 제거
						sharks.remove(i);	// 상어 리스트에서 상어 제거
						break Loop;
					}
				}
			}
		}
	}
	
	private static void move() {
		copy = new int[R+1][C+1];	// 움직인 상어들의 위치를 일시적으로 저장
		
		for (int i = 0; i < sharks.size(); i++) {
			Shark cur = sharks.get(i);
			
			map[cur.r][cur.c] = 0;
			
			for (int j = 0; j < cur.speed; j++) {  // 해당 스피드만큼 상어 이동
				if     (cur.r==1 && cur.d==1) cur.d = 2;
				else if(cur.r==R && cur.d==2) cur.d = 1;
				else if(cur.c==C && cur.d==3) cur.d = 4;
				else if(cur.c==1 && cur.d==4) cur.d = 3;
				
				cur.r += dr[cur.d];
				cur.c += dc[cur.d];
			}
			
			if(copy[cur.r][cur.c] == 0) { 		// 상어가 이동한 위치에 다른 상어가 없다면 
				copy[cur.r][cur.c] = cur.size;  // 해당 상어 정보를 넣음
				
			} else if(copy[cur.r][cur.c] < cur.size) {	// 이동한 상어가 기존 상어보다 크기가 큰 경우 
				remove.add(copy[cur.r][cur.c]);		// 기존 상어는 제거
				copy[cur.r][cur.c] = cur.size;		// 배열에 움직인 상어의 정보를 저장
				
			} else {	// 이동한 상어 < 기존 상어  => 해당 위치에 존재할 수 없음 
				remove.add(cur.size);
			}
		}
		
		while(!remove.isEmpty()) {	
			int cur = remove.poll();
			for (int i = 0; i < sharks.size(); i++) {
				if(cur == sharks.get(i).size) { // 두 상어가 같은 크기를 갖는 경우가 없음
					sharks.remove(i);
					break;
				}
			}
		}
		map = copy;
	}


}
