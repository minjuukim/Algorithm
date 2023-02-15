package day0215;

import java.io.*;
import java.util.*;

public class Softeer_업무처리 {

	static int H, K, R, ans;
    static Worker[] tree;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());   // 조직도 높이
        K = Integer.parseInt(st.nextToken());   // 업무 개수
        R = Integer.parseInt(st.nextToken());   // 업무 진행날짜

        tree = new Worker[(int)Math.pow(2, H+1)];
        init(1, 0);     // root의 인덱스 = 1

        // 말단 직원들의 할당 업무 저장
        for(int i=(int)Math.pow(2, H); i<(int)Math.pow(2, H+1); i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++) {
                tree[i].job.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1; i<=R; i++) {   // top-down 방식 (루트 직원의 일부터 처리)
            workProcess(1, i, 0);
        }

        System.out.println(ans);
    }

    public static void workProcess(int idx, int d, int depth) {
        if(depth > H) return;

        Worker worker = tree[idx];
        if(depth == H && !worker.job.isEmpty()) {
            int curJob = worker.job.poll();
            if(idx%2 == 0) tree[idx/2].leftJob.offer(curJob);   // 짝수 말단직원인 경우 -> 상사의 왼쪽 job에 추가
            else tree[idx/2].rightJob.offer(curJob);            // 홀수 말단직원인 경우 -> 상사의 오른쪽 job에 추가
        } else if(depth < H && d%2 == 0 && !worker.rightJob.isEmpty()) {    // 짝수 날
            int curJob = worker.rightJob.poll();

            if(idx == 1) ans += curJob;    // 루트라면 완료된 job 추가
            else {
                if(idx%2 == 0) tree[idx/2].leftJob.offer(curJob);   
                else tree[idx/2].rightJob.offer(curJob);          
            }
        } else if(depth < H && d%2 == 1 && !worker.leftJob.isEmpty()) {     // 홀수 날
            int curJob = worker.leftJob.poll();

            if(idx == 1) ans += curJob;    // 루트라면 완료된 job 추가
            else {
                if(idx%2 == 0) tree[idx/2].leftJob.offer(curJob);   
                else tree[idx/2].rightJob.offer(curJob);          
            }
        }

        workProcess(idx*2, d, depth+1);     // 왼쪽 자식노드 작업처리
        workProcess(idx*2+1, d, depth+1);   // 오른쪽 자식노드 작업처리
    }

    public static void init(int idx, int depth) {
        if(depth > H) return;

        Worker newWorker = new Worker(depth);
        tree[idx] = newWorker;

        init(idx*2, depth+1);       // 왼쪽 자식
        init(idx*2+1, depth+1);     // 오른쪽 자식
    }

    public static class Worker {
        int depth;
        Queue<Integer> leftJob;
        Queue<Integer> rightJob;
        Queue<Integer> job;

        public Worker(int depth) {
            this.depth = depth;
            initJob();
        }

        public void initJob() {
            if(depth == H) {    // 말단 직원인 경우
                job = new LinkedList<>();
            } else {    // 그 외 직원인 경우
                leftJob = new LinkedList<>();
                rightJob = new LinkedList<>();
            }
        }
    }
}
