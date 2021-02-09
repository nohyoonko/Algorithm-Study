import java.io.*;

public class SWEA_CalculationCheck {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			boolean flag = true;
			
			for (int i = 0; i < N; i++) {
				String[] s = in.readLine().split(" ");
				
				if (s.length > 2) { // 자식이 있는 경우,
					// 두번째 자리에 들어오는 문자가 연산자가 아니면 유효하지 않음
					String alphabet = s[1];
					if (!(alphabet.equals("+") || alphabet.equals("-") || alphabet.equals("*") || alphabet.equals("/")))
						flag = false;
				} else { // 자식이 없는 경우(단말노드),
					// 두번째 자리에 들어오는 문자가 숫자가 아니면 유효하지 않음
					String number = s[1];
					if (number.equals("+") || number.equals("-") || number.equals("*") || number.equals("/"))
						flag = false;
				}
			}
			// 유효성 결과 출력
			if (!flag) sb.append(0);
			else sb.append(1);
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
