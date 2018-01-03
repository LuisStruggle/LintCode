package com.study.myQueue;

import java.util.Stack;

public class MyQueue
{
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public MyQueue()
    {
        // do intialization if necessary
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * 
     * @return: nothing
     */
    public void push(int element)
    {
        // write your code here
        this.stackA.push(element);
        if (this.stackB.isEmpty())
        {
            while (!this.stackA.isEmpty())
            {
                this.stackB.push(this.stackA.pop());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop()
    {
        // write your code here
        this.control();
        return this.stackB.pop();
    }

    /*
     * @return: An integer
     */
    public int top()
    {
        // write your code here
        this.control();
        return this.stackB.peek();
    }

    private void control()
    {
        if (this.stackB.isEmpty() && this.stackA.isEmpty())
        {
            throw new RuntimeException("queue is empty!");
        }
        else if (this.stackB.isEmpty())
        {
            while (!this.stackA.isEmpty())
            {
                this.stackB.push(this.stackA.pop());
            }
        }
    }
}
