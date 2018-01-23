package com.study.partitionArray;

public class Solution
{
    /*
     * 描述：数组划分，使用 O(n) 的时间复杂度在数组上进行划分。
     * 
     * 思路：用快速排序，一次遍历，将数组以k分成两个部分
     * 
     * @param nums: The integer array you should partition
     * 
     * @param k: An integer
     * 
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k)
    {
        // write your code here
        int i = 0, j = nums.length - 1, num;
        while (i <= j)
        {
            if (nums[i] >= k && nums[j] < k)
            {
                num = nums[i];
                nums[i] = nums[j];
                nums[j] = num;
                i++;
                j--;
            }
            else if (nums[j] >= k)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.partitionArray(new int[] {}, 9));
    }

}
