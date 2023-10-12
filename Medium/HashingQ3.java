import java.util.*;
public class HashingQ3 {
    public static void intersection(int arr1[],int arr2[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4};
        int arr2[]={5,6,1,3};
        intersection(arr1, arr2);
    }
}
