public class MaxDotProduct {
    public static void main(String[] args) {
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6, 4};

        int maxDotProduct = maxDotProduct(nums1, nums2);

        System.out.println("Maximum Dot Product of Two Subsequences: " + maxDotProduct);
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m][n];

        // Calculate the dot product for each pair of elements in the two arrays
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
