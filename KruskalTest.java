import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
input(첫 줄의 첫 숫자는 정점의 개수, 두 번째 숫자는 간선의 개수).
6 9
1 6 5
2 4 6
1 2 7
3 5 15
5 6 9
3 4 10
1 3 11
2 3 3
4 5 7
 */
public class KruskalTest {
	
	static int V, E, mst;
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		edgeList = new ArrayList<Edge>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());	// from정점
			int end = Integer.parseInt(st.nextToken());		// to정점
			int value = Integer.parseInt(st.nextToken());	// 가중치
			edgeList.add(new Edge(start, end, value));	// 간선들을 가중치로 정렬하는 우선순위 큐에 다 집어넣기
		}
		
		parent = new int[V+1];
		mst = 0;
		
		// makeSet
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		Collections.sort(edgeList);		// 간선의 가중치 순으로 오름차순 정렬
		
		// 낮은 가중치부터 크루스칼 알고리즘 진행
		for (int i = 0; i < E; i++) {
			Edge edge = edgeList.get(i);	
			
			if(find(edge.start) != find(edge.end)) {	// 사이클이 존재하지 않는 경우에만 간선을 선택
				union(edge.start, edge.end);
				mst += edge.value;	
			}
		}
		
		System.out.println("최종 비용 : " + mst);
	}
	

	// 해당 정점의 부모(대표자) 찾기
	public static int find(int x) {
		if(parent[x] == x) 
			return x;
		
		else 
			return find(parent[x]);
	}
	
	
	// 두 집합 합치기
	private static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		
		if(p1 != p2) {	// 두 집합의 대표자가 다른 경우 합치기
			parent[p1] = p2;
		}
		
//		if (p1 > p2) {
//			parent[p1] = p2;
//		} else {
//			parent[p2] = p1;
//		}
	}

	// 간선 정보
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int value;
		
		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {	// 가중치를 기준으로 오름차순 정렬
			return this.value > o.value ? 1 : -1;
		}
	}

}
