import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;
        for(int j=0;j<n;++j){
            ans = Math.max(ans, lis(j,arr,dp));
        }
        System.out.println(ans);
        sc.close();
    }

    private static int lis(int i,int[] arr, int[] dp){
        if(dp[i] != -1) return dp[i];
        int ans = 1;
        for(int j=0;j<i;++j){
            if(arr[i] > arr[j])
            ans = Math.max(ans, lis(j,arr,dp)+1);
        }
        return dp[i] = ans;
    }
    //O(n*n)
}
