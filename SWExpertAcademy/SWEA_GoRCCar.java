import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int speed = 0, distance = 0;
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                int command = Integer.parseInt(st.nextToken()); // 명령
                // 명령 -> 0: 유지, 1: 가속, 2: 감속
                if (command != 0) {
                    int accel = Integer.parseInt(st.nextToken()); // 가속도
                    if (command == 1) {
                        speed += accel;
                    } else if (command == 2) {
                        if (speed < accel) speed = 0; // 현재 속도보다 감속할 속도가 더 클 경우
                        else speed -= accel;
                    }
                }
                distance += speed; // 1loop가 1초니까 속도만큼 더하기
            }
            sb.append("#").append(tc).append(" ");
            sb.append(distance).append("\n");
        }
        System.out.print(sb.toString());
    }
 
}
