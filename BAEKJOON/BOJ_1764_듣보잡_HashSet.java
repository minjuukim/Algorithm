package day0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡_HashSet {
// 분류: 자료 구조, 문자열, 정렬
// 구현: HashSet 사용
// 시간복잡도: O(1) => ArrayList 사용보다 빠름. (O(n))

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken());	// 보도 못한 사람 수
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());		// 듣도 못한 사람 저장
		}
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {		// 듣보잡일 경우 => list에 저장
				list.add(str);
			}
		}
		
		Collections.sort(list); // 정렬
		
		// 결과 출력
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}
}
