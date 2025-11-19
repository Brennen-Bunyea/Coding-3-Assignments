import java.util.*;

public class Main
{
    private static int precedence(char op)
    {
        if(op == '^')
        {
            return 3;
        }

        if(op == '*' || op == '/')
        {
            return 2;
        }

        if(op == '+' || op == '-')
        {
            return 1;
        }

        return -1;
    }

    private static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
        {
            return true;
        }

        return false;
    }

    private static boolean validateTheExpression(String expression)
    {
        Stack<Character> stack = new Stack<>();
        char prev = ' ';

        char[] arr = expression.toCharArray();
        int i = 0;

        while(i < arr.length)
        {
            char c = arr[i];

            if(c == '(')
            {
                stack.push(c);
            }
            else if(c == ')')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                stack.pop();
            }

            if(!Character.isDigit(c) && !isOperator(c) && c != '(' && c != ')' && c != ' ')
            {
                return false;
            }

            if(isOperator(c) && isOperator(prev))
            {
                return false;
            }

            prev = c;
            i++;
        }

        if(!stack.isEmpty())
        {
            return false;
        }

        return true;
    }

    public static String postFix(String expression)
    {
        if(!validateTheExpression(expression))
        {
            return "ERROR";
        }

        Stack<Character> operators = new Stack<>();
        StringBuilder output = new StringBuilder();

        char[] tokens = expression.toCharArray();
        int i = 0;

        while(i < tokens.length)
        {
            char c = tokens[i];

            if(c == ' ')
            {
                i++;
                continue;
            }

            if(Character.isDigit(c))
            {
                while(i < tokens.length &&
                        (Character.isDigit(tokens[i]) || tokens[i] == '.'))
                {
                    output.append(tokens[i]);
                    i++;
                }
                output.append(" ");
                continue;
            }

            if(c == '(')
            {
                operators.push(c);
            }
            else if(c == ')')
            {
                while(!operators.isEmpty() && operators.peek() != '(')
                {
                    output.append(operators.pop());
                    output.append(" ");
                }

                operators.pop();
            }
            else if(isOperator(c))
            {
                while(!operators.isEmpty() &&
                        precedence(operators.peek()) >= precedence(c))
                {
                    if(c == '^' && operators.peek() == '^')
                    {
                        break;
                    }

                    output.append(operators.pop());
                    output.append(" ");
                }

                operators.push(c);
            }

            i++;
        }

        while(!operators.isEmpty())
        {
            output.append(operators.pop());
            output.append(" ");
        }

        return output.toString().trim();
    }

    public static double postFixEvaluate(String postfix)
    {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        int i = 0;
        while(i < tokens.length)
        {
            String token = tokens[i];

            if(token.length() == 0)
            {
                i++;
                continue;
            }

            if(token.matches("[-]?[0-9]*\\.?[0-9]+"))
            {
                double num = Double.parseDouble(token);
                stack.push(num);
            }
            else if(token.length() == 1 && isOperator(token.charAt(0)))
            {
                double b = stack.pop();
                double a = stack.pop();
                char op = token.charAt(0);
                double result = 0;

                if(op == '+')
                {
                    result = a + b;
                }
                else if(op == '-')
                {
                    result = a - b;
                }
                else if(op == '*')
                {
                    result = a * b;
                }
                else if(op == '/')
                {
                    result = a / b;
                }
                else if(op == '^')
                {
                    result = Math.pow(a, b);
                }

                stack.push(result);
            }

            i++;
        }

        return stack.pop();
    }


    public static void main(String[] args)
    {
        String expr1 = "(3 + 4) * 2 / (1 - 5)";
        System.out.println("Input: " + expr1);

        String postfix1 = postFix(expr1);
        System.out.println("Postfix: " + postfix1);

        if(!postfix1.equals("ERROR"))
        {
            System.out.println("Result: " + postFixEvaluate(postfix1));
        }
        System.out.println();


        String expr2 = "5 + ((1 + 2) * 4) - 3";
        System.out.println("Input: " + expr2);

        String postfix2 = postFix(expr2);
        System.out.println("Postfix: " + postfix2);

        if(!postfix2.equals("ERROR"))
        {
            System.out.println("Result: " + postFixEvaluate(postfix2));
        }
        System.out.println();


        String expr3 = "2 ^ 3 ^ 2";
        System.out.println("Input: " + expr3);

        String postfix3 = postFix(expr3);
        System.out.println("Postfix: " + postfix3);

        if(!postfix3.equals("ERROR"))
        {
            System.out.println("Result: " + postFixEvaluate(postfix3));
        }
        System.out.println();
    }
}
