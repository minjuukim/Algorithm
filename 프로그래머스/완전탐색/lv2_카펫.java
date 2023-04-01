class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for(int r=3; r<=sum; r++) {
            int c = sum/r;
            
            if(c<3 || r>c) continue;
            
            if(((r-2)*(c-2)) == yellow) {
                answer[0] = c;
                answer[1] = r;
                break;
            }
        }
        return answer;
    }
}
