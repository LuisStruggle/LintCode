package com.study.ladderLength;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
 * 
 * 比如：
 * 
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。
 * 
 * @author Administrator
 * @version
 * @see com.study.ladderLength.MinStack.java
 */
public class Solution
{
    // 定义一个全局的计数器
    private static int length = 0;

    public int ladderLength(String start, String end, Set<String> dict)
    {
        // start和end先比较，如果符合条件，就不再进行迭代
        int j = 0;
        for (int i = 0; i < start.length(); i++)
        {
            if (start.charAt(i) == end.charAt(i))
            {
                j++;
            }
        }
        if (j == (start.length() - 1))
        {
            length += 2;
        }
        else
        {
            // 记录每一次最合适的dict和它和end相比有多小相同位置的字符
            String suitDict = null;
            int suitLength = 0;

            // 去除重复的
            if (dict.contains(start))
            {
                dict.remove(start);
            }
            if (dict.contains(end))
            {
                dict.remove(end);
            }

            Iterator<String> it = dict.iterator();
            // 判断是否有元素可以迭代
            while (it.hasNext())
            {
                String middle = it.next();

                j = 0;
                for (int i = 0; i < start.length(); i++)
                {
                    if (start.charAt(i) == middle.charAt(i))
                    {
                        j++;
                    }
                }
                if (j == (start.length() - 1))
                {
                    j = 0;
                    for (int i = 0; i < end.length(); i++)
                    {
                        if (end.charAt(i) == middle.charAt(i))
                        {
                            j++;
                        }
                    }

                    if (j >= suitLength)
                    {
                        suitLength = j;
                        suitDict = middle;
                    }
                }
            }

            if (suitDict != null)
            {
                start = suitDict;
                length++;
                dict.remove(suitDict);
                ladderLength(start, end, dict);
            }
            else
            {
                length = 0;
            }
        }
        return length;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();

        String start = "teach";
        String end = "place";

        Set<String> dict = new HashSet<String>();
        dict.add("peale");
        dict.add("wilts");
        dict.add("place");
        dict.add("fetch");
        dict.add("purer");
        dict.add("pooch");
        dict.add("peace");
        dict.add("poach");
        dict.add("berra");
        dict.add("teach");
        dict.add("rheum");
        dict.add("peach");

        System.out.println(s.ladderLength(start, end, dict));
    }
}
