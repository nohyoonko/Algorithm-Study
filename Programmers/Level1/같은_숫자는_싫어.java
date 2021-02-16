import java.util.*;

public class Solution {
	public static int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
	
        int same = arr[0];
        list.add(same);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                same = arr[i];
                list.add(same);
            }
        }
		
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
		return answer;
	}
}
