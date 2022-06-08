package day0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_10816_숫자카드2_이분탐색 {
// 문제: 중복 원소 개수 구하기
// 방법: BufferedReader + 이분탐색 (+ UpperBound & LowerBound)
// upper bound: 찾고자 하는 값을 초과한 값을 처음 만나는 위치.
// lower bound: 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치를 의미.
// 만약 원소가 존재하지 않는다면, upper_bound == lower_bound
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 숫자 카드 개수
		int[] cards = new int[N];	// 전체 숫자 카드
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken()); 
			
			// 중복된 원소의 개수 = upperBound(상한) - lowerBound(하한)
			sb.append(upperBound(cards, key) - lowerBound(cards, key)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static int lowerBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;
		
		while(left < right) {	// left==right 될 떄까지 반복.
			
			int mid = (left+right)/2;
			
			if(key <= arr[mid]) {	// key값이 중간값보다 작거나 같은 경우
				right = mid;		// (중복원소에 대해 왼쪽으로 탐색하도록 상계를 내림.)
			} else {
				left = mid+1;
			}
		}
		
		return left;
	}
	
	public static int upperBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;
		
		while(left < right) {	// left==right 될 떄까지 반복.
			
			int mid = (left+right)/2;
			
			if(key < arr[mid]) {	// key값이 중간값보다 작은 경우
				right = mid;		
			} else {		// (중복원소에 대해 오른쪽으로 탐색하도록 하계를 올림.)
				left = mid+1;
			}
		}
		
		return left;
	}
}
