import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) break;

            sb.append(checkPalindrome(input) ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean checkPalindrome(String input) {
        int len = input.length();

        // 짝수와 홀수 나눠서 체크
        if (len % 2 == 0) {
            for (int i = len / 2 - 1, j = len / 2; i >= 0 && j < len; i--, j++) {
                if (input.charAt(i) != input.charAt(j)) return false;
            }
        } else {
            for (int i = len / 2 - 1, j = len / 2 + 1; i >= 0 && j < len; i--, j++) {
                if (input.charAt(i) != input.charAt(j)) return false;
            }
        }

        return true;
    }

}
