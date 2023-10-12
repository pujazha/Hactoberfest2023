import java.util.*;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++){
           height[i] = sc.nextInt();
        }
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        int minCost = memoization(n-1,height,dp);
        System.out.println(minCost);
        sc.close();
    }

    private static int memoization(int n,int []height, int[] dp){
        if(n==0) return 0;
        if(dp[n] != -1) return dp[n];
        int cost = Integer.MAX_VALUE;
        //way1
        cost = Math.min(cost, memoization(n-1, height, dp)+Math.abs(height[n]-height[n-1]));
        //way 2 
        if(n>1)
        cost = Math.min(cost, memoization(n-2, height, dp)+Math.abs(height[n]-height[n-2]));

        return dp[n] = cost;
    }
}
