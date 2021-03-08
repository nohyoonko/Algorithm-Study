import java.util.*;

class Solution {
    public int solution(int[][] routes) {
		// 고속도로를 빨리 나가는 순서대로 정렬
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]  - o2[1];
			}
		});
		
		int len = routes.length;
		int answer = 1, camera = routes[0][1]; // 첫번째 차의 진출 지점에 먼저 카메라 설치
		for (int i = 1; i < len; i++) {
			if (camera < routes[i][0]) { // 설치된 카메라를 만나지 않으면 추가
				camera = routes[i][1];
				answer++;
			}
        }
		
		return answer;
    }
}
