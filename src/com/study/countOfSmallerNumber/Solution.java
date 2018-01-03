package com.study.countOfSmallerNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    /**
     * 给定一个整数数组 （下标由 0 到 n-1，其中 n 表示数组的规模，数值范围由 0 到 10000），以及一个
     * 查询列表。对于每一个查询，将会给你一个整数，请你返回该数组中小于给定整数的元素的数量。
     * 
     * @param A
     * @param queries
     * @return
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries)
    {
        // 对A数组排序
        Arrays.sort(A);

        // 定义一个集合，存储结果集
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++)
        {
            int len = 0;
            for (int j = 0; j < A.length; j++)
            {
                if (A[j] < queries[i])
                {
                    len++;
                }
                else
                {
                    break;
                }
            }
            list.add(len);
        }
        return list;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] A = { 1, 2, 7, 8, 5 };
        int[] queries = { 1, 8, 5 };

        System.out.println(s.countOfSmallerNumber(A, queries));
    }

}
