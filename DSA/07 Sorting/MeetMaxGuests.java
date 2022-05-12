import java.util.Arrays;
import java.util.Scanner;

public class MeetMaxGuests {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var L = new int[n];
        var R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();
        }
        ReturnObject obj = meetMaxGuests(L,R);
        System.out.println("Max Guests: " + obj.getMaxGuests());
        System.out.println("Arrive at " + obj.getStart() + " and leave at " + obj.getEnd() );
        sc.close();
    }

    public static ReturnObject meetMaxGuests(int[] L, int[] R) {
        Arrays.sort(L);
        Arrays.sort(R);

        int i = 0, j =0, n = L.length, count = 0;
        int maxGuests = Integer.MIN_VALUE;
        int arrival = 0, departure = 0;
        boolean flag = false;

        while (i < n) {
            if(L[i] <= R[j]) {
                ++count;
                if(count > maxGuests) {
                     maxGuests = count;
                     arrival = i;
                     flag = true;
                }
                ++i;
            } else {
                if(flag) {
                    departure = j;
                    flag = false;
                }
                count--;
                ++j;
            }
        }
        if(flag) {
            departure = j;
        }
        var obj = new ReturnObject();
        obj.setMaxGuests(maxGuests);
        obj.setStart(L[arrival]);
        obj.setEnd(R[departure]);
        return obj;
    }
}

class ReturnObject {
    private int start, end, maxGuests;

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public int getStart() { return start;}

    public int getEnd() { return end;}

    public int getMaxGuests() { return maxGuests;}
}