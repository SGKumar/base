package main.java.com.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;
  
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if(minStack.isEmpty() || val < minStack.peek()) {
      minStack.push(val);
    }
  }

  public int pop() {
    int ret = stack.pop();
    if(minStack.peek() > stack.peek()) {
      minStack.pop();
    }
    return ret;
  }

  public int peek() {
    return stack.peek();
  }

  public int min() {
    return minStack.peek();
  }

  public String toString() {
    return stack.toString() + " " + minStack.toString();
  }

  public static void main(String[] args) {
    System.out.println("Hello Coin");
    int[] vals = {12, 11, 10, 9, 8, 6, 16, 5, 4, 10, 7, 2, 3, 1, 15};

    Stack<Integer> nStack = new Stack<>();
    MinStack minStack = new MinStack();
    for(int val : vals) {
      nStack.push(val);
      minStack.push(val);
    }
    System.out.println("Normal stack is: " + nStack.toString());
    System.out.println("Min stack is:    " + minStack.toString());
    /*
    Scanner myObj = new Scanner(System.in);
    boolean loop = true;
    while(loop) {
      System.out.println("Enter operation");
      String op = myObj.nextLine();

      System.out.println("Enter value: ");
      Integer val = Integer.parseInt(myObj.nextLine());

      switch(op) {
        case "push":
          stack.push(val);
          break;

        case "pop":
          System.out.println("Popped: " + stack.pop());
          break;

        case "top":
          System.out.println("Top is: " + stack.top());
          break;

        case "min":
          System.out.println("Min is: " + stack.min());
          break;

        case "print":
          System.out.println("B2T is: " + stack.print());
          break;

        default:
          loop = false;
          break;
      }
    }
    myObj.close();
    */
  }
}
