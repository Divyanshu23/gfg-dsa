import java.util.Scanner;
// if (a*x)%m === 1, then MMI of (a,m) = x
// Note that MMI only exists when a,m are coprimes. Range of MMI is {1,2,3,...m-1}.

public class ModularMultiplicativeInverse {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        int mmi = MMI(a, m);
        System.out.println("MMI: " + mmi);
        sc.close();
    }

    public static int MMI_naive(int a, int m) {
        for(int i=1;i<m;i++) {
          if((a*i)%m == 1) return i;
        }
        return -1;
    }

    // Femat's Little Theorem (when m is prime). O(log(m))
    // Fermat's little theorem states that if m is a prime number, then for any integer a, the number a^m − a is an integer multiple of m. 
    // In the notation of modular arithmetic, this is expressed as (a^m)%m == a
    
    // If a is not divisible by m, Fermat's little theorem is equivalent to the statement that a^(m−1) − 1 is an integer multiple of m
    // a^(m-1)%m  == 1

    // This method works when m is a prime number.
    public static int MMI(int a, int m) {
        if(gcd(a,m) != 1) {
            return -1;
        } else return powerUnderModulo(a, m-2, m);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static int powerUnderModulo(int a, int m, int mod) {
        if(m == 0) return 1;
        int temp = powerUnderModulo(a, m/2, mod);
        temp = (temp*temp)%mod;
        return m%2 == 0 ? temp : (temp*a)%mod;
    }
}
