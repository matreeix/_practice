package _leetcode._CONTEST._biweekly._65;

import com.sun.deploy.panel.DeleteFilesDialog;

/**
 * @Description: 5911. 模拟行走机器人 II
 * 给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height - 1) 。
 * 网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方向为 "East" 。
 * 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。
 * 沿着当前方向尝试 往前一步 。
 * 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
 * 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。
 * <p>
 * 请你实现 Robot 类：
 * Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
 * void move(int num) 给机器人下达前进 num 步的指令。
 * int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
 * String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。
 * 提示：
 * 2 <= width, height <= 100
 * 1 <= num <= 10^5
 * move ，getPos 和 getDir 总共 调用次数不超过 104 次。
 * @Date: 2021/11/13
 */

public class Robot {

    private String[] dirWord = {"North", "East", "South", "West"};
    private int x;
    private int y;
    private int width;
    private int height;
    private int idx;
    private int[] path;
    private int curDir;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.idx = 0;
        this.path = new int[2 * (width - 1 + height - 1)];
        this.curDir = 1;
    }

    public void move(int num) {
        int move = num % path.length;
        idx = (idx + move) % path.length;
        if (0 < idx && idx < width) {
            curDir = 1;
            x = idx;
            y = 0;
        } else if (width <= idx && idx < width + height - 1) {
            curDir = 0;
            x = width - 1;
            y = idx - x;
        } else if (width + height - 1 <= idx && idx < 2 * width + height - 2) {
            curDir = 3;
            x = (2 * width + height - 3) - idx;
            y = height - 1;
        } else {
            curDir = 2;
            x = 0;
            y = idx == 0 ? 0 : path.length - idx;
        }
        System.out.println(idx);
    }

    public int[] getPos() {
        System.out.println("(" + x + "," + y + ")");
        return new int[]{x, y};
    }

    public String getDir() {
        System.out.println(dirWord[curDir]);
        return dirWord[curDir];
    }

    public static void main(String[] args) {
        Robot robot = new Robot(8, 2);
        robot.move(17);
        robot.getPos();
        robot.getDir();
        robot.move(21);
        robot.getPos();
        robot.getDir();
        robot.move(22);
        robot.move(34);
        robot.getPos();
        robot.getDir();

        robot.move(1);
        robot.move(46);
        robot.move(35);

        robot.getPos();
        robot.getDir();
        robot.move(44);
        robot.move(14);
        robot.move(31);
    }
}
