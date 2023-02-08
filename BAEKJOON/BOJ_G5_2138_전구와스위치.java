package day0208;

import java.io.*;
import java.util.*;

public class BOJ_G5_2138_전구와스위치 {
	static int N, ans;
	static char[][] before;
	static char[] after;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		before = new char[2][N];
		before[0] = str.toCharArray();
		before[1] = str.toCharArray();
		
		after = br.readLine().toCharArray();
		ans = Integer.MAX_VALUE;
		
		// 0번째 스위치를 누르지 않고 시작
		go(1, 0, 0);
		
		// 0번째 스위치 누르고 시작
		turnOnOff(0, 1);
		go(1, 1, 1);

		System.out.println(ans == Integer.MAX_VALUE?-1:ans);
	}
	
	public static void turnOnOff(int idx, int type) {
		for(int i=idx-1; i<=idx+1; i++) {
			if(i>=0 && i<N) {
				before[type][i] = before[type][i] == '1'?'0':'1';
			}
		}
	}
	
	public static void go(int idx, int cnt, int type) {
		if(idx==N) {
			if(before[type][idx-1] == after[idx-1]) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		if(before[type][idx-1] != after[idx-1]) {
			turnOnOff(idx, type);
			go(idx+1, cnt+1, type);
		} else {
			go(idx+1, cnt, type);
		}
	}
}
