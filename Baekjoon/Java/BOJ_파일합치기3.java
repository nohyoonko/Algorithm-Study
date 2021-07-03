import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_파일합치기3 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(in.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0l;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                sum += (first + second);
                pq.offer(first + second);
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

}
