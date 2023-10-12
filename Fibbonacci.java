class Fibbonacci{
    public static void main(String[] args) {
        int n = 5;
        int[] table = new int[5+1];
        System.out.println(bottomUpApproach(table, n));
        System.out.println(topDownApproach(table, n));
    }
    
    private static int bottomUpApproach(int[] table, int n){
        table[0] = 0;
        table[1] = 1;
        for(int i=2;i<=5;i++){
            table[i] = table[i-1]+table[i-2];
        }
        return table[n];
    }

    private static int topDownApproach(int[] memo, int n){
        if(memo[n]==0){
            if(n<2){
                memo[n] = n;
            } else{
                int left = topDownApproach(memo, n-1);
                int right = topDownApproach(memo, n-2);
                memo[n] = left+right;
            }
        }
        return memo[n];
    }
}