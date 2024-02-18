package Tawheed2024.Blind75;

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return !s2.isEmpty() ? s2.pop() : 1;
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
            int peek = !s2.isEmpty() ? s2.pop() : 1;
            s2.push(peek);
            return peek;
    }
    
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty()) ? true : false;
 
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        System.out.println(m.peek());
        System.out.println(m.pop());
        System.out.println(m.peek());
        System.out.println(m.pop());
        System.out.println(m.empty());
    }
}