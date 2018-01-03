package com.study.getInstance;

public class Solution
{
    // 懒汉单例模式
    private static Solution s = null;

    public static Solution getInstance()
    {
        if (s == null)
        {
            s = new Solution();
        }

        return s;
    }

    public static void main(String[] args)
    {
        Solution a = getInstance();
        Solution b = getInstance();
        System.out.println(a.equals(b));
    }

}
