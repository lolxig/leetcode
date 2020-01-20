package com.xig.fallSeries.p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *
 *
 * 示例 1：
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 *
 *
 * 示例 2：
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 *
 *
 * 示例 3：
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 *
 *
 * 限制：
 *
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 */
public class Solution {

    public static void main(String[] args) {

        String command = "URR";
        int[][] obstacles = {{2, 2}};
        int x = 3;
        int y = 2;

        System.out.println(new Solution().robot(command, obstacles, x, y));
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {

        Map<Integer, List<Integer>> obstaclesMap = new HashMap<>();

        for (int[] obstacle : obstacles) {
            int obsX = obstacle[0], obsY = obstacle[1];
            List<Integer> listY = obstaclesMap.getOrDefault(obsX, new ArrayList<>());
            if (!listY.contains(obsY)) {
                listY.add(obsY);
                obstaclesMap.put(obsX, listY);
            }
        }

        int curX = 0, curY = 0;
        char[] array = command.toCharArray();
        int length = array.length;
        int index = 0;

        while (curX <= x && curY <= y) {

            char c = array[index++];

            if (index >= length)
                index %= length;

            switch (c) {
                case 'U':
                    curY++;
                    break;
                case 'R':
                    curX++;
                    break;
                default:
            }

            if (curX == x && curY == y)
                return true;

            List<Integer> listY = obstaclesMap.getOrDefault(curX, new ArrayList<>());
            if (listY.contains(curY))
                return false;
        }
        return false;
    }



//    public boolean robot(String command, int[][] obstacles, int x, int y) {
//
//        int[] map = new int[command.length()];
//        long[] obstacle = new long[obstacles.length];
//        int countX = 0;
//        int countY = 0;
//
//        for (int index = 0; index < command.length(); ++index) {
//            if (command.charAt(index) == 'R') {
//                map[index] = 1;
//                ++countX;
//            } else {
//                map[index] = 1_000_000_001;
//                ++countY;
//            }
//        }
//
//        for (int index = 0; index < obstacles.length; ++index) {
//            obstacle[index] = hashValue(obstacles[index][0], obstacles[index][1]);
//        }
//
//        int currentX = 0;   // 当前位置
//        int currentY = 0;
//
//        int oldX = 0;       // 老位置
//        int oldY = 0;
//
//        long currentValue = 0L;   // 当前位置的值
//
//        List<Long> list = new ArrayList<>();    // 路径数组
//
//        // 找到轮次
//        do {
//            currentX += countX; // 移动一轮
//            currentY += countY;
//
//            for (int i : map) {  // 记录路径
//                currentValue += i;
//                list.add(currentValue);
//            }
//
//        } while (currentX < x && (currentY < y));
//
//        if (!find(hashValue(x, y), list)) {
//            return false;
//        } else {
//            for (long ob : obstacle) {
//                if (find(ob, list)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    private static Long hashValue(int x, int y) {
//        return (long) (x + y * 1_000_000_001);
//    }
//
//    private static boolean find(long post, List<Long> list) {
//
//        int start = 0;
//        int end = list.size() - 1;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (post > list.get(mid)) {
//                start = mid + 1;
//            } else if (post < list.get(mid)) {
//                end = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

}
