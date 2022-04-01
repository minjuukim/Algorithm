import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	
	static int N;
	static int map[][];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) return;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("Problem "+ ++tc +": "+ bfs());
			
		}
	}
	
	// 시작점과 끝점이 정해져있고 모든 가중치가 양수이다. ==> 다익스트라를 사용해서 최소 금액을 찾아간다.
	// 다익스트라 알고리즘 -> dp + 우선순위 큐를 활용하여 풀이하는 알고리즘.
	// Queue 진입 시점은 dp값이 갱신될 경우만 그 다음 정점을 우선순위 큐에 저장한다.
	public static int bfs() {
//		Queue<Node> que = new LinkedList<>();
		Queue<Node> que = new PriorityQueue<>();
		
		int[][] count = new int[N][N];	// 다익스트라를 이용하기 위해 현재 위치까지의 최단 경로를 기록하는 배열
		for (int i = 0; i < N; i++) {
			Arrays.fill(count[i], Integer.MAX_VALUE);
		}
		
		que.offer(new Node(0, 0, map[0][0]));
		count[0][0] = map[0][0];	// 첫번째 위치 초기화
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int curx = cur.x;
			int cury = cur.y;
			int cost = cur.cost;	// count[curx][cury]
			
			if(curx == N-1 && cury == N-1) {
				return cost;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = curx + dx[d];
				int ny = cury + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N ) continue;
				
				// 현재 위치에서 nx, ny로 이동하는 것이 기존의 비용보다 더 적은 경우 
				if(count[nx][ny] > count[curx][cury] + map[nx][ny]) {	// 기존의 가중치보다 작은 경우
					count[nx][ny] = count[curx][cury] + map[nx][ny];	// 더 작은 값으로 업데이트
//					count[nx][ny] = cost + map[nx][ny];
					que.offer(new Node(nx, ny, cost+map[nx][ny]));	// 업데이트한 정보를 큐에 추가
				} 
			}
		}

		return -1;
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;	// 가중치
		
		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {	// 가중치가 낮은 순으로 출력되게 
			return this.cost - o.cost;
		}
	}
}
