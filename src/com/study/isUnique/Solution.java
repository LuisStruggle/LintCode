package com.study.isUnique;

public class Solution
{

    /*
     * 描述：实现一个算法确定字符串中的字符是否均唯一出现
     * 
     * @param str: A string
     * 
     * @return: a boolean
     */
    public boolean isUnique(String str)
    {
        // write your code here
        for (int i = 0; i < str.length(); i++)
        {
            if (i == str.indexOf(str.charAt(i)))
            {
                if (str.indexOf(str.charAt(i), i + 1) != -1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        boolean flag = new Solution().isUnique("ab");
        String str = "abc";
        System.out.println(flag);
    }

}
