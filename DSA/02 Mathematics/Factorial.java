import java.util.Scanner;

public class Factorial {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Original Number: " + n);
        System.out.println("Reversed Number: " + reverse(n));
        System.out.println("Factorial: " +  findFactorial(n));
        System.out.println("Zeros in Factorial: " + countZerosInFactorial(n));
        sc.close();
    }

    public static int reverse(int n) {
        int rev = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            rev = (rev*10) + digit;
            n = n/10;
        }
        return rev;
    }

    public static int findFactorial(int n) {
        if(n <= 1) return 1;
        int fact = 1;;
        for (int i = 1; i <=n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int countZerosInFactorial(int n) {
        int zeros = 0;
        for (int i = 5; i <=n; i=i*5) {
            if(n / i == 0) break;
            zeros += n / i;
        }
        return zeros;
    }
}