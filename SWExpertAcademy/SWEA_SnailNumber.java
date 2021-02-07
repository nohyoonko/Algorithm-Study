import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int snail[][];
    static int[] N;
 
    static void moveSnail(int n) {
        int num = 1;
        int bound = n;
        int x = 0, y = 0;
        for(int i = 0; i < n * 2 - 1; i++) { // 방향 전환 횟수
            switch (i % 4) {
            case 0: // 오른쪽 이동
                for (int j =0; j < bound; j++) {
                    snail[x][y++] = num++;
                }
                x++; // 다음 시작 위치로 이동
                y--; // 마지막에 ++한 것 다시 --로 돌려놓기
                break;
            case 1: // 아래쪽 이동
                for (int j =0; j < bound - 1; j++) {
                    snail[x++][y] = num++;
                }
                y--;
                x--;
                break;
            case 2: // 왼쪽 이동
                for (int j =0; j < bound - 1; j++) {
                    snail[x][y--] = num++;
                }
                x--;
                y++;
                break;
            case 3: // 위쪽 이동
                for (int j =0; j < bound - 2; j++) {
                    snail[x--][y] = num++;
                }
                y++;
                x++;
                bound -= 2;
                break;
            }
        }   
         
    }
     
    static void printSnail(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append("#" + (t + 1) + "\n");
        for (int i = 0; i < N[t]; i++) {
            for (int j = 0; j < N[t]; j++) {
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        N = new int[T];
         
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            snail = new int[N[i]][N[i]];
            moveSnail(N[i]);
            printSnail(i);
        }
         
        sc.close();
    }
}
