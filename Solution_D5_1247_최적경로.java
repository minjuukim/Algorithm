package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	
	static int N, size;
	static Position positions[];
	static Position order[];
	static boolean isSelected[];
	static int min;
	
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());	// 고객의 수 
			st = new StringTokenizer(br.readLine());
			
			size = N+2;
			positions = new Position[size];
			positions[0] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 회사의 좌표 저장
			positions[size-1] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 집의 좌표 저장
			
			for(int n=1; n<=N; n++) {	// 고객들의 좌표정보를 저장
				positions[n] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			order = new Position[size];
			isSelected = new boolean[size];
			min = Integer.MAX_VALUE;
			
			move(1);
			sb.append("#"+t+" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	// 순열 
	public static void move(int cnt) {
		
		if(cnt==size-1) {
			order[0] = positions[0];
			order[size-1] = positions[size-1];
			min = Math.min(min, cal(order));
			return;
		}
		
		for (int i = 1; i < size-1; i++) {
			
			if(isSelected[i]) continue;
			
			order[cnt] = positions[i];
			isSelected[i] = true;
			
			move(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static int cal(Position[] order) {
		
		int distance=0;
		for(int i=0; i<order.length-1; i++) {
			distance += (Math.abs(order[i].x-order[i+1].x) + Math.abs(order[i].y-order[i+1].y));
		}
		return distance;
	}

}
