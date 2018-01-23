package com.study.digitCounts;

public class Solution
{
    /*
     * @param : An integer
     * 
     * @param : An integer
     * 
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n)
    {
        int counts = 0, digit = 0;
        for (int i = 0; i <= n; i++)
        {
            digit = i;
            do
            {
                if (digit % 10 == k)
                {
                    counts++;
                }
                digit /= 10;
            } while (digit != 0);
        }
        return counts;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(new Solution().digitCounts(1, 12));
    }

}
