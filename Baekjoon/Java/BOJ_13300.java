import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//	13300번 방 배정
//	한 방에 배정할 수 있는 최대 인원 K와 조건에 맞게 배정하기 위해 필요한 방의 최소 개수 구하기
//		1. 여학생끼리, 남학생끼리
//		2. 한 방에는 같은 학년의 학생들
//		3. 한 방에 한 명도 가능

public class BOJ_13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[7][2]; // 6개의 학년별(row)로 성별(col)에 따라 인원수 체크
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			// 여학생, 남학생 수를 증가
			if (sex == 0) students[grade][0]++;
			else students[grade][1]++;
		}
		
		int answer = 0;
		for (int i = 1; i <= 6; i++) {
			// 같은 학년의 여학생들을 K명씩 방을 만들고 나머지가 있다면 +1
			if (students[i][0] % K == 0) answer += students[i][0] / K;
			else answer += students[i][0] / K + 1;
			// 같은 학년의 남학생들을 K명씩 방을 만들고 나머지가 있다면 +1
			if (students[i][1] % K == 0) answer += students[i][1] / K;
			else answer += students[i][1] / K + 1;
		}
		System.out.println(answer);
	}

}
