package com.study.threeSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    /**
     * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
     * 
     * @param numbers
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers)
    {
        // 数组排序
        Arrays.sort(numbers);

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                for (int j2 = j + 1; j2 < numbers.length; j2++)
                {
                    int sum = numbers[i] + numbers[j] + numbers[j2];
                    if (sum == 0)
                    {
                        ArrayList<Integer> ali = new ArrayList<Integer>();
                        ali.add(numbers[i]);
                        ali.add(numbers[j]);
                        ali.add(numbers[j2]);
                        if (!al.contains(ali))
                        {
                            al.add(ali);
                        }
                    }
                }
            }
        }

        return al;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] numbers = new int[] { -1, 0, 1, 2, -1, -4 };

        System.out.println(s.threeSum(numbers));
    }

}
