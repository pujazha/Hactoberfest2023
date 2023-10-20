#include <iostream>
#include <vector>

using namespace std;

// Binary Search function
int binarySearch(vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Return the index if the element is found
        } else if (arr[mid] < target) {
            left = mid + 1; // Continue searching in the right half
        } else {
            right = mid - 1; // Continue searching in the left half
        }
    }

    return -1; // Return -1 if the element is not found
}

int main() {
    vector<int> arr = {1, 3, 5, 7, 9, 11, 13, 15, 17}; // Sorted array
    int target = 11;

    int result = binarySearch(arr, target);
    if (result != -1) {
        cout << "Element found at index: " << result << endl;
    } else {
        cout << "Element not found in the array." << endl;
    }

    return 0;
}
