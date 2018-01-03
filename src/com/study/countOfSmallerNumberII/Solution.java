package com.study.countOfSmallerNumberII;

import java.util.ArrayList;

public class Solution
{
    /**
     * 给定一个整数数组（下标由 0 到 n-1， n 表示数组的规模，取值范围由 0 到10000）。对于数组中的每个 ai 元素，请计算 ai
     * 前的数中比它小的元素的数量。
     * 
     * @param A
     * @return
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A)
    {
        // 定义一个数组，用来存储结果集
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++)
        {
            int count = 0;
            for (int j = 0; j < i; j++)
            {
                if (A[j] < A[i])
                {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] A = { 1, 2, 7, 8, 5 };

        System.out.println(s.countOfSmallerNumberII(A));
    }

}
