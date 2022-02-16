import java.util.Scanner;

public class BOJ_B1_2839_설탕배달 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 배달 무게 (kg)
		int count = 0;			// 배달해야할 봉지 수 
		
		while(N>=3) {
			if(N%5==0) {	// 5의 배수라면 5kg 봉지 추가
				N-=5;		// 전체 배달무게에서 5 감소하고 반복
			} else {		// 5의 배수가 아니라면 3kg 봉지 추가
				N-=3;
			}
			count++;		// 배달 봉지 개수 추가
		}
		
		if(N!=0) System.out.println(-1);	// 정확하게 나눠지지 않는다면 -1출력
		else System.out.println(count);		// 결과 출력
	}

}
