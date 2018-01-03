package com.study.binarySearch;

public class Solution
{

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target)
    {
        int low = 0;
        int height = nums.length - 1;

        int index = -1;

        int saveMiddle = -1;

        while (low <= height)
        {
            int middle = (low + height) / 2;
            if (saveMiddle != middle)
            {
                if (target == nums[middle])
                {
                    if (index == -1)
                    {
                        index = middle;
                    }
                    else
                    {
                        if (index > middle)
                        {
                            index = middle;
                        }
                    }
                    height = middle - 1;
                }
                else if (target < nums[middle])
                {
                    height = middle - 1;
                }
                else
                {
                    low = middle + 1;
                }
            }
            else
            {
                break;
            }
            saveMiddle = middle;
        }

        return index;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[] nums = { 1, 2, 3, 3, 4, 5, 10 };

        int index = solution.binarySearch(nums, 3);

        System.out.println(index);
    }

}
