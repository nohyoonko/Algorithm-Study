import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_장훈이의높은선반 {
	
	static int N, B;
	static int[] H;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine(), " ");
			H = new int[N];
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			subset(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(min - B).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void subset(int cnt, int height) {
		if (height >= B) {
			min = Math.min(min, height);
			return;
		}
		
		if (cnt == N) return;
		
		subset(cnt + 1, height + H[cnt]);
		subset(cnt + 1, height);
	}
	
}
