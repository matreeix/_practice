package _CONTEST._weekly._224;

/**
 * @Description: 1728. 猫和老鼠 II
 * 一只猫和一只老鼠在玩一个叫做猫和老鼠的游戏。
 * <p>
 * 它们所处的环境设定是一个 rows x cols 的方格 grid ，其中每个格子可能是一堵墙、一块地板、一位玩家（猫或者老鼠）或者食物。
 * 1.玩家由字符 'C' （代表猫）和 'M' （代表老鼠）表示。
 * 2.地板由字符 '.' 表示，玩家可以通过这个格子。
 * 3.墙用字符 '#' 表示，玩家不能通过这个格子。
 * 4.食物用字符 'F' 表示，玩家可以通过这个格子。
 * 5.字符 'C' ， 'M' 和 'F' 在 grid 中都只会出现一次。
 * <p>
 * 猫和老鼠按照如下规则移动：
 * 1.老鼠 先移动 ，然后两名玩家轮流移动。
 * 2.每一次操作时，猫和老鼠可以跳到上下左右四个方向之一的格子，他们不能跳过墙也不能跳出 grid 。
 * 3.catJump 和 mouseJump 是猫和老鼠分别跳一次能到达的最远距离，它们也可以跳小于最大距离的长度。
 * 4.它们可以停留在原地。
 * 5.老鼠可以跳跃过猫的位置。
 * <p>
 * 游戏有 4 种方式会结束：
 * 1.如果猫跟老鼠处在相同的位置，那么猫获胜。
 * 2.如果猫先到达食物，那么猫获胜。
 * 3.如果老鼠先到达食物，那么老鼠获胜。
 * 4.如果老鼠不能在 1000 次操作以内到达食物，那么猫获胜。
 * 给你 rows x cols 的矩阵 grid 和两个整数 catJump 和 mouseJump ，双方都采取最优策略，如果老鼠获胜，那么请你返回true，否则返回false。
 * @Date: 2021/1/21
 */

public class Solution4 {

    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n, m, available, catJump, mouseJump;
    private String[] grid;
    private Boolean[][][][][] dp;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int[] cat = {-1, -1};
        int[] mouse = {-1, -1};
        this.grid = grid;
        this.catJump = catJump;
        this.mouseJump = mouseJump;
        n = grid.length;
        m = grid[0].length();
        available = 0;//可移动的位置数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) != '#') {
                    available++;
                }
                if (grid[i].charAt(j) == 'C') {
                    cat = new int[]{i, j};
                } else if (grid[i].charAt(j) == 'M') {
                    mouse = new int[]{i, j};
                }
            }
        }
        dp = new Boolean[available * 2 + 1][n][m][n][m];
        return dfs(0, cat, mouse);
    }

    private boolean dfs(int turn, int[] cat, int[] mouse) {
        if (dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]] != null) {
            return dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]];
        }
        if (turn == available * 2) {
            return false;
        }
        if (turn % 2 == 0) {//老鼠回合
            for (int[] dir : dirs) {
                for (int i = 0; i <= mouseJump; i++) {
                    int x = mouse[0] + i * dir[0];
                    int y = mouse[1] + i * dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x].charAt(y) == '#') {
                        break;
                    }
                    if (grid[x].charAt(y) == 'F' //找到食物
                            || dfs(turn + 1, cat, new int[]{x, y})) {
                        return dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]] = true;
                    }
                }
            }
            return dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]] = false;
        } else {//猫回合
            for (int[] dir : dirs) {
                for (int i = 0; i <= catJump; i++) {
                    int x = cat[0] + i * dir[0];
                    int y = cat[1] + i * dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x].charAt(y) == '#') {
                        break;
                    }
                    if (x == mouse[0] && y == mouse[1] //逮到老鼠
                            || grid[x].charAt(y) == 'F' //找到食物
                            || !dfs(turn + 1, new int[]{x, y}, mouse)) {
                        return dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]] = false;
                    }
                }
            }
            return dp[turn][cat[0]][cat[1]][mouse[0]][mouse[1]] = true;
        }
    }
}
