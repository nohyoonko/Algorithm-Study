import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<Integer>();
        
        for(int i = 0; i < moves.length; i++) { // move
            for(int row = 0; row < board[0].length; row++) {
                if (board[row][moves[i] - 1] != 0) { // 인형을 찾으면
                    basket.push(board[row][moves[i] - 1]);
                    board[row][moves[i] - 1] = 0;
                    break;
                }
            }
            if (basket.size() >= 2) { // 2개 이상의 인형이 있을 때
                int tmp = basket.pop();
                if (tmp == basket.peek()) { // 같은 인형 두 개가 연속으로 있음
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(tmp);
                }
            }
        }
        
        return answer;
    }
}
