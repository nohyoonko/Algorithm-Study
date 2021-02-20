import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2116번 주사위 쌓기
// 1. 아래에 있는 주사위 윗면 = 위에 있는 주사위 아랫면(1, 2, 3 순으로 쌓여있음)
// 2. 쌓인 사각기둥의 4개의 옆면 중 한 면의 숫자의 합이 최대가 되도록 옆면 회전 가능(90도, 180도, 270도)
// 3. 한 옆면의 숫자의 합의 최댓값 구하기

public class BOJ_2116 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// Input
		int N = Integer.parseInt(in.readLine());
		int[][] Dices = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			// A B C (E D) F
			// A<=>F, B<=>D, C<=>E
			// 맞은편을 찾으려면 5 - index 해서 찾을 수 있음
			for (int j = 0; j < 6; j++) {
				if (j == 3) Dices[i][4] = Integer.parseInt(st.nextToken());
				else if (j == 4) Dices[i][3] = Integer.parseInt(st.nextToken());
				else Dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Solution
		int max = -1;
		// 1번 주사위 아랫면 고름
		for (int i = 0; i < 6; i++) {
			int up = Dices[0][i];
			int down = Dices[0][5- i];
			int total = -1;
			// 위, 아래가 6이 아니면 옆면의 최대는 항상 6
			if (up != 6 && down != 6) total = 6;
			else {
				// 그 외의 경우에는 직접 최대값 확인 필요
				for (int j = 0; j < 6; j++) {
					int side = Dices[0][j];
					if (side != up && side != down)
						total = Math.max(total, side);
				}
			}
			
			// 2 ~ N 주사위 쌓음
			for (int j = 1; j < N; j++) {
				int nextUpIdx = 0;
				int sideMax = -1;
				// 아래 쌓인 윗면과 위에 쌓인 아랫면 매칭
				for (int k = 0; k < 6; k++) {
					// k: 아래, 5 - k: 위
					if (up == Dices[j][k]) {
						nextUpIdx = 5 - k;
						up = Dices[j][nextUpIdx];
						break;
					}
				}
				// 가장 큰 옆면을 구해서 total 구하기
				for (int k = 0; k < 6; k++) {
					if (k != nextUpIdx && k != 5 - nextUpIdx)
						sideMax = Math.max(sideMax, Dices[j][k]);
				}
				total += sideMax;
			}
			max = Math.max(max, total);
		}
		
		System.out.println(max);
	}

}
