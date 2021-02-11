import java.util.*;

class Solution {
    final static int num = 3;
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] correct = new int[num];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == A[i % A.length]) correct[0]++;
            if (answers[i] == B[i % B.length]) correct[1]++;
            if (answers[i] == C[i % C.length]) correct[2]++;
        }
        
        int max = -1;
        List<Integer> highest = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            if (max < correct[i]) { // 가장 높은 점수가 갱신되면
                max = correct[i];
                highest.clear(); // 최고 득점자 리스트를 비우고 새로 시작
                highest.add(i + 1);
            } else if (max == correct[i]) {
                max = correct[i];
                highest.add(i + 1);
            }
        }
        
        answer = new int[highest.size()];
        for (int i = 0; i < highest.size(); i++)
            answer[i] = highest.get(i);
        
        return answer;
    }
}
