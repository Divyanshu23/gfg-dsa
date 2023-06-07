import java.util.Scanner;

public class Heap {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        var mheap = new MinHeap(arr, n);
        mheap.buildHeap();
        mheap.print();
        sc.close();
    }

    private static class MinHeap {
        int cap;
        int size;
        int[] arr;

        public MinHeap(int cap) {
            this.cap = cap;
            this.size = 0;
            this.arr = new int[cap];
        }

        public MinHeap(int[] arr, int cap) {
            this.cap = cap;
            this.arr = arr;
            this.size = arr.length;
        }

        public void buildHeap() {    // O(n)
            if(size > 2) {
                int i = (size-2)/2;

                for(;i>=0;i--) {
                    heapify(i);
                }
            }
        }

        public void heapify(int i) {
            int l,r;
            int smallest;
            while (i < size) {
                l = left(i);
                r = right(i);
                smallest = i;

                if(l < size && arr[l] < arr[smallest]) {
                    smallest = l;
                }
                if(r < size && arr[r] < arr[smallest]) {
                    smallest = r;
                }

                if(smallest != i) {
                    int temp = arr[smallest];
                    arr[smallest] = arr[i];
                    arr[i] = temp;
                    i = smallest;
                } else break;
            }
        }

        public void decreaseKey(int i, int val) {
            if(i >= size || val >= arr[i])
                return;

            arr[i] = val;
            while (i >= 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[parent(i)];
                arr[parent(i)] = arr[i];
                arr[i] = temp;
                i = parent(i);
            }
        }

        public int extractMin() {
            if(size == 0) 
                return Integer.MAX_VALUE;

            int res = arr[0];
            arr[0] = arr[size-1];
            size--;
            heapify(0);
            return res;
        }

        public void insert(int val) {
            size++;
            arr[size-1] = val;
            int i = size-1;

            while (i != 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[parent(i)];
                arr[parent(i)] = arr[i];
                arr[i] = temp;
                i = parent(i);
            }
        }
        
        public void delete(int i) {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public int left(int i) {return 2*i+1;}
        public int right(int i) { return 2*i+2;}
        public int parent(int i) {return (i-1)/2;}
    }
}