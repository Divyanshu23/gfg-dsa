import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstringDistinct {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(longestSubstringDistinct(str));
    
        sc.close();
    }

    public static int longestSubstringDistinct(String str) {
        int n = str.length();
        int[] prevOccurence = new int[256];
        Arrays.fill(prevOccurence, -1);


        int currLen = 0, maxLen = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(prevOccurence[str.charAt(i)] < (i-currLen)) {
                ++currLen;
                maxLen = Math.max(maxLen, currLen);
                prevOccurence[str.charAt(i)] = i;
            } else {
                currLen = i - prevOccurence[str.charAt(i)];
                prevOccurence[str.charAt(i)] = i;
            }
        }

        return maxLen;
    }
}