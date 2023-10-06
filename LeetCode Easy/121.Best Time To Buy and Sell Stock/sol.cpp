class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit=0;
        int mini=INT_MAX;
        for(auto item: prices){
            mini = min(mini,prices[item]);
            profit = max(profit,prices[item]-mini);
        }
        return profit;
    }
};
