package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_20056_마법사상어와파이어볼 {
	
	static int N, map[][];
	static ArrayList<Fireball> balls;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	// 파이어볼 개수
		int K = Integer.parseInt(st.nextToken());	// 이동 횟수
		
		map = new int[N+1][N+1];
		balls = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			balls.add(new Fireball(r, c, m, s, d));
			map[r][c]++;
		}
		
		while(K-- > 0) {
			System.out.println("K: "+K);
			move();		// 파이어볼 이동시키기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] > 1) {
						split(i, j);	// 파이어볼 2개 이상 있는 칸은 파이어볼 합치고 나누기
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<balls.size(); i++) {
			sum += balls.get(i).m;
		}
		System.out.println(sum);
	}
	
	// 파이어볼 이동시키기
	public static void move() {
		for(int i=0; i<balls.size(); i++) {
			int r = balls.get(i).r;
			int c = balls.get(i).c;
			int d = balls.get(i).d;
			int s = balls.get(i).s;
			
			map[r][c]--;
			System.out.println("r c : "+ r+" "+c);
			int nr = r + dr[d]*s % N;
			int nc = c + dc[d]*s % N;
			System.out.println("nr nc : "+ nr+" "+nc);
			// 범위가 넘어갔을 경우
			if(nr <= 0) {
				nr = N - (Math.abs(nr)%N);
			} else if(nr > N) {
				nr %= N;
			}
			
			if(nc <= 0) {
				nc = (N - Math.abs(nc)%N);
			} else if(nc > N){
				nc %= N;
			}
			
			balls.get(i).setR(nr);
			balls.get(i).setC(nc);
			System.out.println(nr+" "+nc);
			map[nr][nc]++;
		}
	}
	
	// 파이어볼 2개 이상 있는 칸은 파이어볼 합치고 나누기
	public static void split(int r, int c) {
		int sumM = 0, sumS = 0;
		int dir = -1;
		boolean isSameDir = true;
		int x = 0, n = 0;
		
		// 파이어볼 합치기
		for(int i=x; i<balls.size();) {
			if(balls.get(i).r==r && balls.get(i).c==c) {
				n++;
				sumM += balls.get(i).m;
				sumS += balls.get(i).s;
				
				if(dir == -1) dir = balls.get(i).d%2;
				else {
					isSameDir = dir != (balls.get(i).d % 2)? false : isSameDir;
				}
				
				balls.remove(i);
			} else {
				i++;
			}
		}
		
		// 4개로 나누기
		int m = sumM/5;
		int s = sumS/n;
		
		if(m<=0) {
			map[r][c] = 0;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(isSameDir) {
				balls.add(new Fireball(r, c, m, s, i*2));
			} else {
				balls.add(new Fireball(r, c, m, s, i*2+1));
			}
		}
		map[r][c] = 4;
	}
}

class Fireball {
	int r, c;	// 위치
	int m;	// 질량
	int s;	// 속력
	int d;	// 방향
	
	public Fireball(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setC(int c) {
		this.c = c;
	}
}
