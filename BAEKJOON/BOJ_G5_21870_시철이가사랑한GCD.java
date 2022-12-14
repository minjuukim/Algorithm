package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_21870_시철이가사랑한GCD {
	static int[] rooms;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		rooms = new int[N];	// 매물번호 배열
		int mid = N/2;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}

		if(N==1) System.out.println(rooms[0]);
		else {
			System.out.println(Math.max(GCD(mid, N) + calc(0, mid), GCD(0, mid) + calc(mid, N)));
		}
	}
	
	public static int GCD(int start, int end) {
		int gcd = rooms[start];
		
		for(int i=start+1; i<end; i++) {
			gcd = calcGCD(gcd, rooms[i]);
		}
		return gcd;
	}
	
	// 유클리드 호제법 (GCD 구하기)
	public static int calcGCD(int a, int b) {
		while(b != 0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
	
	// 선택하지 않은 원소 배열 계산
	public static int calc(int start, int end) {
		if(start == (end-1)) {		// 원소가 1개인 경우
			return rooms[start];
		}
		
		if(end-start == 2) {		// 원소가 2개인 경우
			return rooms[start] + rooms[end-1];
		}
		
		int mid = (end-start)/2;
		
		return Math.max(GCD(start, start+mid) + calc(start+mid, end), GCD(start+mid, end) + calc(start, start+mid));
	}
}
