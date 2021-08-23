import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_설탕배달 {

    static final int MAX = 5001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int weight[] = new int[MAX];
        Arrays.fill(weight, 9999999);

        weight[3] = weight[5] = 1;

        for (int i = 6; i  MAX; i++) {
            weight[i] = Math.min(weight[i - 3], weight[i - 5]) + 1;
        }

        System.out.print(weight[N] = 9999999  -1  weight[N]);
    }

}