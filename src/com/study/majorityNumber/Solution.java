package com.study.majorityNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        // TODO Auto-generated method stub
        System.out.println(new Solution().majorityNumber(list));
    }

    /*
     * 问题：给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
     * 
     * @param nums: a list of integers
     * 
     * @return: find a majority number
     */
    public int majorityNumber(List<Integer> nums)
    {
        // 用map集合，键用不重复的元素，值用该元素的个数
        int num = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++)
        {
            if (map.containsKey(nums.get(i)))
            {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
            }
            else
            {
                map.put(nums.get(i), 1);
            }
        }

        for (Integer count : map.keySet())
        {
            if (map.get(count) > nums.size() / 2)
            {
                num = count;
                break;
            }
        }

        return num;
    }
}
