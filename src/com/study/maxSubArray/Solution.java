package com.study.maxSubArray;

public class Solution
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] nums = { -2, 2, -3, 4, -1, 2, 1, -5, 3 };
        System.out.println(new Solution().maxSubArray(nums));
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray1(int[] nums)
    {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum > maxSum)
                {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 动态规划
     * 核心思想：一旦发现子数组的和为负数，弃置，重新一个新数组。
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums)
    {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (sum > maxSum)
            {
                maxSum = sum;
            }
            else if (sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
}
