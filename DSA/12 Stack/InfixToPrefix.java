import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPrefix {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        var str = sc.nextLine();
        System.out.println(str);
        convertToPreFix(str);
        sc.close();
    }

    private static void convertToPreFix(String str) {
        var s = new ArrayDeque<Character>();
        var res = new StringBuilder();
        char[] arr = str.toCharArray();

        for (int i=arr.length-1;i>=0;i--) {
            if(arr[i] == ')') {
                s.push(arr[i]);
            } else if(arr[i] == '(') {
                while(!s.isEmpty() && s.peek() != ')') {
                    res.append(s.pop());
                }
                if(!s.isEmpty()) s.pop();
            } else if(arr[i] == '^') {
                while (!s.isEmpty() && s.peek() == '^') {
                    res.append(s.pop());
                }
                s.push(arr[i]);
            } else if(arr[i] == '+' || arr[i] == '-') {
                while(!s.isEmpty() && s.peek() != ')' && s.peek() != '+' && s.peek() != '-') {
                    res.append(s.pop());
                }
                s.push(arr[i]);
            } else if(arr[i] == '*' || arr[i] == '/') {
                while (!s.isEmpty() && s.peek() != ')' && s.peek() != '+' && s.peek() != '-' && s.peek() == '*' && s.peek() == '/') {
                    res.append(s.pop());
                }
                s.push(arr[i]);
            } else {
                res.append(arr[i]);
            }
        }

        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        for (int i = res.length()-1; i >= 0; i--) {
            System.out.print(res.charAt(i));
        }
    }
}
