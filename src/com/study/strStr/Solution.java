package com.study.strStr;

public class Solution
{
    /*
     * @param source: source string to be scanned.
     * 
     * @param target: target string containing the sequence of characters to
     * match
     * 
     * @return: a index to the first occurrence of target in source, or -1 if
     * target is not part of source.
     */
    public int strStr(String source, String target)
    {
        // write your code here
        if (source == null || target == null)
        {
            return -1;
        }
        return source.indexOf(target);
    }

    public static void main(String[] args)
    {
        int i = new Solution().strStr("abcdabcdefg", "bcd");
        System.out.println(i);
    }
}
