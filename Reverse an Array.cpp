#include <iostream>
#include <algorithm>

class GFG {
public:
    static void reverse(int arr[], int n, int k) {
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = std::min(i + k - 1, n - 1);
            int temp;

            while (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left += 1;
                right -= 1;
            }
        }
    }

    int main() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int n = sizeof(arr) / sizeof(arr[0]);

        reverse(arr, n, k);

        for (int i = 0; i < n; i++) {
            std::cout << arr[i] << " ";
        }
        return 0;
    }
};

int main() {
    GFG gfg;
    gfg.main();
    return 0;
}
