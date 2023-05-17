import java.util.Scanner;
import java.util.ArrayList;

public class Majority {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(getMajority(arr));
        sc.close();
    }

    public static int getMajority(ArrayList<Integer> arr) {
        int count = 1;
        int res = 0;

        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i) == arr.get(res)) 
                ++count;
            else if(count == 0) {
                res = i;
                count++;
            }
            else 
                count--;
        }

        count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == arr.get(res)) ++count;
        }

        return (count > (arr.size() / 2)) ? res : -1;
    }
}
