#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int numberOfEmployeesWhoMetTarget(vector<int>& hours, int target) {
        int count =0;
        for(int i=0;i<hours.size();i++){
            if(hours[i]>=target){
                count +=1;
            }
        }
        return count;
    }
};
int main()
{
    int size;
    cin>>size;
    vector<int>hours;
    for(int i=0;i<size;i++){
        int val;
        cin>>val;
        hours.push_back(val);
    }
    int target;
    cin>>target;
    Solution sol;
    int res = sol.numberOfEmployeesWhoMetTarget(hours,target);
    cout<<res;
    return 0;
}