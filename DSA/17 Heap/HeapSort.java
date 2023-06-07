import java.util.Scanner;

public class HeapSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        heapSort(arr);
        for (var item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int temp;
        for (int i = arr.length-1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = (arr.length-2)/2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }

    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int l, r;
        while(i < n) {
            l = left(i);
            r = right(i);

            if(l < n && arr[l] > arr[largest]) {largest = l;}
            if(r < n && arr[r] > arr[largest]) {largest = r;}

            if(largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest;
            } else break;
        }
    }
    
    public static int left(int i) {return 2*i+1;}
    public static int right(int i) {return 2*i+2;}
    public static int parent(int i) {return (i-1)/2;}
}
