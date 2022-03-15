package sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	
	                // 무 , 상, 우, 하, 좌
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0,  1, 0, -1};
	
	
	static int[] aUserPath, bUserPath;		// A, B의 이동 정보
	static int aUserX, aUserY, bUserX, bUserY; 		// a, b의 시작 좌표
	
	static LinkedList<BatteryCharger> containA = new LinkedList<>(); //A사용자가 사용할 수 있는 BatteryCharger저장
	static LinkedList<BatteryCharger> containB = new LinkedList<>(); //B사용자가 사용할 수 있는 BatteryCharger저장
	static BatteryCharger[] batteryChargers;//BatteryCharger정보 저장
	
	static int M;  //총 이동 시간  
	static int A;  //BC의 개수 
	static int sum;//모든 사용자의 충전량 합의 최대값 		
	
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());//테스트케이스
		int N = 10;	// 맵의 크기 
		
		for (int tc = 1; tc <= T; tc++) {//테스트케이스 시작
			
			StringTokenizer tokens = new StringTokenizer(in.readLine());//공백을 구분자로 하여 token데이터 생성
			M = Integer.parseInt(tokens.nextToken());//이동 개수
			A = Integer.parseInt(tokens.nextToken());//무선충전기 개수
			
			aUserPath = new int[M];//A사용자 이동경로 저장
			bUserPath = new int[M];//B사용자 이동경로 저장
			
			batteryChargers = new BatteryCharger[A];//무선충전기들의 정보 저장
			
			tokens = new StringTokenizer(in.readLine());//공백을 구분자로 하여 token데이터 생성
			for (int i = 0; i <M; i++) {
				aUserPath[i] = Integer.parseInt(tokens.nextToken());//사용자 A 이동정보
			}
			
			
			tokens = new StringTokenizer(in.readLine());//공백을 구분자로 하여 token데이터 생성
			for (int i = 0; i <M; i++) {
				bUserPath[i] = Integer.parseInt(tokens.nextToken());//사용자 B 이동정보
			}
			
			for (int i = 0; i <A; i++) {
				//각 무선충전기 정보담기( 좌표X, 좌표Y, 충전범위C, 성능처리량P )
				tokens = new StringTokenizer(in.readLine());//공백을 구분자로 하여 token데이터 생성
				batteryChargers[i] = new BatteryCharger(
						Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken()));
			}
			
			//초기화
			sum = 0;
			aUserX=aUserY=1;//사용자A 시작좌표
			bUserX=bUserY=N;//사용자B 시작좌표
			
			//이동거리만큼 충전, 이동
			for (int i = 0; i <M; i++) {
				
				sum+=calc();   // 충전량 계산하기   ==> 처음에는 이동하기 전에  A사용자(0,0)와  B사용자(10,10)가 충전할 수 있는 배터리가 있다면 충전량을 계산
				               //             ==> 그 다음(두번째)부터 A사용자, B사용자가 각각 이동한 후 충전량 계산 
				//M=20이라고 하였을때 위의 충전량 계산은 i=0~19까지 계산함.
				
				//이동하기 (0,1,2,3,4 : 무 , 상, 우, 하, 좌)
				aUserY += dy[aUserPath[i]];
				aUserX += dx[aUserPath[i]];
				
				bUserY += dy[bUserPath[i]];
				bUserX += dx[bUserPath[i]];
				
			}
			
			sum+=calc();//마지막 M번째 이동후 마지막 충전량 계산 (M=20이라고 하였을때 i=20 이였을때 계산하는 효과) 
			            //만약 위의 for문을 i=0; i<=M; 으로 하게 되면 ArrayIndexOutOfBoundsException이 발생하게 됨
			            //물론 aUserY += dy[aUserPath[i]];코드 전에 if(i==M) break;문을 추가해도 됨
			
			//결과 출력
			System.out.println("#"+tc+" "+sum);
			
		}//테스트 케이스
		
	}//main
	
	private static int calc() {//충전량 계산하기
		
		//거리 내에 BC가 있는지 체크  
		for (int i = 0; i <A; i++) { //무선충전기의 갯수 만큼!! ==> 무선충전기가 기준!!
			if(isRange(aUserY, aUserX, batteryChargers[i])) {//현재 배터리로 사용자A의 스마트폰 충전이 가능하다면
				containA.add(batteryChargers[i]);//A사용자가 사용할 수 있는 BatteryCharger담기
			}
			if(isRange(bUserY, bUserX, batteryChargers[i])) {
				containB.add(batteryChargers[i]);//B사용자가 사용할 수 있는 BatteryCharger담기
			}
		}		
		
		//거리 내에 있는 BC중에 최고 P값을 구해
		int val = 0, sizeA = containA.size(), sizeB =containB.size();
				
		if(sizeA == 0) {//A사용자가 사용할 수 있는 BatteryCharger가 한개도 없다면
			for (int i = 0; i < sizeB; i++) {
				val = Math.max(val, containB.get(i).p); //B사용자가 얻을 수 있는 최대 충전량 구하기
			}
		}else if(sizeB==0) {//B사용자가 사용할 수 있는 BatteryCharger가 한개도 없다면
			for (int i = 0; i < sizeA; i++) {
				val = Math.max(val, containA.get(i).p); //A사용자가 얻을 수 있는 최대 충전량 구하기
			}
		}else if(sizeA>0 && sizeB>0) {//A사용자, B사용자가 사용할 수 있는 BatteryCharger가 각각 존재 한다면
			for (int i = 0; i < sizeA; i++) {
				for (int j = 0; j < sizeB; j++) {
					if(containA.get(i) == containB.get(j) ) {  //같은 BatteryCharger에 A사용자와 B사용자가 있는경우 
						val = Math.max(val , containA.get(i).p); //사용자 한명의 충전량   (나누기 2의 효과)
					}else {	//A사용자와 B사용자가 사용하는 BatteryCharger가 서로 다른 경우										
						val = Math.max(val , containA.get(i).p+containB.get(j).p); //사용자 두명의 충전량 합
					}
				}
			}
			//위의 for문을 반복하면 ==> 문제 T=11 에서 사용자A [무선충전기1(50)]+ 사용자B [무선충전기1(50)] =  100
			//                                사용자A [무선충전기3(70)]+ 사용자B [무선충전기1(100)] = 170
			//두개의 값이 전부 나오고 Math.max(100,170)을 통해 val=170 이 저장이 됨.
		}
		
		//list 초기화 
		containA.clear();
		containB.clear();
		return val;
	}//calc
	
	
	private static boolean isRange(int userY, int userX, BatteryCharger batteryCharger) {
		                           //(userY, userX) :사용자 위치 정보   (batteryCharger.y, batteryCharger.x) :무선충전기 위치정보
		
		int d = Math.abs(userY-batteryCharger.y)+Math.abs(userX-batteryCharger.x);//현재 사용자의 위치와 무선충전기의 거리구하기 (|y1-y2|+|x1-x2|) 
		return d <= batteryCharger.c ? true: false; //현재 사용자가 무선충전기의 충전 범위에 있다면 true 리턴
	}
	
	
	static class BatteryCharger{//무선충전기
		int x; //열좌표
		int y; //행좌표
		int c; //충전 범위
		int p; //처리량 
		public BatteryCharger(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}//class 
}






