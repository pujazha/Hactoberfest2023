import java.util.HashMap;

public class Main {
    public static int distinctSubsequences(String s) {
        int mod = (int) (1e9 + 7);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put(s.charAt(0), 0);

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2) % mod;

            if (mp.containsKey(ch)) {
                dp[i] = (dp[i] - dp[mp.get(ch) - 1] + mod) % mod;
            }

            dp[i] %= mod;
            mp.put(ch, i);
        }

        return dp[n] % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(distinctSubsequences(s));
    }
}
