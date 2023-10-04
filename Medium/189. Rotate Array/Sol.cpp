#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
    k = k % nums.size(); // To make sure k should not be greater than size;
    reverse(nums.begin(),nums.end()); // Reversing Whole Array
    // 1 2 3 4 5 6 7 --> 7 6 5 4 3 2 1
    
    reverse(nums.begin(),nums.begin()+k); // Reversing till k elements
    // 7 6 5 4 3 2 1 --> 5 6 7 4 3 2 1
    
    reverse(nums.begin()+k,nums.end()); // Reversing remaining elements
    // 5 6 7 4 3 2 1 -->  5 6 7 1 2 3 4
     
    }
};
int main()
{
    int size;
    cout<<"Enter the number of elements you want in array:"<<endl;
    cin>>size;
    vector<int>nums;
    for(int i=0;i<size;i++)
    {
        int temp;
        cin >>temp ;
        nums.push_back(temp);
    }
    int k;
    cin>>k;
    Solution obj;
    obj.rotate(nums,k);
    for (auto i : nums)
    cout << i << " ";
    
    return 0;
}