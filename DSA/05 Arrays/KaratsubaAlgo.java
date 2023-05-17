import java.util.Scanner;

public class KaratsubaAlgo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(multiply(n,m));
        sc.close();
    }

    private static int multiply(int n, int m) {
        if(n < 10 && m < 10)
            return n*m;

        int bits1 = (int)(Math.log(n) / Math.log(2)) + 1;
        int bits2 = (int)(Math.log(m) / Math.log(2)) + 1;

        int bits = bits1 >= bits2 ? bits1 : bits2;

        int A;
        int B;
        if(bits % 2 == 0) {
            A = (n >> (bits/2));
            B = ((1 << (bits/2)) - 1) & (n);
        }
        else {
            A = (n >> (bits/2 + 1));
            B = ((1 << (bits/2 + 1)) - 1) & (n);
        }

        int C;
        int D;
        if(bits % 2 == 0) {
            C = (m >> (bits/2));
            D = ((1 << (bits/2)) - 1) & (m);
        }
        else {
            C = (m >> (bits/2 + 1));
            D = ((1 << (bits/2 + 1)) - 1) & (m);
        }

        int pow2half;
        if(bits % 2 == 0)
            pow2half = (1 << (bits/2));
        else
            pow2half = (1 << (bits/2 + 1));
        int pow2n = pow2half*pow2half;

        int res1 = multiply(A, C);
        int res3 = multiply(B,D);
        int res2 = res1 + res3 - multiply(A-B, C-D);

        return res1*pow2n + res2*pow2half + res3;
    }
}