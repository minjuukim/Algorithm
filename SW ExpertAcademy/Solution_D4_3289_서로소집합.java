

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	
	static int n;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#"+t+" ");
			
			n = Integer.parseInt(st.nextToken());	// 1~n
			int m = Integer.parseInt(st.nextToken());	// 연산의 개수
			
			makeSet();	// 초기에 n개의 집합을 이룸
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());	// 연산자
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());	
				
				if(cal==0) {
					union(a, b);
				} else sb.append(isSameSet(a, b));
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[n+1];
		// 자신의 부모 노드를 자신의 값으로 세팅
		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);	// path compression
	}
	
	// a, b 두 집합 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		parents[bRoot] = aRoot;
	}
	
	public static int isSameSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return 1;
		else return 0;
	}

}
