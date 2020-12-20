package work09;


/*
* 62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？



示例 1：


输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109*/




public class Q62_unique_paths {


    // 时间复杂度 O(m*n+m+n)
    // 空间复杂度 O(m*n)
    // 第一步 : 先把第一行第一列都赋值为 1 ; 然后就矩阵循环即可
    // 最优子结构 : grid[i][j] = grid[i-1][j] + grid[i][j-1]
    public int uniquePaths(int m, int n) {

        int [][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1 ;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];

    }
}
