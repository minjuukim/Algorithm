import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        
        for(int t=0; t<3; t++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Pair> list = new ArrayList<>();

            for(int i=0; i<N; i++) {
                int score = Integer.parseInt(st.nextToken());
                result[i] += score;

                list.add(new Pair(score, i+1));
            }

            Collections.sort(list);
            rank(list);
        }

        // 최종 등수 계산
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(new Pair(result[i], i+1));
        }
        Collections.sort(list);
        rank(list);

        System.out.println(sb);
    }

    public static void rank(ArrayList<Pair> list) {
        int[] grade = new int[N+1];
        int preScore = 1001;
        int preGrade = 0;
        int tmp = 0;

        // 등수 계산
        for(Pair p : list) {
            if(p.score == preScore) {   // 직전 사람과 점수가 같으면, 같은 등수
                grade[p.index] = preGrade;
                tmp++;
            } else {    // 직전 사람보다 점수가 낮으면, 직전 사람의 등수에 1 증가.
                grade[p.index] = ++tmp;
                preGrade = tmp;
            }
            
            preScore = p.score;
        }
        
        // 결과 출력
        for(int i=1; i<=N; i++) {
            sb.append(grade[i] + " ");
        }
        sb.append("\n");
    }

    static class Pair implements Comparable<Pair> {
        int score;
        int index;

        public Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return o.score - this.score;    // 점수 내림차순 정렬
        }
    }
}
