import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	
	static int V, E;	// 정점수, 간선수
	static int[] parent;	// 각 정점의 부모(대표자) 정보를 저장하는 배열
	static boolean[] visited;	// 선택한 정점의 방문여부를 저장한 배열
	
	static PriorityQueue<Edge> pq;
	static ArrayList<Edge> mst;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());	
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	// 정점의 개수
			E = Integer.parseInt(st.nextToken());	// 간선의 개수
			
			parent = new int[V+1];
			visited = new boolean[V+1];
			pq = new PriorityQueue<>(new EdegeComparator());
			mst = new ArrayList<>();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());	// from정점
				int end = Integer.parseInt(st.nextToken());		// to정점
				int value = Integer.parseInt(st.nextToken());	// 가중치
				pq.add(new Edge(start, end, value));	// 간선들을 가중치로 정렬하는 우선순위 큐에 다 집어넣기
			}
			
			kruskal();
			
			long sum = 0;
			for (int i = 0; i < mst.size(); i++) {
				sum += mst.get(i).value;
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
	
	// makeSet
	public static void kruskal() {	// 크루스칼 
		for (int i = 1; i <= V; i++) {	
			parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			Edge edge = pq.poll();	// 가중치가 작은 간선이 순서대로 나옴
			
			// 간선의 대표자가 같으면 사이클이 생기므로 스킵
			if(find(edge.start) == find(edge.end)) continue;
			
			union(edge.start, edge.end);	// 사이클이 안생기는 간선의 양 접점을 하나로 합병
			mst.add(edge);	// 선택된 간선을 mst에 추가
		}
	}
	
	public static int find(int n) {
		if(parent[n]==n) return n;
		
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {	// 두 집합의 대표자가 다른 경우 합치기
			parent[p1] = p2;
		}
	}
	
	// 우선순위 큐가 간선들을 가중치 순으로 정렬하도록 해주는 비교기능 내장 클래스
	static class EdegeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1; 
		}
	}
	
	// 간선 정보
	static class Edge {
		int start, end, value;

		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}
	}
}
