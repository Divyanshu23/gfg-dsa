import java.util.ArrayDeque;
import java.util.Scanner;

public class EvaluatePostfix {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        var str = sc.nextLine();
        System.out.println(str);
        System.out.println(evaluatePostfix(str));
        sc.close();
    }

    private static int evaluatePostfix(String str) {
        var s = new ArrayDeque<Integer>();

        char[] arr = str.toCharArray();
        int ele1, ele2;

        for (var item : arr) {
            if(item == ' ') continue;
            else if(item == '+' || item == '-' || item == '*' || item == '/' || item == '^') {
                ele1 = s.pop();
                ele2 = s.pop();

                switch (item) {
                    case '+': {
                        s.push(ele1+ele2);
                        break;
                    }
                    case '-' : {
                        s.push(ele2-ele1);
                        break;
                    }
                    case '*' : {
                        s.push(ele1*ele2);
                        break;
                    }    
                    case '/' : {
                        s.push(ele2/ele1);
                        break;
                    }
                    case '^' : {
                        s.push((int)Math.pow(ele2, ele1));
                        break;
                    }
                    default:
                        break;
                }
            } else s.push(item - 48);
        }

        return s.pop();
    }
}
