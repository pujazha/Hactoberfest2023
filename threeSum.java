mport java.util.Set;
import java.util.Scanner;
import java.util.HashSet;

class ThreeSum {

  // Time complexity: O(n^2)
  private static List<Integer[]> findThreeSum(int[] nums, int target) {
    List<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int currentTarget = target - nums[i];
      Set<Integer> existingNums = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        if (existingNums.contains(currentTarget - nums[j])) {
          result.add(new Integer[] { nums[i], nums[j], currentTarget - nums[j] });
        } else {
          existingNums.add(nums[j]);
        }
      }
    }
    return result;
  }
}
