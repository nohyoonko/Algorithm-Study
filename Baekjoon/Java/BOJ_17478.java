import java.util.Scanner;

public class BOJ_17478 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	// 메소드화 시키면 시간 절약
	private static void printUnder(int n) {
		for (int i = N; i > n; i--) {
			sb.append("____");
		}
	}
	
	private static void printAnswer_1(int n) {
		printUnder(n);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		printUnder(n);
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		printUnder(n);
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		printUnder(n);
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
	}
	
	private static void printEnd(int n) {
		printUnder(n);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		printUnder(n);
		sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		printUnder(n);
		sb.append("라고 답변하였지.\n");
	}
	
	private static void printAnswer_2(int n) {
		printUnder(n);
		sb.append("라고 답변하였지.\n");
	}
	
	private static void printRecursive(int n) {
		if (n == 0) {
			printEnd(n);
			return;
		}
		
		printAnswer_1(n);
		printRecursive(n - 1); // 유도 파트
		printAnswer_2(n);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		printRecursive(N);
		System.out.println(sb.toString()); // 이게 3개에서 1개로 줄어들면서 시간 절약
		
		sc.close();
	}

}
