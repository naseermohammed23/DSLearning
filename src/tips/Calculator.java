package tips;

import java.util.Stack;

/**
 * develop calculator with Stack.. 
 * 
 */
public class Calculator {
   
    static char[] getInputArray(String str) {

        char[] array = new char[str.length()];

        for (int i=0;i<str.length();i++) {
            array[i] = str.charAt(i);
        }

        return array;

    }


    public static void main(String[] args) {        
        char[] input = getInputArray("3+4*5/4-2");
        System.out.println("Result " + calc(input));
    } 


    /**
     * Calculator helper method to basic Math operators and not handling parenthesis. 
     * @param str
     * @return
     */
    private static int calc(char[] str) {
       
        Stack<String> stack = new Stack<>();
        int result = -1;
        int prevDigit = -1;
        int i = 0;
        while (i < str.length) {
            char ch = str[i];

            if (prevDigit != -1) {
                String ch1 = stack.pop();
                if ( ch1.equals("*")) {
                    result = prevDigit * Character.getNumericValue(ch);
                    stack.push(String.valueOf(result));
                    prevDigit = -1;
                } else if (ch1.equals("/")) {
                    result = prevDigit / Character.getNumericValue(ch);
                    stack.push(String.valueOf(result));
                    prevDigit = -1;
                } else {
                    ;
                }

            } else {

                if (Character.isDigit(ch)) {
                    stack.push(String.valueOf(ch));
                } else if (ch == '+' || ch == '-') {
                    stack.push(String.valueOf(ch));
                } else {
                    prevDigit = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(ch));
                }
            }

            i++;
            
        }

        // this is to go over the stack and complete the +, - operations. 
        result = 0;
        while(!stack.isEmpty()) {
            String ch = stack.pop();

            if (ch.equals("+")) {
                result = result + Integer.parseInt(stack.pop());
            } else if (ch.equals("-")) {
                result = Integer.parseInt(stack.pop()) - result;
            } else { 
                result = result + Integer.parseInt(ch);
            }
            
        }

        return result;
       
    }


    


}
