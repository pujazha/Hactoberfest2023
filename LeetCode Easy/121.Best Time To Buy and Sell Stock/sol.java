public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int mini = Integer.MAX_VALUE;
        
        for (int price : prices) {
            mini = Math.min(mini, price);
            profit = Math.max(profit, price - mini);
        }
        
        return profit;
    }
}
