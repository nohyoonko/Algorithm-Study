import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); // 오름차순 정렬
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            // 인덱스로 나보다 큰 애들이 몇 편 있는지 확인 가능(h편 이상)
            int h = len - i;
            // 나의 인용 횟수가 h번 이상인지 확인
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
