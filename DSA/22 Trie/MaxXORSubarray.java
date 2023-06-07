import java.util.Scanner;

public class MaxXORSubarray {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubarrayXOR(arr, n));
        sc.close();
    }

    static int maxSubarrayXOR(int arr[], int n) {
        var root = new TrieNode();
        int res = 0;
        int curr = 0;
        int temp;
        for(int i=0;i<n;i++) {
            curr = curr^arr[i];
            temp = insertAndGetMax(root, curr);
            if(temp > res)
                res = temp;
        }
        
        return res;
    }
    
    static int insertAndGetMax(TrieNode root, int xor) {
        var curr = root;
        var curr2 = root;
        int temp;
        int temp2;
        int res = xor;
        int temp3 = 0;
        for(int i=31;i>=0;i--) {
            temp = 1<<i;
            temp2 = (temp&xor) == temp ? 1:0;
            
            if(curr2.isEnd == false) {
                if(curr2.child[1] != null && curr2.child[0] != null) {
                    if((xor ^ (temp3 | temp)) > (xor ^ temp3)) {
                        temp3 = temp3|temp;
                        curr2 = curr2.child[1];
                    } else {
                        curr2 = curr2.child[0];
                    }
                } else if(curr2.child[1] != null) {
                    temp3 = temp3|temp;
                    curr2 = curr2.child[1];
                } else if(curr2.child[0] != null) {
                    curr2 = curr2.child[0];
                }
            }
            
            if(curr.child[temp2] == null) {
                curr.child[temp2] = new TrieNode();
            }
            curr = curr.child[temp2];
        }
        curr.isEnd = true;
        if((xor ^ temp3) > xor) res = xor^temp3;
        return res;
    }
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        boolean isEnd;
    }
}
