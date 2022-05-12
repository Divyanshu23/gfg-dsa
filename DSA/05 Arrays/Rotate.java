import java.util.Scanner;
import java.util.ArrayList;

public class Rotate {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int d = sc.nextInt();

        System.out.println("Original Array is: " + arr);
        leftRotate(arr, d);
        System.out.println("Left Rotated Array is: " + arr);
        rightRotate(arr, d);
        System.out.println("Original Array is: " + arr);
        sc.close();
    }

    public static void reverse(ArrayList<Integer> arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static void leftRotate(ArrayList<Integer> arr, int d) {
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.size()-1);
        reverse(arr, 0, arr.size()-1);
    }

    public static void rightRotate(ArrayList<Integer> arr, int d) {
        reverse(arr, 0, arr.size()-1);
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.size()-1);
    }
}