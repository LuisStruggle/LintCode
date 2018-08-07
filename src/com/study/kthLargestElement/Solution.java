package com.study.kthLargestElement;

public class Solution
{
    /*
     * @param k : description of k
     * 
     * @param nums : array of nums
     * 
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums)
    {
        // write your code here
        int len = nums.length;
        return quickSort(len, k, 0, len - 1, nums);
    }

    private int quickSort(int len, int k, int start, int end, int[] nums)
    {
        int i = start, j = end;
        int num = nums[i];
        boolean flag = true;
        i++;
        while (i <= j)
        {
            if (flag)
            {
                if (nums[j] < num)
                {
                    nums[i - 1] = nums[j];
                    j--;
                    flag = false;
                }
                else
                {
                    j--;
                }
            }
            else
            {
                if (nums[i] > num)
                {
                    nums[j + 1] = nums[i];
                    i++;
                    flag = true;
                }
                else
                {
                    i++;
                }
            }
        }
        if (flag)
        {
            if (len - j > k)
            {
                num = quickSort(len, k, j + 1, end, nums);
            }
            else if (len - j < k)
            {
                num = quickSort(len, k, start, j - 1, nums);
            }
        }
        else
        {
            if (len - i > k)
            {
                num = quickSort(len, k, i + 1, end, nums);
            }
            else if (len - i < k)
            {
                num = quickSort(len, k, start, i - 1, nums);
            }
        }
        return num;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        int nums[] = { 9, 3, 2, 4, 8 };
        System.out.println(s.kthLargestElement(3, nums));
    }

}
