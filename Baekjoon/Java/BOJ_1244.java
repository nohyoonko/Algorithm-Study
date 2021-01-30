import java.util.Scanner;

public class BOJ_1244 {
	static int[] state; // switch 상태 저장할 배열
	
	private static void boy(int n) {
		for (int i = 0; i < state.length; i++) {
			if ((i + 1) % n == 0) { // n의 배수면, 스위치 상태 바꾸기
				if (state[i] == 0) state[i] = 1;
				else if (state[i] == 1) state[i] = 0;
			}
		}
	}
	
	private static void girl(int n) {
		n -= 1; // 입력받은 n을 인덱스에 맞춰서 -1
		int i = 1;
		while (n - i >= 0 && n + i < state.length) {
			if (state[n - i] != state[n + i]) // 서로 대칭인 스위치 상태가 다르면, 구간 끝
				break;
			i++;
		}
		i -= 1; // 1로 초기화했었기 때문에 -1
		for (int j = n - i; j <= n + i; j++) { // 구간에 있는 모든 스위치 상태 바꾸기
			if (state[j] == 0) state[j] = 1;
			else if (state[j] == 1) state[j] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // switch 개수
		state = new int[N];
		
		for (int i = 0; i < N; i++) {
			state[i] = sc.nextInt();
		}
		int T = sc.nextInt(); // 학생 수
		int[][] student = new int[T][2];
		for (int i = 0; i < T; i++) {
			student[i][0] = sc.nextInt(); // 성별
			student[i][1] = sc.nextInt(); // 받은 수
		}

		for (int i = 0; i < T; i++) {
			if (student[i][0] == 1) { // 남자
				boy(student[i][1]);
			} else if (student[i][0] == 2) { // 여자
				girl(student[i][1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(state[i]).append(" ");
			if ((i + 1) % 20 == 0) // 한 줄에 20개씩 출력하니까 개행
				sb.append("\n");
		}
		System.out.println(sb.toString());
		
		sc.close();
	}

}
