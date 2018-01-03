package com.study.smallestDifference;

import java.util.Arrays;

public class Solution
{
    /**
     * 给定两个整数数组（第一个是数组 A，第二个是数组 B），在数组 A 中取 A[i]，数组 B 中取 B[j]，A[i] 和
     * B[j]两者的差越小越好(|A[i] - B[j]|)。返回最小差。
     * 
     * @param A
     * @param B
     * @return
     */
    public int smallestDifference(int[] A, int[] B)
    {
        // 排序数组
        Arrays.sort(A);
        Arrays.sort(B);

        // 定义最小值
        int smallestDifference = 0;

        if (A.length > B.length)
        {
            smallestDifference = getSmallestDifference(B, A);
        }
        else
        {
            smallestDifference = getSmallestDifference(A, B);
        }

        return smallestDifference;
    }

    public int getSmallestDifference(int[] A, int[] B)
    {
        // 定义最小值
        int smallestDifference = Math.abs(A[0] - B[0]);

        for (int i = 0; i < A.length; i++)
        {
            int low = 0;
            int high = B.length - 1;

            while (low <= high)
            {
                int mid = (low + high) / 2;
                if (Math.abs(A[i] - B[mid]) > Math.abs(A[i] - B[low]))
                {
                    if (smallestDifference > Math.abs(A[i] - B[low]))
                    {
                        smallestDifference = Math.abs(A[i] - B[low]);
                    }
                    high = mid - 1;
                }
                else if (Math.abs(A[i] - B[mid]) > Math.abs(A[i] - B[high]))
                {
                    if (smallestDifference > Math.abs(A[i] - B[high]))
                    {
                        smallestDifference = Math.abs(A[i] - B[high]);
                    }
                    low = mid + 1;
                }
                else
                {
                    if (smallestDifference > Math.abs(A[i] - B[mid]))
                    {
                        smallestDifference = Math.abs(A[i] - B[mid]);
                    }
                    if (mid > 0 && mid < B.length - 2)
                    {
                        if (Math.abs(A[i] - B[mid - 1]) > Math.abs(A[i] - B[mid + 1]))
                        {
                            low = mid + 1;
                        }
                        else
                        {
                            high = mid - 1;
                        }
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return smallestDifference;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] A = { 3, 4, 6, 7 };
        int[] B = { 2, 3, 8, 9 };

        System.out.println(s.smallestDifference(A, B));
    }

}
