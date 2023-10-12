import java.util.*;

public class CoinChange2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int []coins  = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }

        int [][]dp = new int[301][5001];
        for(int []row : dp)
        Arrays.fill(row, -1);

        int amount = sc.nextInt();
        int ans = coinChange(n-1,coins,amount,dp);
        System.out.println(ans);
        sc.close();
    }

    private static int coinChange(int index, int[] coins, int amount,int[][] dp){
        if(amount==0) return 1;
        if(index < 0) return 0;
        if(dp[index][amount] != -1) return dp[index][amount];

        int ways = 0;
        for(int coin_amount=0; coin_amount<=amount; coin_amount+=coins[index]){
            ways += coinChange(index-1, coins, amount-coin_amount, dp);
        }
        return dp[index][amount] = ways;
    }
}
