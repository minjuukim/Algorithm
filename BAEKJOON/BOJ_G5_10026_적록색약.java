import java.util.Scanner;

public class BOJ_G5_10026_적록색약 {
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	// 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 받기
		N = sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i] = str.toCharArray();
			}
		}
		
		// 적록색약이 아닌 경우
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.print(count+" ");
		
		// 적록색약인 경우 (G==R)
		visited = new boolean[N][N];
		count = 0;
		
		// G를 R로 바꿔주고 돌림.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	
	// 구역의 개수 구하기 dfs
	public static void dfs(int x, int y) {
		
		if(visited[x][y]) return;
			
		visited[x][y] = true;
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!(nx>=0 && nx<N && ny>=0 && ny<N)) continue;
			
			if(!visited[nx][ny] && map[nx][ny]==map[x][y]) {	// 이전 값과 동일하다면
				
				dfs(nx, ny);
			} 
			
		}
		
	}
	

}
