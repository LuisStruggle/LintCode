package com.study.isInterleave;

/**
 * 描述：给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * 样例
 * 比如 s1 = "aabcc" s2 = "dbbca"
 * 
 * - 当 s3 = "aadbbcbcac"，返回 true.
 * 
 * - 当 s3 = "aadbbbaccc"， 返回 false.
 * 
 * 思路：循环比对，满足了，就可以选定了，然后从下一个位置继续开始匹配。
 * 
 * @author LiuYang
 * @version
 * @see com.study.isInterleave.MinStack.java
 */
public class Solution
{
    /*
     * @param s1: A string
     * 
     * @param s2: A string
     * 
     * @param s3: A string
     * 
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3)
    {
        // write your code here
        int i = 0, j = 1, o = 0, p = 0;

        int m = s1.length(), n = s2.length(), l = s3.length();

        boolean flag = true, tb = false;

        String str1 = "", str2 = "", str3 = "";
        while (l == m + n && flag && j <= l)
        {
            if (o + j - i > m)
            {
                str1 = "";
            }
            else
            {
                str1 = s1.substring(o, o + j - i);
            }
            if (p + j - i > n)
            {
                str2 = "";
            }
            else
            {
                str2 = s2.substring(p, p + j - i);
            }
            str3 = s3.substring(i, j);

            if (!str3.equals(str1) && !str3.equals(str2))
            {
                if (tb)
                {// 当前一个都匹配，而后一个都不匹配的情况下，要退步，让第一个满足的先匹配。
                    j = j - 1;
                    if (str1 != "")
                    {
                        o += (j - i);
                    }
                    else
                    {
                        p += (j - i);
                    }
                    i = j;
                    j = j + 1;
                    tb = false;
                }
                else
                {
                    flag = false;
                }
            }
            else if (str3.equals(str1) && !str3.equals(str2))
            {
                o += (j - i);
                i = j;
                j = j + 1;
            }
            else if (!str3.equals(str1) && str3.equals(str2))
            {
                p += (j - i);
                i = j;
                j = j + 1;
            }
            else
            {
                j++;
                tb = true;
            }
        }
        if (l != m + n)
        {
            return false;
        }
        return flag;
    }
}
