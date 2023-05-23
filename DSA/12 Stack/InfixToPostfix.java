import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        var str = sc.nextLine();
        System.out.println(str);
        convertToPostFix(str);
        sc.close();
    }

    private static void convertToPostFix(String str) {
        var s = new ArrayDeque<Character>();
        char[] arr = str.toCharArray();

        for (var item : arr) {
            if(item == '(') {
                s.push(item);
            } else if(item == ')') {
                while(!s.isEmpty() && s.peek() != '(') {
                    System.out.print(s.pop());
                }
                if(!s.isEmpty()) s.pop();
            } else if(item == '^') {
                s.push(item);
            } else if(item == '+' || item == '-') {
                while(!s.isEmpty() && (s.peek() != '(')) {
                    System.out.print(s.pop());
                }
                s.push(item);
            } else if(item == '*' || item == '/') {
                while (!s.isEmpty() && (s.peek() != '+' && s.peek() != '-' && s.peek() != '(')) {
                    System.out.print(s.pop());
                }
                s.push(item);
            } else {
                System.out.print(item);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }   
}
