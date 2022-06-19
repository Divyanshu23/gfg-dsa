import java.util.Arrays;
import java.util.Scanner;

public class MergeOveralappingIntervals {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(sc.nextInt(), sc.nextInt());
        }
        int end = mergeOveralappingIntervals(arr);
        for (int i = 0; i <= end; i++) {
            System.out.println(arr[i].getStart() + " " + arr[i].getEnd());
        }
        System.out.println();
        sc.close();
    }

    public static int mergeOveralappingIntervals(Interval[] arr) {
        Arrays.sort(arr);

        int currPos = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].getStart() <= arr[currPos].getEnd()) {
                arr[currPos].setEnd(arr[i].getEnd());
            } else {
                currPos++;
                arr[currPos] = arr[i];
            }
        }

        return currPos;
    }
}

class Interval implements Comparable<Interval> {
    private int start,end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {return start;}

    public int getEnd() {return end;}

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Interval obj) {
        return this.start - obj.start;
    }
}