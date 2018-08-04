package com.study.minSubArray;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    /*
     * @param nums: a list of integers
     * 
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums)
    {
        // 由当前局部最小和上一次局部最小决定。是一个动态规划的问题
        int sum = 0, minSum = nums.get(0);

        for (int i = 0; i < nums.size(); i++)
        {
            sum += nums.get(i);

            if (sum <= minSum)
            {
                minSum = sum;
            }

            if (sum > 0)
            {
                sum = 0;
            }
        }

        return minSum;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        List<Integer> nums = new ArrayList<Integer>();
        // 101,33,44,55,67,78,100,200,1000,22
        nums.add(101);
        nums.add(33);
        nums.add(44);
        nums.add(55);
        nums.add(67);
        nums.add(78);
        nums.add(100);
        nums.add(200);
        nums.add(1000);
        nums.add(22);

        Solution s = new Solution();
        System.out.println(s.minSubArray(nums));
    }
}
