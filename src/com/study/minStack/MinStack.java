package com.study.minStack;

import java.util.Stack;

public class MinStack
{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack()
    {
        // do intialization if necessary
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * 
     * @return: nothing
     */
    public void push(int number)
    {
        // write your code here
        if (this.minStack.isEmpty())
        {
            this.minStack.push(number);
        }
        else if (this.minStack.peek() > number)
        {
            this.minStack.push(number);
        }
        else
        {
            this.minStack.push(this.minStack.peek());
        }
        this.stack.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop()
    {
        // write your code here
        if (this.stack.isEmpty())
        {
            throw new RuntimeException("stack is empty!");
        }
        else
        {
            this.minStack.pop();
            return this.stack.pop();
        }
    }

    /*
     * @return: An integer
     */
    public int min()
    {
        // write your code here
        if (this.minStack.isEmpty())
        {
            throw new RuntimeException("minStack is empty!");
        }
        else
        {
            return this.minStack.peek();
        }
    }
}
