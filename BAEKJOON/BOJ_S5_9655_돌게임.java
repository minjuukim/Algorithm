import java.util.Scanner;

public class BOJ_S5_9655_돌게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 돌의 개수
		
		String ans = N%2 == 1 ? "SK" : "CY";
		System.out.println(ans);
	}
}
