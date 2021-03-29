import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1755 {

	public static void main(String[] args) throws Exception {
		// 표준 입력을 받기 위해 선언, Scanner보다 빠른 BufferedReader 사용.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 한 줄에 동시에 입력되는 M, N을 공백(구분자) 기준으로 자르기 위해 StringTokenizer 사용.
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		// M, N 저장할 변수 선언 후 입력된 문자열을 정수형으로 변환 후 저장.
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// M 이상 N 이하의 정수를 가지고 있는 정수형 ArrayList 선언.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = M; i <= N; i++)
			numbers.add(i);
		
		// ArrayList를 정렬하기 위해 sort 함수를 이용하지만, 정수를 조건에 맞게 정렬하기 위해 Comparator를 오버라이드해서 수정.
		Collections.sort(numbers, new Comparator<Integer>() {
			// 숫자를 영어로 바꿀 때 인덱스를 이용해서 0-9(한 자리 숫자)의 영단어를 가져갈 수 있게 미리 초기화한 배열 선언. 
			String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// 비교할 숫자를 모두 영어로 바꿈.
				String s1 = changeToEng(o1);
				String s2 = changeToEng(o2);
				// String 자체의 compareTo()를 사용하고 s1 - s2이므로 오름차순(사전순) 정렬.
				return s1.compareTo(s2);
			}
			
			// 숫자를 영어로 바꾸기 위한 함수.
			public String changeToEng(int num) {
				// 정수 num이 한 자리 수이면, 일치하는 영어 바로 반환.
				if (num < 10) return eng[num];
				
				// 두 자리 수이면, 한 자리씩 영어로 바꾸기.
				StringBuilder sb = new StringBuilder();
				// 몫: 10의 자리, 나머지: 1의 자리.
				sb.append(eng[num / 10]).append(" ").append(eng[num % 10]);
				// StringBuilder로 만든 문자열을 String으로 바꿔 반환.
				return sb.toString();
			}
		});
		
		// 출력하는 속도를 빠르게 하기 위해 StringBuilder 사용.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.size(); i++) {
			// 숫자 출력, 출력 후 공백 하나 띄우기.
			sb.append(numbers.get(i)).append(" ");
			// 한 줄에 10개씩 출력하기 위해 10번째 수를 출력할 때는 개행 추가.
			if ((i + 1) % 10 == 0) sb.append("\n");
		}
		
		// 마지막 결과 출력.
		System.out.print(sb.toString());
	}

}
