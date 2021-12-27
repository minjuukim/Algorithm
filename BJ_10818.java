package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10818 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N];	// 길이가 N인 배열 선언과 생성
		int min = 1000000;
		int max = -1000000;
		
		for (int i=0; i<N; i++) {
			arr[i] = scan.nextInt();

			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}
		System.out.println(min + " " + max);
	}
}

/*****************방법 2 *************************
public class BJ_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];	// 길이가 N인 배열 선언과 생성
		
		// 배열의 길이만큼 돌면서 i에 입력값을 받는다.
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
			
		// sort를 사용해 배열을 정렬한다
		Arrays.sort(arr);
		// 0번 인덱스 값 = min 값
		// (배열길이-1)번 인덱스 값 = max 값
		System.out.println(arr[0] + " " + arr[N-1]);
	}
}
*/