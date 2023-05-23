import java.util.ArrayDeque;
import java.util.Scanner;

public class EvaluateInfix {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        var str = sc.nextLine();
        System.out.println(evaluateInfix(str));
        sc.close();
    }

    private static int evaluateInfix(String str) {
        var nStack = new ArrayDeque<Integer>();
        var oStack = new ArrayDeque<Character>();
        
        int ele1, ele2;
        char op;
        char[] arr = str.toCharArray();
        for (var item : arr) {
            if(item == ' ') continue;
            else if(item == '+' || item == '-' || item == '*' || item == '/' || item == '^') {
                if(item == '(') 
                    oStack.push(item);
                else if(item == ')') {
                    while (!oStack.isEmpty() && oStack.peek() != '(') {
                        ele1 = nStack.pop();
                        ele2 = nStack.pop();
                        op = oStack.pop();

                        switch (op) {
                            case '+': {
                                nStack.push((ele1+ele2));
                                break;
                            }
                            case '-' : {
                                nStack.push(ele2-ele1);
                                break;
                            }
                            case '*' : {
                                nStack.push(ele1*ele2);
                                break;
                            }    
                            case '/' : {
                                nStack.push(ele2/ele1);
                                break;
                            }
                            case '^' : {
                                nStack.push((int)Math.pow(ele2, ele1));
                                break;
                            }
                            default:
                                break;
                        }
                    }
                    if(!oStack.isEmpty())
                        oStack.pop();
                } else if(item == '^') {
                    oStack.push(item);
                } else if(item == '+' || item == '-') {
                    while (!oStack.isEmpty() && oStack.peek() != '(') {
                        ele1 = nStack.pop();
                        ele2 = nStack.pop();
                        op = oStack.pop();

                        switch (op) {
                            case '+': {
                                nStack.push((ele1+ele2));
                                break;
                            }
                            case '-' : {
                                nStack.push(ele2-ele1);
                                break;
                            }
                            case '*' : {
                                nStack.push(ele1*ele2);
                                break;
                            }    
                            case '/' : {
                                nStack.push(ele2/ele1);
                                break;
                            }
                            case '^' : {
                                nStack.push((int)Math.pow(ele2, ele1));
                                break;
                            }
                            default:
                                break;
                        }
                    }
                    oStack.push(item);
                } else if(item == '*' || item == '/') {
                    while (!oStack.isEmpty() && oStack.peek() != '(' && oStack.peek() != '+' && oStack.peek() != '-') {
                        ele1 = nStack.pop();
                        ele2 = nStack.pop();
                        op = oStack.pop();

                        switch (op) {
                            case '*' : {
                                nStack.push(ele1*ele2);
                                break;
                            }    
                            case '/' : {
                                nStack.push(ele2/ele1);
                                break;
                            }
                            case '^' : {
                                nStack.push((int)Math.pow(ele2, ele1));
                                break;
                            }
                            default:
                                break;
                        }
                    }
                    oStack.push(item);
                }
            } else
                nStack.push(item - 48);
        }

        while (!oStack.isEmpty()) {
            ele1 = nStack.pop();
            ele2 = nStack.pop();
            op = oStack.pop();

            switch (op) {
                case '+': {
                    nStack.push((ele1+ele2));
                    break;
                }
                case '-' : {
                    nStack.push(ele2-ele1);
                    break;
                }
                case '*' : {
                    nStack.push(ele1*ele2);
                    break;
                }    
                case '/' : {
                    nStack.push(ele2/ele1);
                    break;
                }
                case '^' : {
                    nStack.push((int)Math.pow(ele2, ele1));
                    break;
                }
                default:
                    break;
            }
        }
        return nStack.pop();
    }
}