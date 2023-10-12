import java.util.*;

public class KnapSack2 {
    static int n,w;
    static int []wt ;
    static int []vt ;
    static long [][]dp = new long[101][100001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        wt = new int[n];
        vt = new int[n];
        for(int i=0;i<n;i++){
            wt[i] = sc.nextInt();
            vt[i] = sc.nextInt();
           
        }
        
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }

        for(int i= (int) 1e5;i>=0;i--){
            if( knapSack(n-1,i) <= w){
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
    private static long knapSack(int index, int value){ //returns min weight for value(initially max then decrease)
        if(value == 0) return 0;
        if(index < 0) return (long) 1e15;
        if(dp[index][value] != -1) return dp[index][value];

        long ans = knapSack(index-1, value);
        if(value - vt[index] >= 0)
        ans = Math.min(ans,knapSack(index-1, value-vt[index])+wt[index]);

        return dp[index][value] = ans;
    }
}
