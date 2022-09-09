package day0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17281_야구공 {
	
	static int N;
	static int[][] game;
	static boolean[] visit;	
	static int[] player;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 이닝 수
		game = new int[N+1][10];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		
		// 4번 타자는 1번으로 고정
		visit[4] = true;
		player[4] = 1;
		
		perm(2);
		System.out.println(ans);

	}
	
	// 순열 => 타순 정하기
	public static void perm(int count) {
		
		if(count == 10) {
			play();
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(visit[i]) continue;
			
			player[i] = count;
			visit[i] = true;
			perm(count+1);
			visit[i] = false;
		}
	}
	
	// 경기 실행
	public static void play() {
		int score = 0;
		int startPlayer = 1;	// 이닝에서 처음 시작하는 타자
		boolean[] base;		// 홈, 1루, 2루, 3루 표현
		
		for (int i = 1; i <= N; i++) {	// N번째 이닝까지 실행 
			int outCnt = 0;
			base = new boolean[4];		// base를 새롭게 초기화.
			
			outer: while(true) {
				for(int j = startPlayer; j <= 9; j++) {
					int hitter = game[i][player[j]];		// j번째 타자의 행동
					
					switch(hitter) {
					case 0:		// 아웃
						outCnt++;
						break;
						
					case 1:		// 1루타
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								
								if(k==3) {		// 3루에 있는 선수는 홈으로 들어오고 점수획득.
									score++;
									base[k] = false;	// 3루는 비어있게 됨.
									continue;
								}
								
								// 1, 2루의 경우 1루씩 진루하고, 원래 있던 자리는 비어있게 됨.
								base[k] = false;
								base[k+1] = true;
							}
						}
						
						base[1] = true;		// 홈에서 1루로 진루.
						break;
					
					case 2:		// 2루타
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3 || k==2) {	// 3루 or 2루에 있는 선수는 홈으로 들어오고 점수 획득.
									score++;
									base[k] = false;	// 3루 or 2루는 비어있게 됨.
									continue;
								}
								
								// 1루의 경우 2루씩 진루하고, 원래 있던 자리는 비어있게 됨.
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;		// 홈에서 2루로 진루.
						break;
					
					case 3:		// 3루타
						for(int k=3; k>=1; k--) {
							if(base[k]) {		// 홈 제외 모든 선수는 홈으로 들어오고, 점수 획득.
								score++;
								base[k] = false;
							}
						}
						// 홈에서 3루로 진루.
						base[3] = true;
						break;
						
					case 4:		// 홈런
						for(int k=1; k<=3; k++) {
							if(base[k]) {		// 루 상에 모든 주자가 홈으로 들어오고, 점수 획득.
								score++;
								base[k] = false;
							}
						}
						score++;	// 홈런친 타자의 점수 1점 추가.
						break;
					}
					
					if(outCnt == 3) {
						startPlayer = j+1;		// startPlayer를 그 다음 타자로 초기화
						if(startPlayer == 10) {
							startPlayer = 1;
						}
						break outer;
					}
				}
				
				// 1~9번까지 타자가 한 이닝에 전부 안타를 쳐서 아웃카운트가 발생하지 않게 되면,
                // 위 반복문이 무한 루프를 돌기때문에 startPlayer = 1로 초기화해야 함.
				startPlayer = 1;
				
			}//outer
		}
		
		ans = Math.max(ans, score);
	}

}
