import java.util.ArrayList;
import java.util.Scanner;

public class CountFlips {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        countFlips(arr);
        sc.close();
    }

    public static void countFlips(ArrayList<Integer> arr) {
        int i = 1;
        int n = arr.size();
        while (i < n) {
            if(arr.get(i) != arr.get(0)) {
                System.out.print("Flip from " + i + " to ");
                i++;
                while (i < n) {
                    if(arr.get(i) != arr.get(i-1)) break;
                    i++;
                }
                System.out.print(i-1 + "\n");
            } else i++;
        }
    }
}
