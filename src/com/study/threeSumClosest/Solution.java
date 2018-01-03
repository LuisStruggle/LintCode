package com.study.threeSumClosest;

public class Solution
{
    /**
     * 给一个包含n个整数的数组S, 找到和与给定整数target最接近的三元组，返回这三个数的和。
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int threeSumClosest(int[] numbers, int target)
    {
        // 三元组之和
        int sum = numbers[0] + numbers[1] + numbers[2];

        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                for (int j2 = j + 1; j2 < numbers.length; j2++)
                {
                    int sum1 = numbers[i] + numbers[j] + numbers[j2];
                    if (Math.abs(sum1 - target) <= Math.abs(sum - target))
                    {
                        sum = sum1;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] numbers = { -1, 2, 1, -4 };

        System.out.println(s.threeSumClosest(numbers, 1));
    }

}
