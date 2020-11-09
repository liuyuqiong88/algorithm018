
/*
* 46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q46_permutations {


    // 解题思路 : 使用递归，这道题用的方式应该是回溯 , 当它下探到下一层的时候,不管是否尝试成功回来的时候都会清除上一个添加的数字
    // 1 . 递归的终止条件是当 层数达到 nums.length 的 时候
    // 2. 遍历 整个数组,假如当前元素没有已经存在就下探到下一层, 下探回来需要清除这次调用添加的数
    // 时间复杂度 O(n * n !)
    // 空间复杂度 O(n)
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res= new ArrayList<List<Integer>>();

        // 这一步很巧妙,使用了一个记忆数组来存储是否被使用过的状态
        boolean[] used = new boolean[nums.length];   //  布尔数组初始化默认值为 false
        dfs(nums, 0,used,new ArrayList<Integer>() ,res);


//        dfs_0(nums, 0, new ArrayDeque<>() ,res);  不使用记忆空间的版本
        
        return res;

    }

    // leecode上跑的时候是 79.53%  和 78.23%
    private void dfs_0(int[] nums, int count, Deque<Integer> path,List<List<Integer>> res) {

        if(count == nums.length) {
            System.out.println(path);
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])){
                path.addLast(nums[i]);
                dfs_0(nums, count+1, path ,res);
                path.removeLast();
            }
        }
    }

    // leecode上跑的时候是 99.53%  和 92.77%
    private void dfs(int[] nums, int count,boolean[] used , ArrayList<Integer> path,List<List<Integer>> res) {

        if(count == nums.length) {
            System.out.println(path);
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, count+1,used, path ,res);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Q46_permutations p = new Q46_permutations();
        int [] t = {1,2,3};
        p.permute(t);

    }
}
