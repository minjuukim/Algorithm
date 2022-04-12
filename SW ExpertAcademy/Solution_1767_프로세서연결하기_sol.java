import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_sol {

	static int N, max,totalCnt, min,map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());	// 셀의 크기
			map = new int[N][N];	
			list = new ArrayList<int[]>();	// 가장자리가 아닌 코어리스트
			max = 0;	// 최대 연결 코어수
			min = Integer.MAX_VALUE;	// 최소 전선길이의 합
			totalCnt = 0;	// 가장자리가 아닌 코어의 개수
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리이면서 그 자리가 코어인 경우
					if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j] ==1) continue;  // 가장자리에 위치한 코어는 이미 연결한 것으로 간주한다. skip
					
					if(map[i][j]==1) { // 가장자리가 아닌 코어는 리스트에 추가 
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	
	private static void go(int index,int cCnt) { // 부분집합으로 코어 전선놓기 시도, cCnt : 현재까지 전원과 연결된 코어수 

		// 가지치기 
		if(totalCnt-index+cCnt<max) return; // totalCnt-index: 남은 코어수 
		
		if(index == totalCnt) {
			int res = getLength();
			if(max<cCnt) {
				max = cCnt;
				min = res;
			}else if(max==cCnt) {	// 최대 연결 코어수가 같다면
				if(min>res) min = res;
			}
			return;
		}
		
		int[] cur = list.get(index);	// 처리해야하는 코어
		int r = cur[0];
		int c = cur[1];
		
		// 전선을 놓아보기(4방향으로)
		for (int d = 0; d < 4; d++) {
			if(isAvailable(r, c, d)) { // 현재 코어의 r,c 위치에서 d방향으로 가장자리까지 닿을 수 있다면 전원연결 가능 
				setStatus(r, c, d, 2); // 전선 놓기
				go(index+1,cCnt+1);    // 다음 코어로 넘어감 
				setStatus(r, c, d, 0); // 전선 지우기
			}
		}
		
		// 전선 놓지 않기
		go(index+1,cCnt); // 해당 코어를 전원에 연결하지 않고 다음 코어로 넘어감 
	}
	
	private static boolean isAvailable(int r,int c ,int d) {	// r,c 위치에서 d 방향으로 전선으로 놓을 수 있는지 체크
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			
			if(map[nr][nc]>=1) return false; //  다른 코어나 전선을 만나면 불가 
		}
		return true;
	}
	
	private static void setStatus(int r,int c,int d, int s) {	// r,c 위치에서 d 방향으로 전선을 놓거나(2) 지우거나(0) 
		int nr=r, nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			map[nr][nc] = s;
		}
	}
	
	private static int getLength() {	// 놓아진 전선의 길이의 합 계산
		int lCnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==2) ++lCnt; 
			}
		}
		return lCnt;
	}
}