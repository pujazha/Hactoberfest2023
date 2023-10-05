public class PowerSet {

    public static void main(String[] args) {
        String s = "abc";
        printPowSet(s, s.length());
    }

    static void printPowSet(String s, int n) {
        int powSize = (int) Math.pow(2, n);
        for (int counter = 0; counter < powSize; counter++) {
            for (int j = 0; j < n; j++) {
                if ((counter & (1 << j)) != 0)
                    System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }
}
