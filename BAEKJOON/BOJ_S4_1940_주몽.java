package day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1940_�ָ� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// ����� ����
		int M = Integer.parseInt(br.readLine());	// ������ ����µ� �ʿ��� ��
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	// ũ�� �� -> �������� ����
		
		int count = 0;
		// ���� ���� ��ġ�� �������ͷ� ����
		int i = 0;
		int j = N-1;
		
		while(i < j) {
			long sum = arr[i] + arr[j];
			
			if(sum < M) {
				i++;
			} else if(sum > M) {
				j--;
			} else {
				i++;
				j--;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
