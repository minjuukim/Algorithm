import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	
	static int N, M, ans=Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] visited;
	static Node start;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];
/*		============비트마스킹 사용 ================================
		a~f 6개의 열쇠 -> [111111][N][M]의 크기를 가진다 -> [64][N][M]
		하나의 경로를 통해 열쇠를 획득한 뒤, 다시 왔던 길을 통해 탐색을 진행
		=> 어느 한 열쇠를 획득했을 경우에 대한 방문 기록을 저장. ==> 3차원 배열 이용
		visited[0][r][c] -> 획득한 열쇠가 없는 경우
		visited[1][r][c] -> 획득한 열쇠가 a인 경우
		visited[3][r][c] -> 획득한 열쇠가 a,b인 경우
		=> 어느 한 열쇠를 획득할 떄마다 현재 열쇠 정보를 갱신하고, 그 열쇠의 깂을 참조하여 visited배열에 방문 기록.
		
		1. 열쇠 정보 저장하기
		a 키를 갖고 잇는 경우 ->   000001
		b 키를 갖고 있는 경우 ->   000010
		a,b 키를 갖고 있는 경우 -> 000011	(a key || b key) (OR연산)
		==> key를 넣는 과정 : OR 연산
		
		2. 문을 열수 있는지 확인하기 (AND 연산)
		B 문 ->       000010 
		a,b 키 획득 ->  000011
		키 AND 문 ->   000010  -> 2  ==> B문에 해당하는 열쇠인 b를 획득했다는 뜻 -> 문을 열 수 있다.
		
		***문과 열쇠를 AND연산한 값이 0보다 크게되면 해당 문을 열 수 있다는 뜻.
		
*/
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					start = new Node(i, j, 0, 0);
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		Queue<Node> que = new LinkedList<>();
		que.offer(start);
		visited[0][start.x][start.y] = true;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int key = cur.key;
			
			if(map[x][y] == '1') return cnt;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny] == '#' || visited[key][nx][ny]) continue;
				
				if(map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
					visited[key][nx][ny] = true;	// 방문 체크
					que.offer(new Node(nx, ny, cnt+1, key));
				}
				
				// 열쇠일 경우
				// 기존에 방문한 지점도 다시 방문할 수 있도록 해야한다.
				else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					// OR 연산을 통해 비트마스킹 이용
					// 각 자리에 1이 오게되면 그 자리에 해당하는 열쇠를 주운 것.
					int newKey = 1 << (map[nx][ny] - 'a');
					newKey = newKey | key;
					
					if(!visited[newKey][nx][ny]) {
						visited[key][nx][ny] = true;
						visited[newKey][nx][ny] = true;
						que.offer(new Node(nx, ny, cnt+1, newKey));
					}
				} 
				
				// 문일 경우
				else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					int door = 1 << (map[nx][ny] - 'A');
					
					// AND 연산을 했을 때 0이 나왔다는 것은 열쇠가 없다는 것.
					if((key & door) > 0) {	// 일치하는 열쇠가 있으면
						visited[key][nx][ny] = true;
						que.offer(new Node(nx, ny, cnt+1, key));
					}
				} 
			}
		}
		return -1;
	}
	
	static class Node{
		int x;
		int y;
		int cnt;	// 이동횟수
		int key;	// 보유하고 있는 키
		
		public Node(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

}
