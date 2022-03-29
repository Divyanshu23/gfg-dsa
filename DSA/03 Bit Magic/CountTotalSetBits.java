import java.util.Scanner;

public class CountTotalSetBits {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countTotalSetBits(n));
        sc.close();
    }

    public static int countTotalSetBits(int n) {

        int msb = (int)(Math.log(n) / Math.log(2)) + 1;
        int res = 0, rem, patternLenght;
        
        for (int i = 0; i<msb; i++) {
            patternLenght = (1<<i);
            res += ((n+1) /(patternLenght*2))*patternLenght;
            rem = (n+1)%(patternLenght*2);
            if(rem > patternLenght) res += rem - patternLenght;
        }
        return res;
    }
}