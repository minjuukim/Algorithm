package day0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_S4_10816_숫자카드2_HaspMap {
// 문제: 중복 원소 개수 구하기
// 방법: HashMap<Key, Value>
// Key = 입력되는 원소
// Value = 원소의 개수 (=중복 입력 된 원소의 개수)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());	// 숫자 카드 개수
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			// getOrDefault(key, defaultValue): key에 대해 map에 저장된 value를 반환.
			// 만약 value가 없을 경우 defaultValue 값을 반환한다.
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(map.getOrDefault(key, 0)).append(" ");
		}
		
		System.out.println(sb);
	}
}
