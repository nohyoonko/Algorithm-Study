import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_CutIronStick_String {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int stickCnt = 0;
			int totalStickCnt = 0; // 정답
			String str = br.readLine();
			
			// 2. 레이저를 다른 문자로 바꾸면 조건문이 간결해짐
			str = str.replace("()", "X");
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == ')') { // 무조건 쇠막대기의 끝
					totalStickCnt++;
					stickCnt--;
				} else if (ch == 'X') { // 무조건 레이저
					totalStickCnt += stickCnt;
				} else if (ch == '(') { // 무조건 쇠막대기의 시작
					stickCnt++;
				}
			}
			
			System.out.println("#" + tc + " " + totalStickCnt);
		}
	}
	
}
