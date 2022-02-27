package sol;

import java.util.Scanner;

public class BOJ_S4_2477_참외밭2 {
  public static void main(String[] args) {	  
	  
	 Scanner sc = new Scanner(System.in);
	 
	 //육각형의 정보 입력 (세로,가로)
	 //동서남북(1,2,3,4)  (가로,가로, 세로,세로)

	    int K=sc.nextInt();//1m^2 넓이에 자라는 참외의 개수
	    
	    int[] line = new int[6];//6각형 둘레의 길이 정보 저장
	    
	    int maxWidth = 0; //전체 너비(가로)
	    int maxHeight = 0; //전체 높이(세로)
	    int cutWidth = 0; //잘라낼 너비(가로)
	    int cutHeight = 0;//잘라낼 높이(세로)
	    
	    for (int i = 0; i < 6; i++) {
	        sc.nextInt(); //방향의 정보는 사실 필요 없다
	        line[i] = sc.nextInt(); //길이 정보 저장
	    }
	 
	    //전체 큰 사각형의 가로 세로 구하기
	    for (int i = 0; i < 6; i++) {
	        if (i % 2 == 0) { //짝수 인덱스 배열방에 저장된 값을 width라고 가정
	             maxWidth = Math.max(maxWidth, line[i]);
	         }else {
	            if (maxHeight < line[i]) {
	            	maxHeight = line[i];
	            }
	        }
	    }
	 
	    // 한 변을 기준으로 앞,뒤 변의 길이의 합이 길이와 같다면 파인 지점
	    for (int i = 0; i < 6; i++) {
	        if (i % 2 == 0) {
	            if (maxHeight == line[(i + 5) % 6] + line[(i + 1) % 6]) {
	            	cutWidth = line[i];
	            }
	        } else {
	            if (maxWidth == line[(i + 5) % 6] + line[(i + 1) % 6]) {
	            	cutHeight = line[i];
	            }
	        }
	    }
	    System.out.println((maxWidth * maxHeight - cutWidth * cutHeight) * K);
	 sc.close();
  }//main
}//end class
