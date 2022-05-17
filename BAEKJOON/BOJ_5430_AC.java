package day0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String cmd = br.readLine();		// 명령어
			
			int n = Integer.parseInt(br.readLine());	// 배열에 들어있는 수의 개수
			st = new StringTokenizer(br.readLine(), "[],");
			
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(deque, cmd);
		}
		
		System.out.println(sb);
	}
	
	public static void AC(Deque<Integer> deque, String cmd) {
		boolean reverse = false;	
		
		for (char p : cmd.toCharArray()) {
			
			if(p == 'R') {	// 명령어 R일 경우
				reverse = !reverse;		// 방향 뒤집기
				
			} else {	// 명령어 D일 경우
				if(deque.size() == 0) {
					sb.append("error\n");
					return;
				}
				
				if(reverse) {	// 방향이 반대(==문자열이 뒤집힌 상태)라면 뒤에서 제거
					deque.removeLast();
				} else {	// 방향이 바뀌지 않았다면 (문자열이 뒤집히지 않았다면) 앞에서 제거
					deque.removeFirst();
				}
			}
		}
		
		sb.append('[');
		while(!deque.isEmpty()) {
			sb.append(reverse? deque.removeLast() : deque.removeFirst());
			if(deque.size()!=0) sb.append(',');
		}
		sb.append(']').append('\n');
		
	}
	

}
