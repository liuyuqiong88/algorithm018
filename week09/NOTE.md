多种情况的动态规划的状态转移方程

找到重复性-> 转化为计算机指令 

分治和动态规划没有本质的区别,动态规划会在执行过程中不断的淘汰掉一些低效的问题,（剪枝）

1 . 分解为过个简单的子问题

分治 + 最优子结构

顺推形式:动态递推

def DP():
  dp = [m][n]
	for i in range(m):
    for j in rangge(n):
      dp[i][j] = _Function(dp[i1][j1]...)
  return dp[m][n]

关键点 : 

动态规划和递归或者分治都没有根本上的区别 (关键看有无最优的子结构)

拥有共性: 找到重复子问题

差异性 : 最优子结构、中途可以淘汰次优解

打家劫舍 : 

dp[i] 状态的定义 : max of  robbing A[0 -> i]

dp[i] = max( dp[i - 2] + nums[i] , dp[ i - 1] )

dp[i][0] 状态定义 : max $ of robbing A [0 - > i ]  且 没偷 nums[i]

dp[i][1] 状态定义 : max $ of robbing A[0 -> i] 且 偷了 nums[i]

dp[i][0] = max(dp[i-1][0] , dp[i -1][1]);

dp[i][1] = dp[i-1][0] + nums[i];

最小路劲和 : 

dp[i][j] 状态的定义 : minPath(A[ 1 -> i][1->j])

dp[i][j]  = min(dp[i-1][j]) , dp[i][j - 1] + A[i][j]
