package basic.string;

public class MultipleStrings {
    public static void main(String args[]){
        System.out.println(multiply("12","11"));
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n + 1];
        // Arrays.fill(ans, 0);
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                ans[i + j] += (num1.charAt(m - i - 1) - '0') * (num2.charAt(n - j - 1) - '0');
                ans[i + j + 1] += ans[i + j] / 10;
                ans[i + j] %= 10;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = m + n - 1;
        // skip leading zeros
        while ((i > 0) && (ans[i] == 0)) -- i;
        while (i >= 0) {
            res.append((char)(48 + ans[i]));
            -- i;
        }
        return res.toString();
    }
}
