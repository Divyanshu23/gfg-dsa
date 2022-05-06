import java.util.Scanner;

public class TowerOfHanoi {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towerOfHanoi(n, 'A', 'B', 'C');
        sc.close();
    }

    public static void towerOfHanoi(int n, char A, char B, char C) {
        if(n == 1) {
            System.out.println("Move disc " + n + " from tower " + A + " to tower " + C);
            return;
        }
        towerOfHanoi(n-1, A, C, B);
        System.out.println("Move disc " + n + " from tower " + A + " to tower " + C);
        towerOfHanoi(n-1, B, A, C);
    }


}
