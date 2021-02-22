import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 2628번 종이자르기
// 입력된 점선의 번호에 따라 종이를 자른 후 가장 큰 종이조각의 넓이 구하기

public class BOJ_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 가로, 세로 길이
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		// 잘라야하는 점선의 개수
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> cutW = new ArrayList<Integer>();
		ArrayList<Integer> cutH = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			// 자르는 방향(0:가로, 1:세로)과 점선의 번호
			st = new StringTokenizer(in.readLine());
			int wh = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (wh == 0) cutH.add(num);
			else cutW.add(num);
		}
		
		// 잘린 가로/세로 중 가장 긴 길이 찾기
		int maxW = width, maxH = height;
		// 가로
		if (cutW.size() != 0) {
			Collections.sort(cutW);
			maxW = cutW.get(0);
			for (int i = 1; i < cutW.size(); i++)
				maxW = Math.max(maxW, cutW.get(i) - cutW.get(i - 1));
			maxW = Math.max(maxW, width - cutW.get(cutW.size() - 1));
		}
		// 세로
		if (cutH.size() != 0) {
			Collections.sort(cutH);
			maxH = cutH.get(0);
			for (int i = 1; i < cutH.size(); i++)
				maxH = Math.max(maxH, cutH.get(i) - cutH.get(i - 1));
			maxH = Math.max(maxH, height - cutH.get(cutH.size() - 1));
		}
		
		System.out.println(maxW * maxH);
	}

}
