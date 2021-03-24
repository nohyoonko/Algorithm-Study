public class 타켓넘버 {

	static int answer = 0;
	
    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    public static void dfs(int idx, int result, int[] numbers, int target) {
    	if (idx == numbers.length) {
    		if (result == target) answer++;
    		return;
    	}
    	
    	dfs(idx + 1, result + numbers[idx], numbers, target);
    	dfs(idx + 1, result - numbers[idx], numbers, target);
    }
	
}
