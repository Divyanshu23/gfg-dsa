import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianStream {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        medianOfStream(arr, n);
        sc.close();
    }

    public static void medianOfStream(int arr[],int n){
        PriorityQueue<Integer> g=new PriorityQueue<Integer>();                              // Min Heap
        PriorityQueue<Integer> s=new PriorityQueue<Integer>(Collections.reverseOrder());    // Max Heap

        s.add(arr[0]);
        System.out.print(arr[0]+" ");
        for(int i=1;i<n;i++){
            int x=arr[i];
            if(s.size()>g.size()) {
                if(s.peek()>x){
                    g.add(s.poll());
                    s.add(x);
                }else g.add(x);
                System.out.print(((double)(s.peek()+g.peek())/2)+" ");
            } else {
                if(x<=s.peek()){
                    s.add(x);
                }else{
                    g.add(x);
                    s.add(g.poll());
                }
                System.out.print(s.peek()+" ");
            }
        }
    }
}