package Baekjoon;

import java.util.Scanner;

public class BK2884 {
	
	public static void main(String[] args) {
		int hour, min;
		Scanner scanner = new Scanner(System.in);
		
		hour = scanner.nextInt();
		min = scanner.nextInt();
		
		// if ��
		// 45�� �ռ��� �ð����� �ٲٱ�
		if ( min >= 45 && min <= 59) {	
			min = min-45; 
		} else {
			min = 60-(45-min) ;
			if (hour > 0) {
				hour -= 1;
			} else {
				hour = 23;
			}
		} 
		System.out.print(hour + " " + min);
	}

}
