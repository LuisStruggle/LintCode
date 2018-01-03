package com.study.searchInsert;

public class Solution
{

    /**
     * param A : an integer sorted array
     * param target : an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target)
    {
        // write your code here

        int index = -1;

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] == target)
            {
                index = i;
                break;
            }
            else
            {
                if (A[i] > target)
                {
                    index = i;
                    break;
                }
                else
                {
                    index = i + 1;
                }
            }
        }

        return index;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Solution solution = new Solution();

        int[] A = { 1, 3, 5, 6 };
        int index = solution.searchInsert(A, 7);

        System.out.println(index);
    }

}
