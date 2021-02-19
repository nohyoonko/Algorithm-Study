import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_요리사 {
	
	static int N;
	static int[][] S;
	static int[] ingredients;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			// 시너지 입력
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 조합을 위해 재료 인덱스를 배열에 저
			ingredients = new int[N];
			for (int i = 0; i < N; i++) {
				ingredients[i] = i;
			}
			
			// 조합 후 최소값 찾기
			min = Integer.MAX_VALUE;
			combination(0, 0, new int[N / 2]);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int calcSynergy(int[] selected) {
        // 식재료 선택 or 비선택 확인을 위한 배열
		boolean[] checkSelect = new boolean[N];
        
        // 선택된 식재료 true
		for (int i = 0; i < N / 2; i++) {
			checkSelect[selected[i]] = true;
		}
        // 비선택된 식재료 확인 후 배열에 넣어줌
		int[] notSelected = new int[N / 2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!checkSelect[i]) notSelected[idx++] = ingredients[i];
		}
		
        // A, B의 시너지 구하고 차이 리턴
		int A = 0, B = 0;
        // Sii, Sjj는 0이니까 모두 더해서 각각의 시너지 구하기
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				A += S[selected[i]][selected[j]];
				B += S[notSelected[i]][notSelected[j]];
			}
		}
		return Math.abs(A - B);
	}
	
	private static void combination(int cnt, int startIdx, int[] selected) {
		if (cnt == N / 2) {
			int diff = calcSynergy(selected);
			min = Math.min(min, diff);
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			selected[cnt] = ingredients[i];
			combination(cnt + 1, i + 1, selected);
		}
	}

}
