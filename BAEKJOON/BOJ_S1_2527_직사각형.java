import java.util.Scanner;

public class BOJ_S1_2527_직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();
			
			// 겹치지 않을 경우
			if(x2<x3 || x4<x1 || y2<y3 || y4<y1) System.out.println("d");
			// 점
			else if((x2==x3 && y2==y3) || (x2==x3 && y1==y4) || (x1==x4 && y1==y4) || (x1==x4 && y2==y3)) 
				System.out.println("c");
			// 선분
			else if(x2==x3 || x1==x4 || y1==y4 || y2==y3)
				System.out.println("b");
			// 직사각형
			else System.out.println("a");
		}
	}
}
