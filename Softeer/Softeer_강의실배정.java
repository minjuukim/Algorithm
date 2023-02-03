import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 강의 개수
        TimeInfo[] lectures = new TimeInfo[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            lectures[i] = new TimeInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));  
        }

        Arrays.sort(lectures);    // 1. 끝나는 시간 기준 오름차순 정렬

        int curTime = 0;
        int cnt = 0;

        for(TimeInfo lecture : lectures){
            // 2. 현재 강의 시작시간과 전 강의 끝나는 시간이 겹치지 않으면 현재 강의를 배정
            if(lecture.start < curTime) continue;
            else {
                cnt++;      // 배정강의 개수 증가
                curTime = lecture.end;
            }
        }

        System.out.println(cnt);
    }

    static class TimeInfo implements Comparable<TimeInfo> {
        int start;
        int end;

        public TimeInfo(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(TimeInfo o){   // 종료시간 기준 오름차순 정렬
            return this.end - o.end;
        }
    }
}
