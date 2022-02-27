package sol;

import java.util.Scanner;

public class BOJ_S4_2477_참외밭1 {
  public static void main(String[] args) {
	  
	 Scanner sc = new Scanner(System.in);
	 int K=sc.nextInt();//1m^2 넓이에 자라는 참외의 개수
	 
	 //육각형의 정보 입력 (세로,가로)
	 //동서남북(1,2,3,4)  (가로,가로, 세로,세로)
	 int[] line=new int[6];

	 for(int i=0; i<6; i++) {//항상 6번의 정보 : 6각형이기 때문
		 sc.nextInt();  //동서남북 정보  ==> 아! 의미없다!! ==> 변수에 저장하지는 않는다
		 line[i]= sc.nextInt();
	}
	 
	 //가로길이, 세로길이 최대값 구하기
	 int maxWidth=0,maxHeight=0;
	 
	 for(int i=0; i<6; i++) {
		 if(i%2==0) { 
		     if(maxHeight<line[i]) maxHeight=line[i];   //짝수는 짝수끼리 비교
		 }else { 
			 if(maxWidth<line[i]) maxWidth=line[i];     //홀수는 홀수끼리 비교
		 }
	 }
	 
	 //===> 가로/세로의 최대길이 구함.
	 
	 int maxHidx=0,maxWidx=0;
	 
	 for(int i=0; i<6; i++) {
		 if(i%2==0) {
			 if(maxHeight==line[i]) maxHidx=i;  //최대 가로길이가 되는 인덱스 얻기
		 }else {
			 if(maxWidth==line[i]) maxWidx=i;   //최대 세로길이가 되는 인덱스 얻스
		 }
	 }
 
	 int base = Math.max(maxHidx, maxWidx); //반시계방향으로 인덱스가 부여 되었다고 하였을때
	                                        //둘중에 큰 인덱스(번호)를 구하고 기준점으로 삼는다.
	 
	 if(Math.abs(maxHidx-maxWidx)==5) base=0;
	 
	 System.out.println( ( maxHeight*maxWidth - line[ (base+2) % 6]*line[ (base+3) %6])
			                 //전체사각형             -   잘라낼 사각형
			            		  *K  // 단위면적당 참외수
			             );

	 sc.close();
  }//main
}//end class

