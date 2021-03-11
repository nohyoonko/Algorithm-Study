import java.util.*;

// K번째수

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for (int i = 0; i < commands.length; i++) {
            // Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스)
            // 값에 의한 복사이므로 복사된 배열에서 값을 바꿔도 원본 배열의 값이 바뀌지 않음
            int[] calc = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(calc);
            answer[i] = calc[commands[i][2] - 1];
            
        }
        return answer;
    }
}
