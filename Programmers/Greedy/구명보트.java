import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
		// 가장 가벼운->무거운 순으로 정렬
		Arrays.sort(people);
		int len = people.length;
		int cnt = 0;
		
		// 최대한 가장 가벼운 무게 + 가장 무거운 무게의 조합으로 넣기 위해 양쪽 끝에서부터 이동
		// 둘의 합이 limit을 초과하면 가장 무거운 사람은 나머지 다른 사람들과 같이 타도 무조건 limit 초과
		int leftIdx = 0, rightIdx = len - 1;
		int boat = 0;
		while (cnt < len) {
			if (people[leftIdx] + people[rightIdx] <= limit) {
				leftIdx++; rightIdx--;
				cnt += 2;
			} else { 
				rightIdx--;
				cnt++;
			}
			boat++;
		}
		
		return boat;
    }
}
