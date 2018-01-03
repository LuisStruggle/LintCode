package com.study.fourSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    /**
     * 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
     * 
     * @param numbers
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target)
    {
        // 对数组排序
        Arrays.sort(numbers);

        // 定义一个数组，用于存储结果集
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                int low = j + 1;
                int high = numbers.length - 1;

                while (low < high)
                {
                    int sum = (numbers[i] + numbers[j] + numbers[low] + numbers[high]);
                    if (sum < target)
                    {
                        low++;
                    }
                    else if (sum > target)
                    {
                        high--;
                    }
                    else
                    {
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(numbers[i]);
                        al.add(numbers[j]);
                        al.add(numbers[low]);
                        al.add(numbers[high]);

                        if (!list.contains(al))
                        {
                            list.add(al);
                        }

                        low++;
                        high--;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] numbers = { 1, 0, -1, 0, -2, 2 };

        System.out.println(s.fourSum(numbers, 0));
    }

}
