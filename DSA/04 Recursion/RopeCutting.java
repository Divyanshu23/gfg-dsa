import java.util.Scanner;

public class RopeCutting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(ropeCuttingProblem(n, a, b, c));
        sc.close();
    }

    public static int ropeCuttingProblem(int n, int a, int b, int c) {
        if(n==0) return n;
        else if(n<=-1) return -1;
        int m1 = ropeCuttingProblem(n-a, a, b, c);
        int m2 = ropeCuttingProblem(n-b, a, b, c);
        int m3 = ropeCuttingProblem(n-c, a, b, c);
        int max = Math.max(Math.max(m1,m2),m3);
        if(max == -1) return -1;
        else return max+1;
    }
}
