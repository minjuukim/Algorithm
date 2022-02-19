package sol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class BOJ_G5_15683_감시 {
	static int N, M; //(1 ≤ N, M ≤ 8)
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static ArrayList<CCTV> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for(int i =0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(1 <= map[i][j] && map[i][j] <= 5) { //CCTV 정보가 입력되었다면
					list.add(new CCTV(i,j, map[i][j])); //List관리 (위치, CCTY타입)
				}
			}
		}
		dfs(0, map);

		System.out.println(result);
		sc.close();
	}//main
	
	static void dfs(int idx, int[][] nMap) {
		
		if(idx == list.size()) {//종료조건: 전체 CCTV가 체크 되었다면
			int cnt = 0;
			//사각지대 갯수 세기
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < M ;j++) {
					if(nMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		
		//재귀호출
		//리스트에서 CCTV 뽑아서 감시 솔루션
		CCTV cctv = list.get(idx);
		int y = cctv.y;
		int x = cctv.x;
		
		int[][] vMap = new int[N][M]; //원본 배열에 있는 값을 깊이복사!!
		
		switch(cctv.type) {
			case 1 : //  1번 감시 카메라
				for(int d = 0; d < 4 ; d++) {
					//				감시
					for(int i = 0; i < N; i++) {//행의 수를 표현
						vMap[i] = Arrays.copyOf(nMap[i],M); //각 행의 데이터를 M(열갯수)만큼 값을 복사
					}
					detect(y, x, vMap, d);
					//다음번째  CCTV 호출
					dfs(idx + 1, vMap);
				}
				break;
			case 2 : //  2번 감시 카메라
				for(int d = 0; d < 2 ; d++) {
					//				감시
					for(int i = 0; i < N; i++) {
						vMap[i] = Arrays.copyOf(nMap[i],M);
					}
					detect(y, x, vMap, d);
					detect(y, x, vMap, d+2);
					//다음번째  CCTV 호출
					dfs(idx + 1, vMap);
				}
				break;	
			case 3 : //  3번 감시 카메라
				for(int d = 0; d < 4 ; d++) {
					//				감시
					for(int i = 0; i < N; i++) {
						vMap[i] = Arrays.copyOf(nMap[i],M);
					}
					detect(y, x, vMap, d);
					detect(y, x, vMap, (d+1) % 4);
					//다음번째  CCTV 호출
					dfs(idx + 1, vMap);
				}
				break;	
			case 4 : //  4번 감시 카메라
				for(int d = 0; d < 4 ; d++) {
					//감시
					for(int i = 0; i < N; i++) {
						vMap[i] = Arrays.copyOf(nMap[i],M);
					}
					detect(y, x,vMap, d);
					detect(y, x,vMap, (d+1) % 4);
					detect(y, x,vMap, (d+2) % 4);
					//다음번째  CCTV 호출
					dfs(idx + 1, vMap);
				}
				break;	
			case 5 : //  5번 감시 카메라
				//				감시
				for(int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i],M);
				}
				detect(y, x, vMap, 0);
				detect(y, x, vMap, 1);
				detect(y, x, vMap, 2);
				detect(y, x, vMap, 3);			
				//다음번째  CCTV 호출
				dfs(idx + 1, vMap);
				break;			
		}
	}//dfs
	
	
	static void detect(int y, int x, int[][] cMap, int dir) {
		//dir ==>	 0 : 왼쪽, 1 : 상, 2 : 오른쪽, 3 : 아래
		
		switch(dir) {
			case 0 : //왼쪽
				for(int i = x; i >= 0; i--) {
					if(cMap[y][i] == 6) { // 벽이되면,
						break;
					}
					cMap[y][i] = 9;//감시카메라가 비추는 곳을 표시
				}
				break;
			case 2 : //오른쪽
				for(int i = x; i < M; i++) {
					if(cMap[y][i] == 6) { // 벽이되면,
						break;
					}
					cMap[y][i] = 9;
				}
				break;
			case 1 : //위쪽
				for(int i = y; i >= 0; i--) {
					if(cMap[i][x] == 6) { // 벽이되면,
						break;
					}
					cMap[i][x] = 9;
				}
				break;	
			case 3 : //아래쪽
				for(int i = y; i < N; i++) {
					if(cMap[i][x] == 6) { // 벽이되면,
						break;
					}
					cMap[i][x] = 9;
				}
				break;		
		}//switch
	}//detect

	static class CCTV{
		int y, x;
		int type;
		public CCTV(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}		
	}

}//end class
