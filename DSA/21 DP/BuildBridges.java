import java.util.Arrays;
import java.util.Scanner;

public class BuildBridges {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new MyPair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyPair(sc.nextInt(), sc.nextInt());
        }
        System.out.println(buildBridges(arr));
        sc.close();
    }

    

    private static int buildBridges(MyPair[] arr) {
        Arrays.sort(arr);
        return lis(arr);
    }

    private static int lis(MyPair[] arr) {
        int n = arr.length;
        var tail = new int[n];
        int pos = -1;
        tail[++pos] = arr[0].city2;

        int k;
        for (int i = 1; i < n; i++) {
            if(arr[i].city2 > tail[pos]) {
                tail[++pos] = arr[i].city2; 
            } else {
                k = findCeiling(tail, arr[i].city2, 0, pos);
                tail[k] = arr[i].city2;
            }
        }
        return pos+1;
    }

    private static int findCeiling(int[] arr, int k, int s, int e) {
        int mid;

        int ans = e;
        while (s <= e) {
            mid = s + (e-s)/2;
            if(arr[mid] == k) {
                ans = mid;
                s = mid+1;
            } else if(arr[mid] < k) {
                s = mid+1;
            } else {
                ans = mid;
                e = mid-1;
            }
        }
        return ans;
    }

    private static class MyPair implements Comparable<MyPair> {
        int city1;
        int city2;

        public MyPair(int city1, int city2) {
            this.city1 = city1;
            this.city2 = city2;
        }
        
        @Override
        public int compareTo(MyPair obj) {
            if(this.city1 < obj.city1)
                return -1;
            else if(this.city1 > obj.city1)
                return 1;
            else
                return this.city2 - obj.city2;
        }
    }
}
