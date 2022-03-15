import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	
	static char map[][];
					// 상, 하, 좌, 우
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int x = 0;
	static int y = 0;
	static int dir = 0;
	static int nx, ny;		// 전차가 바라보고 있는 위치

	public static void toChangeDir(char cmd) {	// 방향 바꿔주기
		switch(cmd) {
		case 'U': 
			map[x][y] = '^';
			dir = 0; break;
		case 'D': 
			map[x][y] = 'v';
			dir = 1; break;
		case 'L': 
			map[x][y] = '<';
			dir = 2; break;
		case 'R': 
			map[x][y] = '>';
			dir = 3; break;
		}
	}
	
	public static void toMove(int H, int W) {	// 전차 이동하기
		
		nx += dx[dir];
		ny += dy[dir];
		//System.out.println(nx+" "+ny);
		if(nx<0 || ny<0 || nx>=H || ny>=W) {	// 맵 밖이라면 이동하지 않는다
			//System.out.println("범위를 벗어남.");
			return;
		} else {
			//System.out.println(x+" "+y);
			if(map[nx][ny] == '.') {	// 이동할 위치가 평지라면 바라보고 있는 방향으로 이동
				map[nx][ny] = map[x][y];
				map[x][y] = '.';		// 현재 위치를 평지로 바꾸고 이동
				x = nx;	
				y = ny;
			} else return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int H = Integer.parseInt(st.nextToken());	// 게임 맵의 높이
			int W = Integer.parseInt(st.nextToken());	// 게임 맵의 너비
			map = new char[H][W];
			
			// 초기값 설정
			x = 0;
			y = 0;
			dir = 0;
			
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					// 전차 초기 방향 설정
					switch(map[i][j]) {
					case '^': 
						dir=0; x=i; y=j;
						break;
					case 'v': 
						dir=1; x=i; y=j;
						break;
					case '<': 
						dir=2; x=i; y=j;
						break;
					case '>': 
						dir=3; x=i; y=j;
						break;
					}
//					if(map[i][j]=='<' || map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='>') {
//						if(map[i][j] == '^')
//							dir=0;
//						else if (map[i][j]=='v')
//							dir=1;
//						else if (map[i][j]=='<')
//							dir=2;
//						else
//							dir=3;
						// 전차 초기 위치 설정
//						x=i;
//						y=j;
//					}
				}
			}
			int N = Integer.parseInt(br.readLine());	// 사용자가 넣을 입력의 개수
			String command = br.readLine();
			
			for(int i=0; i<N; i++) {
				char cmd = command.charAt(i);		// 동작 문자
				
				nx = x;
				ny = y;
				//System.out.println(cmd+" 현재위치: "+nx+" "+ny);
				if(cmd=='S') {
					// 전차가 현재 바라보고 있는 방향으로 포탄 발사
					
					while(true) {
						nx += dx[dir];
						ny += dy[dir];
						//System.out.println(nx+" "+ny);
						if(nx<0 || ny<0 || nx>=H || ny>=W) {
							//System.out.println("범위를 벗어났습니다.");
							break;
						} else if(map[nx][ny] =='#') { // 강철벽이면 끝냄
							break;
						} else if( map[nx][ny] == '*') {	// 벽돌벽이면 평지로 바꿔줌
							map[nx][ny] = '.';
							break;
						}
					}
					
				} else {	// U D L R
					
					toChangeDir(cmd); 	// 방향을 바꾸기
					//System.out.println("방향바꾸기: "+map[x][y]);
					toMove(H, W);
					//System.out.println("이동후 위치: "+x+" "+y+" 상태: "+map[nx][ny]);
					//System.out.println("기존위치: "+map[x][y]);
				}
			}//for
			
			System.out.print("#"+t+" ");
			for(char[] i: map) {
				for(char j: i) {
					System.out.print(j);
				}
				System.out.println();
			}
			
		}//for
	}//main
}
