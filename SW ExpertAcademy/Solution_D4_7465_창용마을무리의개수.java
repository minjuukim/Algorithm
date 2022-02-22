import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	
	static int N, count;	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());	// 사람의 수 (1~N번)
			int M = Integer.parseInt(st.nextToken());	// 사람 관계 수 
			
			count = 0;	// 무리의 개수
			makeSet();	// 초기에 N개의 집합을 이룸
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());	
				union(a, b);
			}
			
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.println(sb);
	}
	
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			count++;	// 무리의 개수 증가
		}
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	// a, b 두 집합 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			count--;	// 무리의 개수 감소
		}
	}
}
