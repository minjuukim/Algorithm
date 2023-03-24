package day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G2_19236_청소년상어 {

	static int maxSum = 0;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		List<Fish> fishes = new ArrayList<>();
		
		for(int r=0; r<4; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<4; c++) {
				Fish f = new Fish();
				f.num = Integer.parseInt(st.nextToken());
				f.dir = Integer.parseInt(st.nextToken()) - 1;
				f.r = r;
				f.c = c;
				map[r][c] = f.num;
				fishes.add(f);
			}
		}
		
		Collections.sort(fishes, new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.num - o2.num;
			}
			
		});
		
		// 상어는 (0,0) 물고기 먹고 시작하며, 위치는 -1로 표현
		Fish f = fishes.get(map[0][0] - 1);
		Shark shark = new Shark(0, 0, f.dir, f.num);	// (0,0)에 있는 물고기 먹기
		f.isAlive = false;
		map[0][0] = -1;
		
		dfs(map, shark, fishes);
		System.out.println(maxSum);
	}
	
	// 재귀로 상어가 이동할 수 없을 때까지 반복
	public static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
		
		// 잡아먹은 양의 최대값 구하기
		if(maxSum < shark.eatSum) {
			maxSum = shark.eatSum;
		}
		
		// 모든 물고기 순서대로 이동
		fishes.forEach(e -> moveFish(e, arr, fishes));
		
		for(int dist = 1; dist<=3; dist++) {
			int nr = shark.r + dr[shark.dir] * dist;
			int nc = shark.c + dc[shark.dir] * dist;
			
			if(nr<0 || nr>=4 || nc<0 || nc>=4 || arr[nr][nc]<=0) continue;
			
			// 물고기 잡아먹고 dfs
			int[][] arrCopies = copyArr(arr);
			List<Fish> fishCopies = copyFishes(fishes);
			
			arrCopies[shark.r][shark.c] = 0;
			Fish f = fishCopies.get(arr[nr][nc] - 1);
			Shark newShark = new Shark(f.r, f.c, f.dir, shark.eatSum+f.num);
			f.isAlive = false;
			arrCopies[f.r][f.c] = -1;
			
			dfs(arrCopies, newShark, fishCopies);
		}
	}
	
	// 이동 가능 칸 : 빈칸, 다른 물고기가 있는 칸
	// 45도 반시계 방향으로 회전하면서 스캔
	public static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
		
		if(fish.isAlive == false) return;
		
		for(int i=0; i<8; i++) {
			int nextDir = (fish.dir + i) % 8;
			int nr = fish.r + dr[nextDir];
			int nc = fish.c + dc[nextDir];
			
			if(nr<0 || nr>=4 || nc<0 || nc>=4 || arr[nr][nc]==-1) continue;
			
			// 이동
			if(arr[nr][nc] == 0) {		// 이동할 칸이 빈칸인 경우
				arr[fish.r][fish.c] = 0;
				fish.r = nr;
				fish.c = nc;
			} else {					// 이동할 칸에 다른 물고기가 있는 경우
				Fish tmp = fishes.get(arr[nr][nc] - 1);
				tmp.r = fish.r;
				tmp.c = fish.c;
				arr[fish.r][fish.c] = tmp.num;
				
				fish.r = nr;
				fish.c = nc;
			}
			
			arr[nr][nc] = fish.num;
			fish.dir = nextDir;
			return;
		}
	}
	
	public static int[][] copyArr(int[][] arr) {
		int[][] tmp = new int[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		
		return tmp;
	}
	
	static List<Fish> copyFishes(List<Fish> fishes) {
		List<Fish> tmp = new ArrayList<>();
		fishes.forEach(e -> tmp.add(new Fish(e.r, e.c, e.num, e.dir, e.isAlive)));
		return tmp;
	}
	
	public static class Shark {
		int r, c, dir, eatSum;
		
		public Shark(int r, int c, int dir, int eatSum) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.eatSum = eatSum;
		}
	}
	
	public static class Fish{
		int num;	// 물고기 번호
		int dir;	// 방향
		int r;
		int c;
		boolean isAlive = true;
		
		public Fish() {};
		
		public Fish(int r, int c, int num, int dir, boolean isAlive) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
			this.isAlive = isAlive;
		}
	}

}
