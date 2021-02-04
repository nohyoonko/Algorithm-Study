import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_CurIronStick {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int stickCnt = 0;
			int totalStickCnt = 0; // 정답
			String str = br.readLine();

			// 1. 한 글자씩 탐색
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == ')') {
					if (str.charAt(i - 1) == '(') {
						stickCnt--; // 마지막 한 개는 쇠막대기가 아니었네;;
						totalStickCnt += stickCnt; // 현재 열려있던 쇠막대기만큼 조각이 추가
					}
					else if(str.charAt(i - 1) == ')') {
						totalStickCnt++; // 조각 하나 추가
						stickCnt--; // 쇠막대기 하나 감소
					}
				}
				else if (ch == '(')
					stickCnt++;
			}
			
			System.out.println("#" + tc + " " + totalStickCnt);
		}
	}

}
