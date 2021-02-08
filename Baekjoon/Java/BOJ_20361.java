import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력받기 위해 BufferedReader 선언
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N: 종이컵 수, X: 간식이 있는 종이컵이 왼쪽에서 몇번째인지, K: 컵의 위치를 맞바꾸는 횟수
		int N, X, K;
		// 3개의 입력이 공백을 기준으로 한 줄에 들어오기 때문에 split을 사용해서 각 요소별로 일치하는 변수에 Integer로 변환해서 넣어줌
		String[] line = in.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		X = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);

		// 컵을 최초 위치를 저장하고 swap이 진행될 배열 선언 및 초기화
		int[] cup = new int[N];
		for (int i = 0; i < N; i++)
			cup[i] = i + 1;

		// K번 컵의 위치 바꾸기
		for (int i = 0; i < K; i++) {
			// 바꾼 두 컵의 위치가 "A B" 로 들어온 것을 공백으로 자르고 각각 Integer로 변환해서 A, B 변수에 넣어줌
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// 실제 인덱스는 0부터 시작이기 때문에 -1을 둘다 해줌
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;

			// A<->B 해당 인덱스끼리 swap
			int tmp = cup[A];
			cup[A] = cup[B];
			cup[B] = tmp;
		}

		// 간식이 있는 종이컵의 현재 위치를 찾아서 출력
		for (int i = 0; i < N; i++) {
			// 현재 인덱스에 있는 값이 간식이 있는 종이컵과 일치한다면 반복문 종료
			if (cup[i] == X) {
                // 결과 출력
                System.out.println(i + 1);
				break;
			}
		}

	}

}
