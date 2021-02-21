import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10163번 색종이
// 입력: 가장 왼쪽 아래 칸의 x, y, 너비, 높이
// 출력: 주어진 순서대로 각 색종이가 보이는 부분의 면적을 한줄에 하나씩
// 좌표축 x, y를 생각해야 함! x가 col, y가 row

public class BOJ_10163 {

	static int[][] board = new int[101][101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			// 색종이 크기만큼 해당 좌표에 몇번째 색종이인지 입력
			for (int r = x; r < x + width; r++) {
				for (int c = y; c < y + height; c++) {
					board[r][c] = i;
				}
			}
		}
		
		// 모든 색종이를 놓은 후 각 색종이의 면적 확인
		int[] area = new int[N + 1];
		for (int r = 0; r < 101; r++) {
			for (int c = 0; c < 101; c++) {
				area[board[r][c]]++;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(area[i]).append("\n");
		}
		System.out.println(sb);
	}
	
}
