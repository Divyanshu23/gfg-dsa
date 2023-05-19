import java.util.Scanner;

public class SquareRoot {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSquareRoot(n));
        sc.close();
    }

    public static int getSquareRoot(int n) {
        int low = 0, high = n;
        int mid, ans = n;

        while (low <= high) {
            mid = low + (high - low)/2;

            if(mid*mid == n) return mid;
            else if(mid*mid < n) {
                ans = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return ans;
    }
}
