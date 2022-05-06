import java.util.Scanner;

public class Josephus {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
    }

    public static int josephus(int n, int k) {
        if(n ==1) return 0;
        return (k + josephus(n-1, k))%n;
    }
}
