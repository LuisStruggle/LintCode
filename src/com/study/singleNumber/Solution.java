package com.study.singleNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(new Solution().singleNumber(new int[] { 1, 2, 2, 1, 3, 4, 3 }));
    }

    /**
     * 描述：给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
     * 
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A)
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++)
        {
            if (list.contains(A[i]))
            {
                list.remove(list.indexOf(A[i]));
            }
            else
            {
                list.add(A[i]);
            }
        }
        return list.get(0);
    }
}
