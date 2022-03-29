import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Divisiors {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Divisors of " + n + " are:");
        System.out.println(findDivisors(n));
        sc.close();
    }

    public static ArrayList<Integer> findDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        ArrayList<Integer> rev = new ArrayList<Integer>();
        divisors.add(1);
        rev.add(n);

        for (int i = 2; i*i <= n; i++) {
            if(n%i == 0) {
                divisors.add(i);
                rev.add(n/i);
            }
        }
        Collections.reverse(rev);
        divisors.addAll(rev);
        return divisors;
    }
}
