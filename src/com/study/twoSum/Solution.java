package com.study.twoSum;


public class Solution
{

    public int[] twoSum(int[] numbers, int target)
    {
        /**
         * 给一个整数数组，找到两个数使得他们的和等于一个给定的数target。你需要实现的函数twoSum需要返回这两个数的下标,
         * 并且第一个下标小于第二个下标。注意这里下标的范围是1到n，不是以0开头。
         */

        // 定义一个数组，用于保存结果集
        int[] num = new int[2];

        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if (target == numbers[i] + numbers[j])
                {
                    num[0] = i + 1;
                    num[1] = j + 1;
                    return num;
                }
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        // test
        int[] numbers = { 1, 0, -1 };

        System.out.println(s.twoSum(numbers, -1));

    }

}
