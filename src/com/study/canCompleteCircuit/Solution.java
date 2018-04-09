package com.study.canCompleteCircuit;

public class Solution
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(new Solution().canCompleteCircuit(new int[] { 1, 1, 3, 1 }, new int[] { 2, 2, 1, 1 }));
    }

    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        // 用贪心算法，找到一个满足的，一次查看后面的是否满足，后面不满足，则放弃，重新开始找满足的。当找完一圈任然没有满足的就说明没有满足要求的路径。
        return 0;
    }

}
