import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_B2_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 학생 수
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num==0) {
				list.add(i+1);
			} else {
				list.add(i-num, i+1);
			}
		}
		
		for(int i : list) {
			System.out.print(i+" ");
		}
	}

}
