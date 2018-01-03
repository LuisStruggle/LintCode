package com.study.countOfAirplanes;

public class Interval
{

    int start, end;

    Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "[" + this.start + "," + this.end + "]";
    }

}
