import java.util.*;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++){
           height[i] = sc.nextInt();
        }
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        int minCost = memoization(n-1,k,height,dp);
        System.out.println(minCost);

        sc.close();
    }

    private static int memoization(int n,int k, int[] height, int[] dp){
        if(n==0) return 0;
        if(dp[n] != -1) return dp[n];

        int cost = Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){
            if(n-i >= 0)
            cost = Math.min(cost, memoization(n-i, k, height, dp)+Math.abs(height[n]-height[n-i]));
        }
        return dp[n] = cost;

    }
}
