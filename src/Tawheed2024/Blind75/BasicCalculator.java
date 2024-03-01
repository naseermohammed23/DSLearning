package Tawheed2024.Blind75;

import java.util.Stack;


//https://leetcode.com/problems/basic-calculator/description/
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("1-(     -2)"));
    }
    
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int operand = 0; 
        int prevSign = 1;
        
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                operand = 10 * operand + Character.getNumericValue(ch);
            } else if (ch == '+') {
                result += prevSign * operand;
                prevSign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += prevSign * operand;
                prevSign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(prevSign);
                prevSign = 1;
                result = 0;           
            } else if (ch == ')') {
                result += prevSign * operand;
                result *= stack.pop();
                result += stack.pop();
                //result += prevExpSign * prevExpResult;
                operand = 0;
            }
        }

        return result + (prevSign * operand);
    }
}
