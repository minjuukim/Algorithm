import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[] people;
	static ArrayList<Integer>[] adjList;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 구역의 개수
		people = new int[N+1];
		adjList = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int k = Integer.parseInt(st.nextToken());
				adjList[i].add(k);
				
			}
		}
		isSelected = new boolean[N+1];
		subset(1);

		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}
	
	// 두개의 선거구로 나누기
	public static void subset(int cnt) {
		
		if(cnt == N+1) {
			// 각 선거구에 포함된 지역이 모두 연결되었는지 확인
			if(isConnect()) {	// 연결 되어있다면
				int sum1 = 0, sum2 = 0;
				for (int i = 1; i <= N; i++) {
					if(isSelected[i]) {
						sum1 += people[i];
					} else sum2 += people[i];
				}
				
				min = Math.min(min, Math.abs(sum1 - sum2));
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
	
	// 각 선거구에 포함된 구역이 모두 연결되었는지 확인 (bfs)
	public static boolean isConnect() {
		boolean[] visited = new boolean[N+1];
		
		int area1=0, area2=0;
		// 각 선거구역에 포함된 한 구역 찾기
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) {
				area1 = i;
				break;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(!isSelected[i]) {
				area2 = i;
				break;
			}
		}
		
		// 선거구에 포함된 구역이 없다면 
		if(area1 == 0 || area2 == 0) return false;
		
		// bfs
		Queue<Integer> que = new LinkedList<Integer>();
		
		// 1 선거구에 포함된 구역들이 모두 연결되었는지 확인
		que.add(area1);
		visited[area1] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();	// 현재 구역
			
			// 현재 구역과 연결된 구역 확인
			for (int i = 0; i < adjList[cur].size(); i++) {
				
				if(visited[adjList[cur].get(i)]) continue;	// 이미 확인한 곳이면 패스
				
				if(!isSelected[adjList[cur].get(i)]) continue;	// 1구역이 아니라면 패스
				
				visited[adjList[cur].get(i)] = true;
				que.add(adjList[cur].get(i));
			}
		}
		
		// 2 선거구에 포함된 구역들이 모두 연결되었는지 확인
		que.add(area2);
		visited[area2] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();	// 현재 구역
			
			// 현재 구역과 연결된 구역 확인
			for (int i = 0; i < adjList[cur].size(); i++) {
				
				if(visited[adjList[cur].get(i)]) continue;	// 이미 확인한 곳이면 패스
				
				if(isSelected[adjList[cur].get(i)]) continue;	// 12역이 아니라면 패스
				
				visited[adjList[cur].get(i)] = true;
				que.add(adjList[cur].get(i));
			}
		}
		
		// 모두 연결되었다면 모두 방문처리가 되어있어야 함
		// 한 곳이라도 연결되지 않았다면
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) return false;
		}
		
		return true;
	}

}
