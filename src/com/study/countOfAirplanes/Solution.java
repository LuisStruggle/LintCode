package com.study.countOfAirplanes;

import java.util.ArrayList;
import java.util.List;

public class Solution
{

    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes)
    {
        List<Interval> airplanesR = airplanes;

        int start;
        int end;

        int count = 0;

        while (airplanes.size() > 0)
        {
            List<Interval> airplanesResult = new ArrayList<Interval>();

            for (int i = 0; i < airplanes.size(); i++)
            {
                int start1 = airplanes.get(i).start;
                int end1 = airplanes.get(i).end;
                for (int j = i + 1; j < airplanes.size(); j++)
                {
                    int start2 = airplanes.get(j).start;
                    int end2 = airplanes.get(j).end;
                    if (start1 == start2)
                    {
                        start = start1;
                        if (end1 <= end2)
                        {
                            end = end1;
                        }
                        else
                        {
                            end = end2;
                        }
                        for (Interval interval : airplanesResult)
                        {
                            if (interval.start == start && interval.end == end)
                            {
                                break;
                            }
                            else
                            {
                                airplanesResult.add(new Interval(start, end));
                            }
                        }
                    }
                    else if (start1 < start2)
                    {
                        if (end1 > start2)
                        {
                            start = start2;
                            if (end1 <= end2)
                            {
                                end = end1;
                            }
                            else
                            {
                                end = end2;
                            }
                            if (!isExist(airplanesResult, start, end))
                            {
                                airplanesResult.add(new Interval(start, end));
                            }
                        }
                    }
                    else
                    {
                        if (start1 < end2)
                        {
                            start = start1;
                            if (end1 <= end2)
                            {
                                end = end1;
                            }
                            else
                            {
                                end = end2;
                            }
                            if (!isExist(airplanesResult, start, end))
                            {
                                airplanesResult.add(new Interval(start, end));
                            }
                        }
                    }
                }
            }

            if (airplanesResult.size() == 1)
            {
                count = getCount(airplanesR, airplanesResult.get(0).start, airplanesResult.get(0).end);
                break;
            }
            else
            {
                if (airplanesResult.size() == 0)
                {
                    int[] counts = new int[airplanes.size()];

                    for (Interval interval : airplanesR)
                    {
                        int i = 0;
                        for (Interval interval1 : airplanes)
                        {
                            int count1 = 0;
                            if (interval.start <= interval1.start && interval.end >= interval1.end)
                            {
                                count1++;
                            }
                            counts[i] = count1;
                            i++;
                        }
                    }

                    count = counts[0];

                    for (int i = 0; i < counts.length; i++)
                    {
                        if (counts[i] > count)
                        {
                            count = counts[i];
                        }
                    }
                }
            }

            airplanes = airplanesResult;
        }

        return count;
    }

    private boolean isExist(List<Interval> airplanesResult, int start, int end)
    {
        boolean flag = false;
        for (Interval interval : airplanesResult)
        {
            if (interval.start == start && interval.end == end)
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private int getCount(List<Interval> airplanesR, int start, int end)
    {
        int count = 0;
        for (Interval interval : airplanesR)
        {
            if (interval.start <= start && interval.end >= end)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        List<Interval> list = new ArrayList<Interval>();

        list.add(new Interval(52, 61));
        list.add(new Interval(54, 59));
        list.add(new Interval(34, 35));
        list.add(new Interval(28, 37));

        list.add(new Interval(94, 97));
        list.add(new Interval(96, 100));
        list.add(new Interval(76, 85));
        list.add(new Interval(77, 87));

        list.add(new Interval(77, 87));
        list.add(new Interval(21, 24));
        list.add(new Interval(9, 15));
        list.add(new Interval(45, 55));

        list.add(new Interval(99, 103));
        list.add(new Interval(58, 66));
        list.add(new Interval(35, 43));
        list.add(new Interval(23, 27));

        list.add(new Interval(40, 49));
        list.add(new Interval(45, 49));
        list.add(new Interval(13, 19));
        list.add(new Interval(37, 42));

        list.add(new Interval(31, 32));
        list.add(new Interval(5, 11));
        list.add(new Interval(83, 89));
        list.add(new Interval(90, 97));

        list.add(new Interval(36, 41));
        list.add(new Interval(90, 97));
        list.add(new Interval(91, 98));
        list.add(new Interval(98, 101));

        // [[93,102],[80,85],[60,62],[72,79],[85,87],[77,86],[93,103],[64,74],[62,69],[77,78],[71,74],[47,53],[21,29],[43,50],[30,34],[68,75],[53,61],[3,10],[8,9],[14,21],[32,40],[10,15],[91,96],[6,11],[16,23],[27,31],[51,58],[73,74],[98,106],[51,58],[10,17],[24,34]]

        System.out.println(solution.countOfAirplanes(list));
    }

}
