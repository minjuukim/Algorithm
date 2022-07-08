package day0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S3_19637_IF문좀대신써줘 {
	
	static List<Item> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	// 칭호의 개수
		int M = Integer.parseInt(st.nextToken());	// 캐릭터의 개수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Item(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());
			
			// 이진탐색
			sb.append(binarySearch(power)).append("\n");
			
		}
	}
	
	public static String binarySearch(int power) {
		
		int left = 0;
		int right = list.size()-1;
		int m = 0;
		
		while(left<=right) {
			m = (left+right)/2;
			
			if(power > list.get(m).limit) {
				left = m + 1;
			} else {
				right = m - 1;
			}
		}
		
		return list.get(right+1).name;
	}
	
	public static class Item {
		String name;	// 칭호명
		int limit;		// 전투력 상한값
		
		public Item(String name, int limit) {
			super();
			this.name = name;
			this.limit = limit;
		}
	}

}

