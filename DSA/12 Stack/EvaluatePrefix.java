import java.util.ArrayDeque;
import java.util.Scanner;

public class EvaluatePrefix {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        var str = sc.nextLine();
        System.out.println(str);
        System.out.println(evaluatePrefix(str));
        sc.close();
    }

    private static int evaluatePrefix(String str) {
        var s = new ArrayDeque<Integer>();

        char[] arr = str.toCharArray();
        int ele1, ele2;

        for (int i=arr.length-1;i>=0;i--) {
            if(arr[i] == ' ') continue;
            else if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/' || arr[i] == '^') {
                ele1 = s.pop();
                ele2 = s.pop();

                switch (arr[i]) {
                    case '+': {
                        s.push(ele1+ele2);
                        break;
                    }
                    case '-' : {
                        s.push(ele1-ele2);
                        break;
                    }
                    case '*' : {
                        s.push(ele1*ele2);
                        break;
                    }    
                    case '/' : {
                        s.push(ele1/ele2);
                        break;
                    }
                    case '^' : {
                        s.push((int)Math.pow(ele1, ele2));
                        break;
                    }
                    default:
                        break;
                }
            } else s.push(arr[i] - 48);
        }

        return s.pop();
    }
}