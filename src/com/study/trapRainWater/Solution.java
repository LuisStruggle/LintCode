package com.study.trapRainWater;

public class Solution
{
    /**
     * 给出 n 个非负整数，代表一张X轴上每个区域宽度为 1 的海拔图, 计算这个海拔图最多能接住多少（面积）雨水。
     * 
     * @param heights
     * @return
     */
    public int trapRainWater(int[] heights)
    {
        if (heights.length == 0)
        {
            return 0;
        }

        // 定义雨水记数器
        int count = 0;

        // 记录起始位置
        int start = 0, end = heights.length - 1;

        // 记录起始位置峰值
        int high1 = heights[start], high2 = heights[end];
        while (start <= end)
        {
            if (high1 > high2)
            {
                if (high2 <= heights[end])
                {
                    high2 = heights[end];
                }
                else
                {
                    count += high2 - heights[end];
                }
                end--;
            }
            else if (high1 <= high2)
            {
                if (high1 <= heights[start])
                {
                    high1 = heights[start];
                }
                else
                {
                    count += high1 - heights[start];
                }
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(s.trapRainWater(heights));
    }

}
