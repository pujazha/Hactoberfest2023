/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.
*/

// This function returns a pair of elements, where one is present exactly once and another is present twice.

class Solution {
    public static int singleElement(int [] arr) {
        int left=0;
        int right=arr.length-1;

        while(left < right) {
            int mid = left + (right - left)/2;
            boolean isEven = (right-mid)/2 == 0;
            if (arr[mid] == arr[mid-1]) {
                if(isEven) {
                    right = mid-2;
                }
                else {
                    left = mid+1;
                }
            }
            else if (arr[mid] == arr[mid+1]) {
                if(isEven) {
                    left = mid+2;
                }
                else {
                    right = mid-1;
                }
            }
            else {
                return arr[mid];
            }
        }
        return arr[left];
    }
}