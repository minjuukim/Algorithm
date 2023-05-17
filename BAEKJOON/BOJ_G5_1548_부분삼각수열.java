package day0517;

import java.io.*;
import java.util.*;

public class BOJ_G5_1548_부분삼각수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int max = 1;
		for(int first=0; first<N-1; first++) {
			for(int third=first+2; third<N; third++) {
				if(arr[first] + arr[first+1] <= arr[third])break;
				max = Math.max(max, third-first+1);
			}
		}
		
		if(max==1 && N>=2) max = 2;
		
		System.out.println(max);
	}
}
