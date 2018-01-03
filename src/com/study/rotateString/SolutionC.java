package com.study.rotateString;

public class SolutionC
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
        if (offset >= length)
        {
            offset = offset - length;
        }
        int j = offset;
        char zf = str[j];
        boolean flag = false;
        for (int i = 0; j > 0 && i < length; i++)
        {
            offset += j;
            if (offset >= length)
            {
                offset -= length;
                if (offset == 0 && flag)
                {
                    offset++;
                    j++;
                    flag = false;
                }
                else if (offset == 0)
                {
                    flag = true;
                }
            }
            str[j] = str[offset];
            str[offset] = zf;
            zf = str[j];
        }
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        char[] str = { 'a', 'b', 'c', 'c', 'b', 'a' };
        new SolutionC().rotateString(str, 3);
    }
}
