public class TwoOddOccuringNumbers {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 3, 4, 8, 4, 4, 32, 7, 7 };
        int[] arr2 = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };

        twoOddOccuring(arr, arr.length);		// 8 32
        twoOddOccuring(arr2, arr2.length);		// 5 6

    }
    static void twoOddOccuring(int[] arr, int n) {
        int xor = 0, res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++)
            xor = xor ^ arr[i];
        int sn = xor & -xor;	// Rightmost set bit
        for (int i = 0; i < n; i++) {
            if ((arr[i] & sn) != 0)
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }
        System.out.println(res1 + " " + res2);
    }
}
