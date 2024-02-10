package Tawheed2024.Blind75;

import java.util.Stack;

public class ValidParenthesis {
    
    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        
        if (s.length() % 2 != 0) return false;

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch: chars) {

            if (ch == '(' || ch =='{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();    
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
