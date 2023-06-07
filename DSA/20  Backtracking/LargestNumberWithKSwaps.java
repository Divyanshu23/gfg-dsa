import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberWithKSwaps {
    public static void main (String[] args) {
        String str = "1234567";
        res = str.toCharArray();
        findMaximumNum(str, 3);
        System.out.println(new String(res));
    }

    static char[] res;

    public static void findMaximumNum(String str, int k) {
            int n = str.length();
            var pq = new PriorityQueue<Integer>(n, Collections.reverseOrder());
            var strArr = str.toCharArray();
            
            for(int i=0;i<n;i++) {
                pq.add((int)(strArr[i]) - 48);
            }

            util(strArr, 0, k, pq);
    }
    
    private static void util(char[] strArr, int i, int k, PriorityQueue<Integer> pq) {
        if(k == 0)
            return;
        int n = strArr.length;

        int temp = pq.poll();
        if(temp != (strArr[i]-48)) {
            for(int j=i+1;j<n;j++) {
                if((strArr[j]-48) == temp) {
                    swap(strArr, i, j);
                    if(Arrays.compare(strArr, res) > 0) {
                        res = Arrays.copyOf(strArr, strArr.length);
                    }
                    util(strArr, i+1, k-1, pq);
                    swap(strArr, i, j);
                }
            }
        } else {
            util(strArr, i+1, k, pq);
        }
        pq.add(temp);
        return;
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}