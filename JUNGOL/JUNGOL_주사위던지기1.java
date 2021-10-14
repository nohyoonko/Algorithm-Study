import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] select;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		select = new int[N];
		isSelected = new boolean[7];
		if (M == 1) {
			permutation(0);
		} else if (M == 2) {
			combination(0, 1);
		} else if (M == 3) {
			permutationDupl(0);
		}
	}

	private static void combination(int cnt, int startIdx) {
		if (cnt == N) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = startIdx; i <= 6; i++) {
			select[cnt] = i;
			combination(cnt + 1, i);
		}
	}

	private static void permutationDupl(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			select[cnt] = i;
			permutationDupl(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	private static void permutation(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			select[cnt] = i;
			permutation(cnt + 1);
		}
	}
	
}
