import java.util.ArrayList;
import java.util.Scanner;

public class Equilibrium {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int indx = getEquilibriumPoint(arr);
        if(indx == -1) 
            System.out.println("No Equilibrium");
        else
            System.out.println(arr.get(indx));
        sc.close();
    }


    public static int getEquilibriumPoint(ArrayList<Integer> arr) {
        int sum = 0;
        for (var e : arr) {
            sum += e;
        }

        int l_sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(l_sum == sum - arr.get(i)) return i;
            l_sum += arr.get(i);
            sum -= arr.get(i);
        }

        return -1;
    }
}
