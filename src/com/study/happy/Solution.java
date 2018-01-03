package com.study.happy;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n)
    {
        List<Integer> sumList = new ArrayList<Integer>();
        sumList.add(n);

        int sum = getNumberSum(n);

        boolean flag = true;

        while (sum != 1)
        {
            if (sumList.contains(sum))
            {
                flag = false;
                break;
            }
            else
            {
                sumList.add(sum);
                sum = getNumberSum(sum);
            }
        }

        return flag;
    }

    private List<Integer> getNumberList(int n)
    {
        List<Integer> numberList = new ArrayList<Integer>();

        char[] chars = (String.valueOf(n)).toCharArray();

        for (char c : chars)
        {
            numberList.add(Integer.valueOf(String.valueOf(c)));
        }

        return numberList;
    }

    private int getNumberSum(int n)
    {
        List<Integer> numberList = getNumberList(n);

        int sum = 0;
        for (Integer i : numberList)
        {
            sum += i * i;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println("Is a happy number? " + solution.isHappy(19));
    }

}
