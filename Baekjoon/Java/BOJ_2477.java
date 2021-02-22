import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 2477번 참외밭
// 입력) 1칸(1m^2)에 자라는 참외의 개수 K
//		 임의의 꼭짓점에서 출발하여 반시계방향으로 돌면서 지나는 변의 방향, 길이
// 출력) 육각형 밭에서 자라는 참외의 수

public class BOJ_2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine()); // 1칸에 자라는 참외의 개수

		// 가장 큰 직사각형의 가로, 세로 기준으로 인덱스 +3 하면 비어있는 직사각형의 가로, 세로
		// 가장 큰 직사각형 - 비어있는 직사각형 = ㄱ 모양
		int[] input = new int[6];
		int maxSero = Integer.MIN_VALUE;
		int maxGaro = Integer.MIN_VALUE;
		int seroIdx = 0, garoIdx = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) { // 세로
				if (maxSero < len) {
					maxSero = len;
					seroIdx = i;
				}
			} else { // 가로
				if (maxGaro < len) {
					maxGaro = len;
					garoIdx = i;
				}
			}
			input[i] = len;
		}
		System.out.println(((maxSero * maxGaro) - (input[(seroIdx + 3) % 6] * input[(garoIdx + 3) % 6])) * K);
	}

}
