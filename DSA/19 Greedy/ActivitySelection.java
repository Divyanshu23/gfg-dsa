import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelection {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new MyPair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyPair(sc.nextInt(), sc.nextInt());
        }
        System.out.println(maxActivities(arr));
        sc.close();
    }

    private static int maxActivities(MyPair[] arr) {
        Arrays.sort(arr);
        int res = 1;
        int n = arr.length;
        
        for(int i=1,s=0;i<n;i++) {
            if(arr[i].start > arr[s].end) {
                res++;
                s = i;
            }
        }
        return res;
    }

    private static class MyPair implements Comparable<MyPair> {
        public int start;
        public int end;
        
        public MyPair(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(MyPair o) {
            return this.end - o.end;
        }
    }
}
