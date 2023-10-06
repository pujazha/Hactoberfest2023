import java.util.*;
public class letterfrequency{
    public static void main(String args[]){
        System.out.println("Enter the sentence or word : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] str = s.toCharArray();
        for(char i : str){
            if(i!=' '){
                if(hm.containsKey(i)){
                    hm.put(i, hm.get(i)+1);
                }
                else{
                    hm.put(i, 1);
                }
            }
        }
        Set<Character> k = hm.keySet();
        for(char i : k){
            System.out.println("Frequency of "+i+" is = "+hm.get(i));
        }
    }
}