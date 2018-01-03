package com.study.arithmetic.wangyi;

import java.util.Scanner;

public class Solution
{
    /**
     * 有六种字符，‘(’，‘)’，‘[’，‘]’，‘{’，‘}’，看是否满足对称。即：'()[{}]()[]'满足，而'()[{]}'不满足
     */
    public static void main(String[] args)
    {
        // 获取输入的字符串
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 定义一个标识判断标识
        boolean flag = false;

        // 判断是否只包含上述6中字符，并且字符是否为偶数个或则字符长度为0
        if (!str.matches("^[\\[|\\]|\\(|\\)|\\{|\\}]*$") || ((str.length()) % 2) != 0 || (str.length()) == 0)
        {
            System.out.println(flag);
        }
        else
        {
            // 将六种字符转为相应的数字，方便匹配
            char[] ch = str.toCharArray();

            // 索引开始位置
            int start = 0;
            // 索引结束位置
            int end = 1;
            // 最大索引
            int indexMax = 1;

            flag = isMatch(ch, start, end, indexMax);

        }
    }

    private static boolean isMatch(char[] ch, int start, int end, int indexMax)
    {
        // 定义一个标识判断标识
        boolean flag = false;
        // 计数器
        int i = 0;

        while (indexMax < ch.length)
        {
            if (ch[end] == ch[start])
            {
                i++;
            }
            else
            {
                if ((ch[start] == '(' && ch[end] == ')') || (ch[start] == '[' && ch[end] == ']')
                        || (ch[start] == '{' && ch[end] == '}'))
                {
                    if (i == 0)
                    {
                        if ((start - end - 1) % 2 == 0)
                        {
                            if (start - end == 1)
                            {
                                start = indexMax + 1;
                                end = indexMax + 2;
                                indexMax = end;
                                flag = true;
                            }
                            else
                            {
                                // 递归（满足匹配返回true，否则false）
                                flag = isMatch(ch, start + 1, start + 2, indexMax);
                            }
                        }
                        else
                        {
                            flag = false;
                            break;
                        }
                    }
                    else
                    {
                        i--;
                    }
                }
            }
            end++;
            if (indexMax < end)
            {
                indexMax = end;
            }
        }
        return flag;
    }
}