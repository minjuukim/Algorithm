import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JO_1828_냉장고 {
	
	static class Temp implements Comparable<Temp>{		// 화학물질은 온도 정보
		public int lowest;	// 최저 보관 온도
		public int highest;	// 최고 보관 온도
		
		public Temp(int lowest, int hightet) {
			super();
			this.lowest = lowest;
			this.highest = hightet;
		}

		@Override
		public int compareTo(Temp o) {	//먼저 최고 기온을 기준으로 정렬(오름차순) 한 후, 만약 최고 기온이 같다면 최저 기온을 기준으로 정렬(오름차순) 한다.
			int diff = this.highest - o.highest;
			return diff != 0 ? diff : this.lowest-o.lowest;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 화학물질의 수
		int count = 0;		// 냉장고 개수
		int curLow = 0;		// 현재 냉장고의 최저온도
		int curHigh = 0;	// 현재 냉장고의 최고온도
		
		Temp[] temps = new Temp[N];
		
		for(int i=0; i<N; i++) {
			temps[i] = new Temp(sc.nextInt(), sc.nextInt());	// 데이터 입력
		}
		
		/*// 최고보관온도를 기준으로 오름차순 정렬
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(temps[i].highest > temps[j].highest) {
					Temp temp = temps[i];
					temps[i] = temps[j];
					temps[j] = temp;
				}
			}
		}*/
		
		Arrays.sort(temps);    // 최고 온도를 기준으로 오름차순 정렬
		
		// 첫번쨰 냉장고의 온도를 첫번쨰 화학물질의 온도로 셋팅
		curLow = temps[0].lowest;
		curHigh = temps[0].highest;
		count++;
		
		for(int i=1; i<N; i++) {
			if( temps[i].lowest > curHigh ) {	// 현재 냉장고의 최고 온도보다 높은 최저온도의 재료를 만나면
				curLow = temps[i].lowest;		// 그 재료의 최저온도로 냉장고를 셋팅
				curHigh = temps[i].highest;		// 그 재료의 최고온도로 냉장고를 셋팅
				count++;	// 냉장고 추가
			}
		}
		
		System.out.println(count);
	}

}
