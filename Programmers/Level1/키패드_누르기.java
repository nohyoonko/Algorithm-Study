import java.util.*;

class Solution {

    HashMap<Integer, int[]> index = new HashMap<>();
    static char[] use = {'A', 'L', 'A', 'R', 'L', 'A', 'R', 'L', 'A', 'R'};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 번호의 인덱스를 Map에 저장
        int number = 0;
        index.put(number++, new int[] {3, 1});
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                index.put(number++, new int[] {r, c});
            }
        }

        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            char whichHand = use[numbers[i]];
            int[] pos = index.get(numbers[i]);
            
            // L, R 둘 중 어느 손으로 할 지 모르는 경우
            if (whichHand == 'A') {
                // 오른손, 왼손 거리 계산
                int leftDist = Math.abs(left[0] - pos[0]) + Math.abs(left[1] - pos[1]);
                int rightDist = Math.abs(right[0] - pos[0]) + Math.abs(right[1] - pos[1]);
                
                // 더 가까운 손을 이용(같다면 입력값 hand로 결정)
                if (leftDist > rightDist) whichHand = 'R';
                else if (leftDist < rightDist) whichHand = 'L';
                else {
                    if (hand.equals("right")) whichHand = 'R';
                    else whichHand = 'L';
                }
            }
            
            // 현재 사용한 손의 위치 저장 후 append
            if (whichHand == 'L') left = pos;
            else right = pos;
            
            answer.append(whichHand);
        }
        
        return answer.toString();
    }
}
