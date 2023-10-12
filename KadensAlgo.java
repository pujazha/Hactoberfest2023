public class KadensAlgo {
    public static void main(String[] args) {
        int arr[] = {4,3,-2,6,-12,7,-1,6};

        int currMax = arr[0];
        int bestMax = arr[0];
        for(int i=1;i<arr.length;i++){
            currMax += arr[i];  //q1.it will be continued or not ?
            if(currMax < arr[i]){  //if false it will be continued to be the part of prev sub array
                currMax = arr[i];  //q2. form new subarray from here
            }
            if(bestMax<currMax){
                bestMax = currMax;
            }
        }
        System.out.println(bestMax);
    }
}
