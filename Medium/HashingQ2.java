import java.util.HashSet;

public class HashingQ2 {
    public static void union(int arr1[],int arr2[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println(set);
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3};
        int arr2[]={1,2,3,4,5,6};
        union(arr1, arr2);
    }
}
