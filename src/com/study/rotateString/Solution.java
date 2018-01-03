package com.study.rotateString;

public class Solution
{
    /*
     * 描述：给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
     * 
     * @param str: An array of char
     * 
     * @param offset: An integer
     * 
     * @return: nothing
     */
    public void rotateString(char[] str, int offset)
    {
        // write your code here
        int length = str.length, i = length - 1;
        if (offset >= length)
        {
            offset = offset - length;
        }
        char zf;
        int end = offset;
        boolean flag = false;
        while (offset > 0)
        {
            if (i + offset >= length)
            {
                zf = str[i + offset - length];
                str[i + offset - length] = str[i];
            }
            else
            {
                zf = str[i + offset];
                str[i + offset] = str[i];
            }
            str[i] = zf;
            i--;
            if (flag || (offset - 1) >= i)
            {
                i = end;
                offset--;
                flag = true;
            }
        }
        // aaccbb baccab bacbac baabcc
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
        new Solution().rotateString(str, 4);
    }
}
