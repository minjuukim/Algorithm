package day0206;

import java.io.*;
import java.util.*;

public class BOJ_G5_1351_무한수열 {
	static long P, Q;
	static Map<Long, Long> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		map = new HashMap<>();
		
		System.out.println(calc(N));
	}
	
	public static long calc(long n) {
		if(n==0) return 1;
		
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		long div1 = (long) Math.floor(n/P);
		long div2 = (long) Math.floor(n/Q);
		
		map.put(n, calc(div1) + calc(div2));
		return map.get(n);
	}
}
