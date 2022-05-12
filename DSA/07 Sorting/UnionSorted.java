import java.util.ArrayList;
import java.util.Scanner;

public class UnionSorted {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        var arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        var arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        ArrayList<Integer> union = union(arr1, arr2);
        for (Integer ele : union) {
            System.out.print(ele + " ");
        }
        System.out.println();
        sc.close();
    }

    public static ArrayList<Integer> union(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        var list = new ArrayList<Integer>(n1+n2);

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if(arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                list.add(arr1[i]);
                i++;
            } else {
                list.add(arr2[j]);
                j++;
            }
        }

        return list;
    }
}
