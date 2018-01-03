package com.jingsai.ieee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Journey
{
    private static int[] coordinate = { 0, 0 }; // 坐标
    private static int direction = 1; // 方向（1：东，2：西，3：南，4：北）,默认1
    private static List<String> path = new ArrayList<String>(); // 记录跳转路径（寻找周期）
    private static int flag = 0; // 如果有循环，则表示是否进行第二次循环

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext())
        {
            // 初始化数据
            coordinate = new int[] { 0, 0 };
            direction = 1;
            path.clear();
            flag = 0;

            // 获取总行数n
            int n = Integer.parseInt(sc.nextLine());

            // 获取每一行数据，以数组的形式存入数组
            List<String[]> list = new ArrayList<String[]>();
            for (int i = 0; i < n; i++)
            {
                String[] strs = sc.nextLine().split(" ");
                list.add(strs);
            }

            // 进入第一行命令，初始化
            int result = handleCenter(list, "F0", "F1", 0);
            if (flag < 0)
            {
                // 如果flag等于-1，则输出不可达
                System.out.println("Infinity");
            }
            else
            {
                // 否则输出|x|+|y|最大数
                System.out.println(result);
            }
        }
    }

    /**
     * 
     * @param list 命令数组
     * @param s 当前命令
     * @param e 目标命令
     * @param maximum |x|+|y|最大数
     * @return
     */
    private static int handleCenter(List<String[]> list, String s, String e, int maximum)
    {
        int maximum1;

        if (path.contains(s + e) && path.contains(e + s))
        {
            path.clear();
            flag++;
        }
        path.add(s + e);
        if (flag < list.size() && flag > -1)
        {
            int bh = Integer.parseInt(e.replace("F", "")); // 获取要执行的命令行编号
            String[] strs = list.get(bh - 1); // 获取该行命令
            int gs = Integer.parseInt(strs[0]); // 获取该行命令个数
            for (int i = 1; i <= gs; i++)
            {
                if (strs[i].startsWith("F"))
                { // 以F开头的命令是跳转其他行的命令
                    maximum1 = handleCenter(list, e, strs[i], maximum);
                    if (maximum1 > maximum)
                    {
                        if (flag == (list.size() - 1))
                        {
                            flag = -2;
                        }
                        else
                        {
                            maximum = maximum1;
                        }
                    }
                }
                else if (strs[i].equals("LEFT") || strs[i].equals("RIGHT"))
                {
                    if (direction == 1)
                    {
                        if (strs[i].equals("LEFT"))
                        {
                            direction = 4;
                        }
                        if (strs[i].equals("RIGHT"))
                        {
                            direction = 3;
                        }
                    }
                    else if (direction == 2)
                    {
                        if (strs[i].equals("LEFT"))
                        {
                            direction = 3;
                        }
                        if (strs[i].equals("RIGHT"))
                        {
                            direction = 4;
                        }
                    }
                    else if (direction == 3)
                    {
                        if (strs[i].equals("LEFT"))
                        {
                            direction = 1;
                        }
                        if (strs[i].equals("RIGHT"))
                        {
                            direction = 2;
                        }
                    }
                    else if (direction == 4)
                    {
                        if (strs[i].equals("LEFT"))
                        {
                            direction = 2;
                        }
                        if (strs[i].equals("RIGHT"))
                        {
                            direction = 1;
                        }
                    }
                }
                else if (strs[i].equals("GO"))
                {
                    if (direction == 1)
                    {
                        coordinate[0] += 1;
                    }
                    else if (direction == 2)
                    {
                        coordinate[0] -= 1;
                    }
                    else if (direction == 3)
                    {
                        coordinate[1] -= 1;
                    }
                    else if (direction == 4)
                    {
                        coordinate[1] += 1;
                    }
                    maximum1 = Math.abs(coordinate[0]) + Math.abs(coordinate[1]);
                    if (maximum1 > maximum)
                    {
                        if (flag == (list.size() - 1))
                        {
                            flag = -2;
                        }
                        else
                        {
                            maximum = maximum1;
                        }
                    }
                }
            }
        }

        return maximum;
    }
}
