import java.util.Scanner;

public class PrimeFactors {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Number: " + n);
        primeFactors(n);
        sc.close();
    }
    
    public static void primeFactors(int n) {
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n = n/2;
        }

        while (n % 3 == 0) {
            System.out.print(3 + " ");
            n = n/3;
        }

        for (int i = 5; i*i < n; i=i+6) {
            if(n % i == 0) {
                System.out.print(i + " ");
                n = n/i;
            }

            if(n % (i+2) == 0) {
                System.out.print(i+2 + " ");
                n = n / (i+2);
            }
        }
        if(n > 3) System.out.println(n);
    }
}