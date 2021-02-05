import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        
        int sum;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum = numbers[i] + numbers[j];
                if (list.indexOf(sum) < 0) { // 중복이 없다면
                    list.add(sum);
                }
            }
        }
        
        answer = new int[list.size()]; // ArrayList -> int[]
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer); // 오름차순
        return answer;
    }
}