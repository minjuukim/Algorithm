import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_S5_2635_수이어가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();	// 첫번째 수
		
		ArrayList<Integer> num = new ArrayList<>();
		
		// 두번째 수 : 첫번째 수보다 작거나 같은 수  (크면 바로 음수나와서 종료)
		int next = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<=N; i++) {
			num.add(N);	// 첫번째 수
			num.add(i); // 두번째 수
			count = 2;
			int j = 2;
			while(true) {
				next = num.get(j-2)-num.get(j-1);
				if(next<0) break;
				num.add(next);
				j++;
				count++;
			}
			if(max<count) {
				sb.delete(0, sb.length());
				max = count;
				for(int k=0; k<num.size(); k++) {
					sb.append(num.get(k)+" ");
				}
			}
			
			System.out.println();
			num.clear();
		}
		
		System.out.println(max);
		System.out.println(sb);

	}

}
