import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링_sol {
	static int N;
	static int[] peoples;
	static int[][] maps;
	static int result = Integer.MAX_VALUE;
	
/*
<분석>
구역 - N개(여러개)
선거구 - 2개

==> 정리 : N개의 구역을 2개의 선거구로 나누기
==> 예)
    구역 [a]  [b]  [c]  [d]  [e]  [f]
     2개의 선거구 : 
          
       <1번선거구>                              <2번선거구>
         [a] [b] [c]                         [d]  [e]  [f]
      --------------------------------------------------------------------
         [a] [b]                             [c]  [d]  [e]  [f]
         [a]                                 [b]  [c]  [d]  [e]  [f]
      --------------------------------------------------------------------

         [a] [b] [c] [d]                     [e]  [f]
         [a] [b] [c] [d]  [e]                [f]

<규칙>
1. 구역을 두 개의 선거구로 나눈다.
    ==> 각 선거구에 한개이상의 영역이 존재 (1~N-1)
    
2. 같은 선거구의 각 구역은 모두 연결되어 있어야 한다. 
    ==> 서로다른 선거구는 연결되어 있지 않아도 된다.

<결과출력>
두개의 선거구의  최소 인구차~!!

<방법>
BFS, 부분집합, 인접행렬 (연결정보)
 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //1번째 줄 : 구역수
		peoples = new int[N+1];     //입력번호가 1부터 시작 (0인덱스 버리기)
		int[] teams = new int[N+1];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());  //2번째 줄 : 각구역의 인원
		
//		각 구역별 인원 입력받기
		for(int i = 1; i <= N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());	 		
		}
		
//		구역별 연결된 정보 입력 받기		
		maps = new int[N+1][N+1];
		int cnt = 0;
		for(int i = 1;i <= N; i++) {
			st = new StringTokenizer(br.readLine());//3번째 줄 부터 : 연결(인접)관계 
			cnt = Integer.parseInt(st.nextToken());	//인접한 구역수	
			int idx;
			for(int c = 0; c < cnt; c++) {
				 idx = Integer.parseInt(st.nextToken());
				 maps[i][idx] = 1; 
			}
		}
	
		solve(teams, 1);
		
		if(result == Integer.MAX_VALUE) {//변경이 없다면 구역나누기 실패
			System.out.println(-1);
		}else {
			System.out.println(result); //구역나누기 성공시 두 선거구의 최소 인구 차이 출력 
		}
	}//main
	
	
	static void solve(int[] teams, int cnt) {
//		모든 지역 배치해보기
		if(cnt == N + 1) {
//			두 구역으로 정확하게 분리되었나 확인하기

			if(checkbfs(teams,0) && checkbfs(teams,1)) {
				result = Math.min(result, doCount(teams));
			}
			return;
		}
		teams[cnt] = 0;
		solve(teams, cnt + 1);
		teams[cnt] = 1;
		solve(teams, cnt + 1);
		
	}
	
	
	static boolean checkbfs(int[] teams, int type) {
		boolean[] v = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
//		시작하는 정점을 찾아서 큐에 삽입한다.
		for(int i = 1; i <= N; i++) {
			if(teams[i] == type) {
				q.offer(i);
				v[i] = true;
				break;
			}
		}
		
//		두 구역으로 분리될 수 없으면 바로 반환
		if(q.isEmpty()) {
			return false;
		}
		
//		그 정점으로 모두 연결되어 있는지 BFS 검색
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i = 1; i <= N; i++) {
//				이미 방문한 정점 무시
				if(v[i]) {
					continue;
				}
//				같은 구역이 아니면 무시
				if(teams[i] != type) {
					continue;
				}
//				연결되어 있지 않으면 무시
				if(maps[cur][i] == 0) { 
					continue;
				}
//				그렇지 않으면 큐에 삽입하고 방문 체크를 한다.
				q.offer(i);
				v[i] = true;
			}
		}
//		모든 정점을 방문해 보면서 다른 구역은 무시하고 같은 구역이면 방문했는지 체크해서  
//		방문 체크되어 있지 않으면 연결되어 있지 않음으로 바로 false 값을 반환
		for(int i = 1; i <= N; i++) {
			if(teams[i] != type) {
				continue;
			}
			if( !v[i] ) {
				return false;
			}
		}
//		최종까지 오면 모든 구역이 하나로 연결되어 있음
		return true;
	}
	static int doCount(int[] teams) {
//		두 구역별 합계를 구하고 그 차이값을 반환
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 1; i <= N; i++) {
			if(teams[i] == 0) {
				sum1 += peoples[i];
			}else {
				sum2 += peoples[i];
			}
		}
		return Math.abs(sum1 - sum2);
	}
}
