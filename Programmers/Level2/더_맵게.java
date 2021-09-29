import java.util.*;

class Solution {
    public int solution(int[] sc, int K) {
        int answer = 0;
        
        // PriorityQueue에 옮기기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sc.length; i++)
            pq.add(sc[i]);
        
        boolean flag = false;
        while (!flag) {
            // 모두 K 이상이면 반복 종료
            if (pq.peek() >= K) {
                flag = true;
                break;
            }
            
            // 모든 음식을 K 이상으로 만들 수 없음
            if (pq.size() == 1) break;
                
            int first = pq.poll();
            int second = pq.poll();
            
            // 새로운 스코빌 지수
            pq.add(first + second * 2);
            answer++;
        }
        
        if (!flag) answer = -1;
        return answer;
    }
}
