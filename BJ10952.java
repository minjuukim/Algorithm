package Baekjoon;

import java.util.Scanner;

public class BJ10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		while (true){	// while���� ���ǽ��� �����Ұ�
			a = sc.nextInt();
			b = sc.nextInt();
			if (a==0 && b==0) 
				break;	// �ڽ��� ���Ե� ���� ����� �ݺ����� ���
			System.out.println(a+b);
		}
	}
}
