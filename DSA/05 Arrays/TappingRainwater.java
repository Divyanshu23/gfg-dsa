import java.util.ArrayList;
import java.util.Scanner;

public class TappingRainwater {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(tapRainWater(arr));
        sc.close();
    }

    public static int tapRainWater(ArrayList<Integer> arr) {
        int[] rMax = new int[arr.size()];
        int[] lMax = new int[arr.size()];
        lMax[0] = arr.get(0);
        rMax[0] = arr.get(arr.size() - 1);

        for (int i = 1; i < arr.size(); i++) {
            lMax[i] = Math.max(lMax[i-1], arr.get(i));
            rMax[i] = Math.max(rMax[i-1], arr.get(arr.size()-1-i));
        }
        int maxRain = 0;
        for (int i = 0; i < arr.size(); i++) {
            maxRain += Math.min(lMax[i], rMax[i]) - arr.get(i);
        }
        return maxRain;
    }
}
