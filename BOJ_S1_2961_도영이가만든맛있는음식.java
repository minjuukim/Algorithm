package day0214;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_S1_2961_도영이가만든맛있는음식 {
	
	static int N, input[];
	static boolean[] isSelected;
	static int min=Integer.MAX_VALUE;	// 신맛과 쓴맛의 차이의 최소값
	static List<Ingredient> ingredients = new ArrayList<>();
	
	static class Ingredient {	// 재료의 정보
		int sour;		// 신맛
		int bitter;		// 쓴맛
		public Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 재료의 개수
		//foods = new Food[N];
		isSelected = new boolean[N];
		
		for(int n=0; n<N; n++) {	// 재료의 신맛, 쓴맛 정보를 저장
			ingredients.add(new Ingredient(sc.nextInt(), sc.nextInt()));	
			//foods[i] = new Food(sc.nextInt(), sc.nextInt());
		}
		
		subset(0);
		System.out.println(min);
	}

	// 재료의 부분집합 
	private static void subset(int cnt) {
		
		if(cnt==N) {
			int totalSour=1;	// 음식의 신맛. 재료 신맛의 곱이므로 초기값을 1로 설정
			int totalBitter=0;	// 음식의 쓴맛
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {		// 재료가 선택되었을 경우 재료의 정보를 음식의 정보에 곱하거나 더해줌.
					totalSour *= ingredients.get(i).sour;
					totalBitter += ingredients.get(i).bitter;
				}
			}
			
			if(totalSour==1 && totalBitter==0) {	// 아무 재료도 사용되지 않았을 경우는 제외
				return;
			}

			min = Math.min(min, Math.abs(totalSour-totalBitter));	// 신맛과 쓴맛의 절대값과 최소값을 비교하여 더 작은 값을 최소값으로 저장
			
			return;
		}
		
		// 현재 재료를 선택한 경우
		isSelected[cnt] = true;
		subset(cnt+1);
		// 현재 재료를 선택하지 않은 경우
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
}
