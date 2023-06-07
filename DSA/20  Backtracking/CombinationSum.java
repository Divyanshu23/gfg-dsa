import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CombinationSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        var res = combinationSum(arr, sum);
        for (var list : res) {
            for (var item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        Collections.sort(arr);
        var arr2 = new ArrayList<Integer>();
        arr2.add(arr.get(0));
        int curr = arr.get(0);
        for(int i=1;i<arr.size();i++) {
            if(arr.get(i) == curr)
                continue;
            else {
                arr2.add(arr.get(i));
                curr = arr.get(i);
            }
        }
        return solve(arr2, sum, 0);
    }
    
    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> arr, int sum, int s) {
        if(sum == 0)
            return new ArrayList<ArrayList<Integer> >();
            
        if(s == arr.size())
            return new ArrayList<ArrayList<Integer> >();
            
        var res1 = solve(arr,sum,s+1);
        
        int curr = arr.get(s);
        var ans = new ArrayList<ArrayList<Integer> >();
        while(curr <= sum) {
            var res = solve(arr,sum-curr,s+1);
            int count = curr/(arr.get(s));

            if(res.size() != 0) {
                var list = new ArrayList<Integer>(Collections.nCopies(count, arr.get(s)));
                for(var array:res) {
                    array.addAll(0,list);
                }
            } else if(curr == sum) {
                var list = new ArrayList<Integer>(Collections.nCopies(count, arr.get(s)));
                res.add(list);
            }
            
            ans.addAll(0, res);
            curr += arr.get(s);
        }
        
        ans.addAll(res1);
        return ans;
    }
}
