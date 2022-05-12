import java.util.Scanner;

import javax.swing.text.Position;

import java.awt.Point;

public class RepeatingElement {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(repeatingElement1(arr));
        sc.close();
    }

    public static Point repeatingElement1(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[(arr[i]%n)-1] += (1%n)*n;
        }

        var res = new Point();
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]/n != 1) && (arr[i]/n != 0)) {
                res.x = arr[i]%n;
                res.y = arr[i]/n;
            }
            arr[i] = arr[i]%n;
        }

        return res;
    }

    public static Point repeatingElement2(int[] arr) {
        int slow = arr[0] + 1;
        int fast = slow;

        do {
            slow = arr[slow + 1];
            fast = arr[arr[fast + 1] + 1];
        } while (slow != fast);

        slow = arr[0] + 1;

        while (slwo != fast) {
            slow = arr[slow + 1];
            fast = arr[fast] + 1;
        }

        return slow - 1;
    }
}
