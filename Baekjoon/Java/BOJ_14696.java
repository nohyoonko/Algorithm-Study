import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14696번 딱지놀이
//	 1. ★의 개수가 다르다면, ★이 많은 쪽의 딱지 승
//	 2. ★의 개수가 같고 ●의 개수가 다르다면, ●가 많은 쪽 승
//	 3. ★, ●의 개수가 같고 ■의 개수가 다르다면, ■가 많은 쪽 승
//	 4. ★, ●, ■의 개수가 같고 ▲의 개수가 다르다면, ▲가 많은 쪽 승
//	 5. ★, ●, ■, ▲의 개수가 모두 같다면, 무승부

public class BOJ_14696 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		for (int round = 0; round < N; round++) {
			// 학생 A의 딱지
			st = new StringTokenizer(in.readLine());
			int numA = Integer.parseInt(st.nextToken());
			int[] cardA = new int[5];
			for (int i = 0; i < numA; i++) {
				int shape = Integer.parseInt(st.nextToken());
				cardA[shape]++;
			}
			// 학생 B의 딱지
			st = new StringTokenizer(in.readLine());
			int numB = Integer.parseInt(st.nextToken());
			int[] cardB = new int[5];
			for (int i = 0; i < numB; i++) {
				int shape = Integer.parseInt(st.nextToken());
				cardB[shape]++;
			}
			// 모양별로 개수 확인 후 승, 패, 무승부 결과 출력
			char result = 'D';
			for (int shape = 4; shape >= 1; shape--) {
				if (cardA[shape] > cardB[shape]) {
					result = 'A';
					break;
				}
				else if (cardA[shape] < cardB[shape]) {
					result = 'B';
					break;
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}

}
