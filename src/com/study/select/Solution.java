package com.study.select;

import java.util.Arrays;

public class Solution
{
    public int[] select(int[] nums)
    {

        // 数组排序
        Arrays.sort(nums);

        int[] num = new int[nums.length / 2];

        if ((nums.length % 2) != 0 || (nums.length) == 0)
        {
            return num;
        }

        int sum1 = 0;
        int sum2 = 0;

        int num1 = 0;
        int num2 = 0;

        int j = 0;

        for (int i = 0; i < (nums.length) - 1; i++)
        {
            num1 = Math.abs((sum1 + nums[i]) - (sum2 + nums[i + 1]));
            num2 = Math.abs((sum2 + nums[i]) - (sum1 + nums[i + 1]));
            if (num1 >= num2)
            {
                sum1 += nums[i + 1];
                sum2 += nums[i];
                num[j] = nums[i + 1];
            }
            else
            {
                sum1 = nums[i];
                sum2 = nums[i + 1];
                num[j] = nums[i];
            }
            i++;
            j++;
        }

        return num;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[] num = { 2, 4, 6, 8 };

        System.out.println(solution.select(num));
    }

}
