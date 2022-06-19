import java.util.Scanner;

// Dutch National Flag Algorithm

public class SortThreeTypes {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortThreeTypes(arr);
        sc.close();
    }
    
    public static void sortThreeTypes(int[] arr) {
        int low = -1, mid = 0, high = arr.length;

        while (mid < high) {
            if(arr[mid] == 0) {
                swap(arr, ++low, mid++);
            } else if(arr[mid] == 2) {
                swap(arr, --high, mid);
            }
            else {
                mid++;
            } 
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}