import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main (String[] args) {
        ArrayList<ArrayList<Integer> > arr=new ArrayList<ArrayList<Integer>>();
	
        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
        a1.add(10); 
        a1.add(20);
        a1.add(30);
        arr.add(a1); 
  
        ArrayList<Integer> a2 = new ArrayList<Integer>(); 
        a2.add(5);
        a2.add(15);
        arr.add(a2); 
  
        ArrayList<Integer> a3 = new ArrayList<Integer>(); 
        a3.add(1); 
        a3.add(9); 
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        
        ArrayList<Integer> res = mergeKSortedArrays(arr);
        for (var item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr) {
        var pq = new PriorityQueue<Triplet>();
        var res = new ArrayList<Integer>();

        for(int i=0;i<arr.size();i++) {
            pq.add(new Triplet(arr.get(i).get(0), i, 0));
        }

        Triplet temp = null;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            res.add(temp.val);
            if((temp.j)+1 < arr.get(temp.i).size()) {
                pq.add(new Triplet(arr.get(temp.i).get(temp.j+1), temp.i, temp.j+1));
            }
        }
        return res;
    }

    private static class Triplet implements Comparable<Triplet> {
        int val;
        int i;
        int j;

        public Triplet(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Triplet t){
            if(val<=t.val)return -1;
            else return 1;
        }
    }
}
