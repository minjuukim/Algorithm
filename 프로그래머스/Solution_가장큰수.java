package day1009;

public class Solution_����ū�� {
	
	static int N;
    static int max = 0;
    static int[] isSelected, arr;

	public static void main(String[] args) {

		String answer = "";
        N = numbers.length;
        isSelected = new int[N];
        arr = new int[N];
        
        return answer;
	}
	
	// ����
    public void perm(int[] numbers, int cnt){
        if(cnt==N) {
            //Arrays.toString(arr).replaceAll("[^0-9]", "");
            int num = 0;
            for(int digit : arr) {
                num *= 10;
                num += digit;
            }
            max = 
            return;
        }
            
        for(int i=0; i<N; i++){
            if(isSelected[i]) continue;
            
            arr[cnt] = numbers[i];
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }

}
