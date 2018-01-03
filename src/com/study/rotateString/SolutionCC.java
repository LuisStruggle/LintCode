package com.study.rotateString;

public class SolutionCC
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
        int length = str.length;
        if (length > 0)
        {
            offset = offset % length;
        }
        if (offset > 0 && length > 0)
        {
            char zf1 = str[0], zf2;
            int wz = 0, i = 0;
            while (i < length)
            {
                wz = wz + offset;
                if ((i * offset) % length == 0)
                {
                    wz++;
                    if (wz >= length)
                    {
                        zf1 = str[wz % length];
                    }
                    else
                    {
                        zf1 = str[wz];
                    }
                    wz = wz + offset;
                }

                if (wz >= length)
                {
                    wz = wz % length;
                }

                zf2 = str[wz];
                str[wz] = zf1;
                zf1 = zf2;
                i++;
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' };
        // char[] str = { 'a', 'b', 'c', 'c', 'b', 'a' };
        // char[] str = { 'c', 'p', 'p', 'j', 'a', 'v', 'a', 'p', 'y' };
        // char[] str = { 'u', 'b', 'u', 'n', 't', 'u' };
        // char[] str = { 't', 'i', 'm', 'e', 'l', 'i', 'm', 'i', 't', 'e', 'r',
        // 'r', 'o', 'r' };
        // new SolutionCC().rotateString(str, 1000000000);
        new SolutionCC().rotateString(str, 11);
    }
}
