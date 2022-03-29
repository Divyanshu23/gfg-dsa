import java.util.Scanner;

public class Power {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("The number is " + x + " and exponent is " + n);
        long pow = power(x,n);
        System.out.println("x^n: " + pow);
        pow = powerIterative(x, n);
        System.out.println("x^n: " + pow);
        sc.close();
    }

    public static long power(int x, int n) {
        if( n == 0) return (long)1;

        long temp = power(x, n/2);
        temp = temp*temp;
        if(n % 2 == 0) return temp;
        else return temp*x;
    }

    public static long powerIterative(int x, int n) {
        long res = 1;
        while(n != 0) {
            if((n & 1) == 1) res *= x;
            x = x*x;
            n= n>>1;
        }
        return res;
    }
}
