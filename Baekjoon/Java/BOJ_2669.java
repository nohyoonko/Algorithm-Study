import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네개의 합집합의 면적 구하기

public class BOJ_2669 {
	
	static boolean[][] rectangle = new boolean[100][100];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int area = 0;
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					// 겹쳐있지 않으면 체크 후 면적 증가
					// 결국 한 칸의 면적이 1이기 때문에 ++로 면적 구할 수 있음
					if (!rectangle[r][c]) {
						rectangle[r][c] = true;
						area++;
					}
				}
			}
		}

		System.out.println(area);
	}

}
