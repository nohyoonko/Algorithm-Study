import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 별 찍기 - 10

public class BOJ_2447 {

	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// Input
		int N = Integer.parseInt(in.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(arr[i], ' ');
		
		// Solution
		starPrint(N, 0, 0);
		
		// Output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(arr[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void starPrint(int size, int r, int c) {
		if (size == 1) { // 더 이상 쪼갤 수 없는 경우
			arr[r][c] = '*';
			return;
		}
		
		//상
		starPrint(size / 3, r, c); // 좌(시작)
		starPrint(size / 3, r + size / 3, c); // 중
		starPrint(size / 3, r + size / 3 * 2, c); // 우

		// 중
		starPrint(size / 3, r, c + size / 3); // 좌
		starPrint(size / 3, r + size / 3 * 2, c + size / 3); // 우
		
		// 하
		starPrint(size / 3, r, c + size / 3 * 2); // 좌
		starPrint(size / 3, r + size / 3, c + size / 3 * 2); // 중
		starPrint(size / 3, r + size / 3 * 2, c + size / 3 * 2); // 우
	}
}
