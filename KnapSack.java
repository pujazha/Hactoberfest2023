import java.util.*;

public class KnapSack {
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

        long ans = knapSack(n-1,w);
        System.out.println(ans);

        sc.close();
    }
    private static long knapSack(int index, int w){
        if(w == 0) return 0;
        if(index < 0) return 0;
        if(dp[index][w] != -1) return dp[index][w];

        long ans = knapSack(index-1, w);       //object at index is not choosen
        if(w-wt[index] >= 0)
        ans = Math.max(ans,knapSack(index-1, w-wt[index])+vt[index]);  //object at indext is choosen, weight -, value+

        return dp[index][w] = ans;
    }
}
