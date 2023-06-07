import java.util.Scanner;

public class AllocateMinPages {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(allocate(k, arr));
        sc.close();
    }

    private static int allocate(int k, int[] arr) {
        int n = arr.length;
        var dp = new int[k+1][n+1];

        int sum = 0;
        for(int i=1;i<=n;i++) {
            sum += arr[i-1];
            dp[1][i]=sum;
        }
        for(int i=1;i<=k;i++)
            dp[i][1]=arr[0];
            
        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                int res=Integer.MAX_VALUE;
                sum = 0;
                for(int p=j-1;p>=1;p--){
                    sum+=arr[p];
                    res=Math.min(res,Math.max(dp[i-1][p],sum));
                }
                dp[i][j]=res;
            }
        }
        return dp[k][n];
    }
}
