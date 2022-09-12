package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_12891_DNA비밀번호 {
	static int ans;
	static String dnaStr;
	static int[] passCheck, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());	// DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());	// 부분문자열 길이
		
		dnaStr = br.readLine();		// DNA 문자열
		
		passCheck = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			passCheck[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = P-1;
		cnt = new int[4];
		
		for(int i=0; i<P; i++) {
			add(i);
		}
		check();
		
		while(right<S-1) {
			delete(left++);
			add(++right);
			check();
		}
		
		System.out.println(ans);
		br.close();
	}

	public static void check() {
		if(cnt[0]>=passCheck[0] && cnt[1]>=passCheck[1] && cnt[2]>=passCheck[2] && cnt[3]>=passCheck[3]) {
			ans++;
		}
	}
	
	public static void delete(int idx) {
		switch(dnaStr.charAt(idx)) {
		case 'A': cnt[0]--; break;
		case 'C': cnt[1]--; break;
		case 'G': cnt[2]--;	break;
		case 'T': cnt[3]--; break;
		}
	}
	
	public static void add(int idx) {
		switch(dnaStr.charAt(idx)) {
		case 'A': cnt[0]++; break;
		case 'C': cnt[1]++; break;
		case 'G': cnt[2]++;	break;
		case 'T': cnt[3]++; break;
		}
	}
}
