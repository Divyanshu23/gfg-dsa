import java.util.ArrayList;
import java.util.Scanner;

public class Sieve {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Boolean> primes = primeLessThanEqualN(n);
        for (int i = 2; i < primes.size(); i++) {
            if(primes.get(i)) System.out.print(i + " ");
        }
        System.out.print("\n");
        sc.close();
    }

    public static boolean isPrime(int n) {
        if(n == 1 || n % 2 == 0 || n%3 == 0) return false;
        if(n == 2 || n == 3) return true;

        for (int i = 5; i*i <= n ; i+=6) {
            if(n% i == 2 || n%(i+2) == 0) return false;
        }
        return true;
    }

    public static ArrayList<Boolean> primeLessThanEqualN(int n) {
        var primes = new ArrayList<Boolean>(n+1);

        for (int i = 0; i <= n; i++) {
            primes.add(true);
        }

        for (int i = 2*2; i <= n; i+=2) {
            primes.set(i, false);
        }

        for (int i = 3*3; i <= n; i+=3) {
            primes.set(i, false);
        }

        for (int i = 5; i*i <= n; i+= 6) {
            if(isPrime(i)) {
                for (int j = i*i; j <= n; j+=i) {
                    primes.set(j, false);
                }
            }
            if(isPrime(i+2)) {
                for (int j = (i+2)*(i+2); j <= n; j+=(i+2)) {
                    primes.set(j, false);
                }
            }
        }
        return primes;
    }
}
