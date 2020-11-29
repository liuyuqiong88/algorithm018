package work06;




/*
* 62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？



示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
* */


import java.lang.reflect.Array;
import java.util.Arrays;

public class Q62_unique_paths {


    // 时间复杂度 O(m * n)
    // 空间复杂度 O(m*n)
    // 思路 : 1. 先把所有的边界赋值为 1
    //       2.  遍历二维数组, dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePaths(int m, int n) {
        int [][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            grid[i][0] = 1 ;
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

    // 方法二 :
    // 时间复杂度 O(m*n)
    // 空间复杂度 O(n)
    // 思路: 一行一行累加 ; 由于 dp[i][j] = dp[i-1][j] + dp[j][j-1] , 而每次都是保存了上一行的值,所有dp[i][j-1]是知道的,
    //     然后 dp[i-1][j] 是在上一次循环执行了,所以也就知道,因此可以不必使用一个 M*N 的数组,而使用 n 大小的数组就够了
    public int uniquePaths2(int m, int n) {
        int [] cur = new int[n];
        Arrays.fill(cur,1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];

    }
}
