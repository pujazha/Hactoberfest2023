class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        
        boolean[] dp = new boolean[3];
        dp[0] = true;  // An empty partition is always valid

        for (int i = 2; i <= n; i++) {
            boolean ans = false;

            if (nums[i - 1] == nums[i - 2]) {
                ans = ans || dp[(i - 2) % 3];
            }
            if (i >= 3 && nums[i - 1] == nums[i - 2] && nums[i - 1] == nums[i - 3]) {
                ans = ans || dp[(i - 3) % 3];
            }
            if (i >= 3 && nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] + 1 == nums[i - 3] + 2) {
                ans = ans || dp[(i - 3) % 3];
            }

            dp[i % 3] = ans;
        }

        return dp[n % 3];
    }
}
