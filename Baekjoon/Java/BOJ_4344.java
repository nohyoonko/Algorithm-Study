import java.io.*;
import java.util.StringTokenizer;

// 4344번 평균은 넘겠지

public class BOJ_4344 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] students = new int[N];
			int total = 0;
			for (int i = 0; i < N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
				total += students[i];
			}
			
			double avg = (double)total / N;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (students[i] > avg) cnt++;
			}
			
			System.out.printf("%.3f%%\n", ((double)cnt / N) * 100);
 		}
	}

}
