import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1708_볼록껍질 {
	
	// x좌표와 y좌표의 절대값은 40000을 넘지 않는다.
	static Point first = new Point(40001, 40001);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	
		ArrayList<Point> points = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		
		System.out.println(convexHull(points));
	}
	
	public static int convexHull(ArrayList<Point> points) {
		
		// 기준점 찾기 => y좌표가 가장 작은 점이나, 점들 중에서 x좌표값이 가장 작은 점을 기준점으로 잡음
		for (int i = 0; i < points.size(); i++) {
			if(points.get(i).y < first.y) {
				first = points.get(i);
				
			} else if(points.get(i).y == first.y) {
				if(points.get(i).x < first.x) {
					first = points.get(i);
				}
			}
		}
		
		// 모든 점들을 반시계 방향으로 정렬
		points.sort(new Comparator<Point>() {

			@Override
			public int compare(Point second, Point third) {	
				int ccwR = ccw(first, second, third);
				
				// 기준점과 나머지점들이 ccw로 반시계방향(좌회전)이 되도록 정렬을 시킴.
				if(ccwR > 0) {	// 반시계 방향이면 앞으로
					return -1;
					
				} else if(ccwR < 0) {	// 시계 방향이면 뒤로
					return 1;
					
				} else if(ccwR == 0) {	// 일직선 상에 있으면 거리가 증가하게끔 정렬
					long distance1 = dist(first, second);
					long distance2 = dist(first, third);
					if(distance1 > distance2) {	// 거리가 더 가까운 순으로 정렬
						return 1;
					}
				}
				return -1;
			}
		});
		
		// 그라함 스캔 알고리즘
		Stack<Point> stack = new Stack<Point>();
		stack.add(first);
		for (int i = 1; i < points.size(); i++) {
			while(stack.size()>1 && ccw(stack.get(stack.size()-2), stack.get(stack.size()-1), points.get(i)) <= 0) {
				stack.pop();
			}
			stack.add(points.get(i));
		}
		return stack.size();
	}
	
	static int ccw(Point a, Point b, Point c) {
		long ccwR = (a.x*b.y + b.x*c.y +c.x*a.y) - (b.x*a.y+c.x*b.y+a.x*c.y);	// 외적 이용
		
		if(ccwR > 0) return 1;	// 반시계 방향
		if(ccwR < 0) return -1;	// 시계 방향
		return 0;
	}
	
	static long dist(Point a, Point b) {
		return (b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y);
	}
	
	static class Point {
		// 오버플로우 때문에 long으로 해줌. 이렇게 하지않으면 제출시 런타임 오류가 뜸
		long x;
		long y;
		
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
