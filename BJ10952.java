package Baekjoon;

import java.util.Scanner;

public class BJ10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		while (true){	// while문의 조건식은 생략불가
			a = sc.nextInt();
			b = sc.nextInt();
			if (a==0 && b==0) 
				break;	// 자신이 포함된 가장 가까운 반복문을 벗어남
			System.out.println(a+b);
		}
	}
}
