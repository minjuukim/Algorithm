import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_2577_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 접수의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		// 원형으로 이어져있기 떄문에 k를 추가
		int[] arr = new int[N+k];	//arr=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		int[] eat = new int[d+1];	// 먹은 초밥, 숫자 세는 배열
		
		int count = 0;	// 종류 카운트
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());	//arr=[7, 9, 7, 30, 2, 7, 9, 25, 0, 0, 0, 0]
		}

		// k-1개를 복사해서 뒤에 붙여 넣는다.
		System.arraycopy(arr, 0, arr, N, k-1);	//arr=[7, 9, 7, 30, 2, 7, 9, 25, 7, 9, 7, 0]
		
		// 슬라이딩 윈도우 사용
		// k개 접시의 종류를 카운트
		for (int i = 0; i < k; i++) {
			// 처음 먹어보는 종류의 초밥이라면 ++
			if(eat[arr[i]]++ == 0) {
				count++;
			}
		}
		
		// k개 접시를 선택한 상태에서 다음 선택으로 넘어감
		for (int i = 1; i < N; i++) {
			
			// 기존 세트에 제일 마지막에 현재 접시 추가
			if(eat[arr[i+k-1]]++ == 0) count++; 
			
			// 이전 세트의 제일 앞의 접시 뺴기
			if(--eat[arr[i-1]] < 1) count--;
			
			// 쿠폰처리 고려
			int cur = count;
			if(eat[c] == 0)	// 쿠폰을 사용하지 않았다면
				cur++;
			
			if(cur > max) {
				max = cur;
			}
		}
		
		System.out.println(max);
	}

}
