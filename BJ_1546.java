package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// �Է� ����
		
		// �Է��� �������� ����
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = -1;	// �Է¹��� ���� 0���� ũ�ų� ���� ����
		double sum = 0.0;
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(value > max) {
				max = value;
			}
			
			sum += value;
		}
		// �Ź� �ϳ��� value ���� (value/max)*100�� ���ָ鼭 sum�� �����ִ� �ͺ��� 
		// �������� �ѹ��� ������ ���� ������ִ°� ������ �� �� ���̴�
		System.out.println(((sum/max)*100.0) / N);
		// sum�� double���̶� ���갪 ���� double�� ����ȯ �Ǿ� ��ȯ��
	}
}

	/*****���2: �迭 + Scanner 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		double[] scores = new double[num];
		double sum = 0;
		
		for(int i=0; i<num; i++) {
			scores[i] = sc.nextDouble();
		}
		
		Arrays.sort(scores);	// �迭 ����
		
		for(int i=0; i<num; i++) {
			sum += (scores[i] / scores[scores.length-1]) * 100;
		}
		System.out.println(sum/num);
	} */

