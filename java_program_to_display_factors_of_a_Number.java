import java.util.Scanner;

public class java_program_to_display_factors_of_a_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        System.out.print("Factors of " + number + " are: ");
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        
        scanner.close();
    }
}
