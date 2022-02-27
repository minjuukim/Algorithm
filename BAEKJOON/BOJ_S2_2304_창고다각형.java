import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_S2_2304_창고다각형 {
	
	public static class Top implements Comparable<Top> {
		int pos;	// 왼쪽 면의 위치
		int h; 		// 기둥 높이
		
		public Top(int pos, int h) {
			super();
			this.pos = pos;
			this.h = h;
		}

		@Override
		public int compareTo(Top o) {
			return this.pos-o.pos;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 기둥의 개수
		
		ArrayList<Top> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int pos = sc.nextInt();	// 왼쪽 면의 위치
			int h = sc.nextInt();	// 기둥 높이
			list.add(new Top(pos, h));
		}
		
		Collections.sort(list);
		
		// 넓이 구하기
		int ans = 0;
		
		// 왼쪽에서 오른쪽으로 (처음~가장높은탑)
		int max = 0;
		Top curtop = list.get(0);
		for(int i=1; i<N; i++) {
			if(curtop.h <= list.get(i).h) {
				ans += curtop.h * (list.get(i).pos - curtop.pos);
				curtop = list.get(i);
				max = i;
			} 
		}
		
		// 오른쪽에서 왼쪽으로 (끝 ~ 가장높은탑)
		curtop = list.get(N-1);
		for(int i=0; i<N-max; i++) {
			if(curtop.h <= list.get(N-i-1).h) {
				ans += curtop.h * (curtop.pos - list.get(N-i-1).pos);
				curtop = list.get(N-i-1);
			} 
		}
		ans += curtop.h;	// 가장 높은 탑 넓이 
		System.out.println(ans);
		
	}

}
