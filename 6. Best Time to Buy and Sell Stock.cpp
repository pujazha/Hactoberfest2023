#include <bits/stdc++.h> 
int maximumProfit(vector<int> &prices){
    // Write your code here.
    int maxPro=0;
	int minPrice=INT_MAX;
	for(int i=0;i<prices.size();i++){
		minPrice =  min(minPrice,prices[i]);
		maxPro = max(maxPro,prices[i]-minPrice);
	}
	return maxPro;
}
