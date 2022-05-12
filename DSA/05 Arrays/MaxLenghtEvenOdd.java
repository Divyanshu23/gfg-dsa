import java.util.ArrayList;
import java.util.Scanner;

public class MaxLenghtEvenOdd {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(getMaxLenEvenOdd(arr));
        sc.close();
    }

    public static int getMaxLenEvenOdd(ArrayList<Integer> arr) {
        int maxLen = 0, curr = 1;
        boolean flag;
        if(arr.get(0) % 2 == 0) {
            flag = true;
        } else {
            flag = false;
        }
        for (int i = 1; i < arr.size(); i++) {
            if(flag) {
                if(arr.get(i) % 2 != 0) {
                    curr++;
                    flag = !flag;
                } else {
                    maxLen = Math.max(curr, maxLen);
                    curr = 0;
                }
            } else {
                if(arr.get(i) % 2 == 0) {
                    curr++;
                    flag = !flag;
                } else {
                    maxLen = Math.max(curr, maxLen);
                    curr = 0;
                }
            }
        }
        return (curr == 1 ? 0: Math.max(curr, maxLen));
    }
}
