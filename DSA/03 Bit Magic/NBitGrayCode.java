import java.util.ArrayList;
import java.util.Scanner;

public class NBitGrayCode {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> gray = nBitGrayCode(n);
        for (String string : gray) {
            System.out.print(string + " ");
        }
        System.out.print("\n");
        sc.close();
    }

    public static ArrayList<String> nBitGrayCode(int n) {
        ArrayList<String> gray = new ArrayList<String>();
        gray.add("0");
        gray.add("1");
        int bound = 1<<n;
        for (int i = 2; i < bound; i*=2) {
            for(int j = i-1;j>=0;j--) {
                gray.add(gray.get(j));
            }

            for (int j = 0; j < i; j++) {
                gray.set(j, "0" + gray.get(j));
            }

            for (int j = i; j < 2*i; j++) {
                gray.set(j, "1" + gray.get(j));
            }
        }

        return gray;
    }
}
