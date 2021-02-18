import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 줄 세우기 - 구현

public class BOJ_2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int pickNum;
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			pickNum  = Integer.parseInt(st.nextToken());
			if (pickNum == 0) list.add(i);
			else list.add(i - 1 - pickNum, i);
		}
		for (int i : list)
			System.out.print(i + " ");
	}

}
