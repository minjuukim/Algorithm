package day1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_6597_트리복구 {
	
	static char[] pre, in;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		try {
			while(true) {
				String input = br.readLine();
				if(input.isEmpty()) return;
				
				st = new StringTokenizer(input);
				pre = st.nextToken().toCharArray();		// 전위순회 : Root -> L -> R
				in = st.nextToken().toCharArray();		// 중위순회 : L -> Root -> R
				
				postOrder(0, 0, pre.length);	// 전위순회의 맨 앞 노드는 루트노드임.
				System.out.println();
			}
		} catch (Exception e) {
		}
	}
	
	// 후위순회 : L -> R -> Root
	public static void postOrder(int cur, int start, int end) {
		if(start >= end) return;
		char root = pre[cur];	// 1. 프리오더에서 루트노드 구하기
		
		// 2. 인오더에서 루트노드의 인덱스를 찾아, 그것을 기준으로 트리를 좌/우로 나누기
		for(int idx=start; idx<end; idx++) {
			if(in[idx] == root) {	// 이 때, idx는 인오더에서 root노드의 인덱스
				
				postOrder(cur+1, start, idx);		// root 인덱스를 기준으로 왼쪽 서브트리 탐색
				postOrder(cur+(idx-start)+1, idx+1, end);	// root 인덱스를 기준으로 오른쪽 서브트리 탐색
				System.out.print(root);
			}
		}
	}
}
