public class KadanesAlgo {
    public static void findMaxSum(int arr[]){
        int sum=0;
        int maxi=arr[0];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxi=Math.max(sum,maxi);
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(maxi);
    }
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        findMaxSum(arr);
    }
}
