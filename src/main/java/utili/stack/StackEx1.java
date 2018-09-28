package utili.stack;

import datastructure.Stack;
import datastructure.StackImpl;

public class StackEx1 {
    public static final Stack<String> back = new StackImpl<String>();
    public static final Stack<String> forward = new StackImpl<String>();
    
    public static void main(String[] args) {
        visitWeb("www.naver.com");
        visitWeb("www.nate.com");
        visitWeb("www.daum.com");
        visitWeb("www.yahoo.com");
        printStatus();
        
        goBack();
        printStatus();
    }
    
    public static void visitWeb(String url) {
        back.push(url);
        if(!forward.isEmpty()) {
            forward.clear();
        }
    }
    
    public static void printStatus() {
        System.out.println("back");
        back.print();
        System.out.println("forward");
        forward.print();
        System.out.println("현재화면은 " + back.peek() + " 입니다.");
        System.out.println();
    }
    
    public static void goBack() {
        if(!back.isEmpty())
            forward.push(back.pop());
    }
    
    public static void goForward() {
        if(!forward.isEmpty()) 
            back.push(forward.pop());
    }
    
}
