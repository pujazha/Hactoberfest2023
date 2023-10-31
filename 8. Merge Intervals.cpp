#include <bits/stdc++.h> 
/*

    intervals[i][0] = start point of i'th interval
    intervals[i][1] = finish point of i'th interval

*/

vector<vector<int>> mergeIntervals(vector<vector<int>> &intervals)
{
    vector<vector<int>> results;
        sort(intervals.begin(), intervals.end());
        
        for(auto &interval : intervals) {
            if(results.empty() || interval[0] > results.back()[1])
                results.push_back(interval);
            else 
                results.back()[1] = max(results.back()[1], interval[1]);
        }
        return results;
}
