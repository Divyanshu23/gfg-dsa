import java.util.Scanner;

public class FactorialTailRecursive {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n, 1));
        sc.close();
    }

    public static int factorial(int n, int k) {
        if(n == 0 || n == 1) return k;
        return factorial(n-1,k*n);
    }
}
