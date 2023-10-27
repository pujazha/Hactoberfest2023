class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int e=nums.size();
        for(int i=0;i<e;i++){
            if(nums[i]!=i){
                return i;
            
        }
    }
    return e;
    }
};
