import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new MyPair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyPair(sc.nextInt(), sc.nextInt());
        }
        int W = sc.nextInt();
        System.out.println(maxValue(arr,W));
        sc.close();;
    }

    private static double maxValue(MyPair[] arr, int W) {
        int n = arr.length;
        Arrays.sort(arr);
        double res = 0;

        int s = 0;
        while(W > 0 && s < n) {
            if(arr[s].weight <= W) {
                res += arr[s].value;
                W -= arr[s].weight;
                s++;
            } else {
                res += ((double)W*(arr[s].value))/arr[s].weight;
                W = 0;
            }
        }
        return res;
    }

    private static class MyPair implements Comparable<MyPair> {
        public int weight;
        public int value;
        
        public MyPair(int w, int v) {
            weight = w;
            value = v;
        }

        @Override
        public int compareTo(MyPair o) {
            return (int)(((double)o.value / o.weight) - ((double)this.value / this.weight));
        }
    }
}
