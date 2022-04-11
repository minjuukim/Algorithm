import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// convex hull
// ccw
// (Graham Scan)

// int X => long

public class BOJ_1708_볼록껍질_sol {

	static int N;
	static long sx, sy;
	static long[][] point;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point  = new long[N][2]; // point[i][0] : x, point[i][1] : y
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 시작점
		// y 가 가장 작은 점, 만약 y 가 같다면 x 가 가장 작은 점
		// 출발은 맨 앞 점
		sx = point[0][0];
		sy = point[0][1];

		for (int i = 1; i < N; i++) {
			if( sy > point[i][1] ) {
				sx = point[i][0];
				sy = point[i][1];
			}else if( sy == point[i][1] && sx > point[i][0] ) {
				sx = point[i][0];
				sy = point[i][1];
			}
		}
		
		// 반시계 방향으로 정렬
		Arrays.sort( point, (p1, p2) -> {
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1] );
			if (ret > 0) {			// 반시계 방향이면 앞으로
	            return -1;
	        } else if (ret < 0) {	// 시계 방향이면 뒤로
	            return  1;
	        } else {//가까운 것을 앞으로
	            long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
	            return diff > 0 ? 1 : -1;
	        }
		});
		
//		System.out.println("=======================");
//		for(int i=0; i<point.length; i++) {
//		    System.out.println(Arrays.toString(point[i]));
//		}
//		System.out.println("=======================");
		
		// stack 에 넣으면서 시계방향인 것 제거
		// stack 에 들어 있는 맨 위의 2개와 현재 점을 통해 반시계 방향인지 따진다. 시계방향이면 이전 것을 뺀다.
		// 시작점과 배열 첫 번째 점을 stack 에 넣고 시작
		Stack<long[]> stack = new Stack<>();
        stack.add(new long[] {sx, sy});
        //stack.add(point[0]);
        
        int length = point.length;
        for (int i = 1; i < length; i++) {
        	long[] next = point[i]; // 다음 점을 고려할 때 시계방향 (오목)이 생기면 시계방향이 안 생길 때까지 계속 이전 것을 꺼낸다.
            while ( stack.size() > 1 ) {
            	long[] first = stack.get(stack.size()-2); // next 와 ccw 따질 첫 번째  점 
            	long[] second = stack.get(stack.size()-1); // next 와 ccw 따질 두 번째  점            	
            	int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1] );
            	if ( ret <= 0 ) stack.pop();    // second 제거    ==> 시계방향이거나 또는 직선 방향
            	else break; // 더이상 제거할 게 없으면 while 종료
            }
            stack.add(point[i]);	// 점을 넣기
        }
        
        System.out.println(stack.size());
	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long ret = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);

        if (ret > 0) {			// 반시계 방향
            return 1;
        } else if (ret < 0) {	// 시계 방향
            return -1;
        } else {
            return 0;
        }
    }
	// 루트를 제외한 거리로 계산
	static long distance(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
    
}
