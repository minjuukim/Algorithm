package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10818 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N];	// ���̰� N�� �迭 ����� ����
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

/*****************��� 2 *************************
public class BJ_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];	// ���̰� N�� �迭 ����� ����
		
		// �迭�� ���̸�ŭ ���鼭 i�� �Է°��� �޴´�.
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
			
		// sort�� ����� �迭�� �����Ѵ�
		Arrays.sort(arr);
		// 0�� �ε��� �� = min ��
		// (�迭����-1)�� �ε��� �� = max ��
		System.out.println(arr[0] + " " + arr[N-1]);
	}
}
*/