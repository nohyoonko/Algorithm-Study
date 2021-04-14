import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distance = new int[n + 1]; // 노드까지의 거리
        boolean[][] matrix = new boolean[n + 1][n + 1]; // 연결된 노드 표현
        
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            matrix[from][to] = matrix[to][from] = true;            
        }

        // BFS 탐색
        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(1);

        while(!nodes.isEmpty()) {
            int i = nodes.poll();

            for (int j = 2; j <= n; j++) {
                if (distance[j] == 0 && matrix[i][j]) {
                    distance[j] = distance[i] + 1;
                    nodes.add(j);
                }
            }
        }

        // 가장 멀리 있는 노드가 몇 개인지 계산
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int d : distance) {
            if (max < d) {
                max = d;
                answer = 0;
            }
            if (max == d) answer++;
        }
        
        return answer;
    }
}
