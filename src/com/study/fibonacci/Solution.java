package com.study.fibonacci;

public class Solution
{

    /*
     * 描述：斐波纳契数列
     * 
     * @param n: an integer
     * 
     * @return: an ineger f(n)
     */
    public int fibonacci(int n)
    {
        int j = 0, k = 1, sum = n == 2 ? k : j;
        // write your code here
        for (int i = 2; i < n; i++)
        {
            sum = j + k;
            j = k;
            k = sum;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.fibonacci(10));
    }

}
