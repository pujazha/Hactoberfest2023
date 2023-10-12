import java.util.*;
public class HashingQ1 {
    public static void majorityEle(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);//value means freq updaing by 1
            }
            else{
                map.put(arr[i], 1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,1,1,5,1,8,9,1};
        majorityEle(arr);
    }
}
