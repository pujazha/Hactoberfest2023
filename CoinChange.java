import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int []coins  = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }

        int []dp = new int[10000];
        Arrays.fill(dp, -1);

        int amount = sc.nextInt();
        int ans = coinChange(coins,amount,dp);
        ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
        System.out.println(ans);
        sc.close();
    }

    private static int coinChange(int[] coins, int amount,int[] dp){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount-coins[i] >= 0)
            ans = (int) Math.min(ans+0L, coinChange(coins, amount-coins[i],dp)+1L);
        }
        return dp[amount] = ans;
    }
}
