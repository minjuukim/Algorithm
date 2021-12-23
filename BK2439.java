package Baekjoon;

import java.util.Scanner;

public class BK2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			for (int j=0; j<T-i; j++) {
				System.out.print(" ");
			}
			for (int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

}
