
/*236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]





示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。*/


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Q236_lowest_common_ancestor_of_a_binary_tree {

    // 递归法
    // 思路 : 1. 不断的从树根往下探..当出现 p , q 任意一节点就返回 ;
    //       2.  当出现 p 在其中一边 但是另一边不是 q 的时候 ,就一直把 p 的节点一直往上返回 ;
    //       3 . 当 p , q 分别为左右节点的时间,它的父节点就是最近公共父节点 , 返回即为结果
    //  关键点 ： 找到一个节点，使得它的左右节点分别是 p , q ；假如没有就 去 创造
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归终止条件
        if (root == null || p == root || q == root) {
            return root;
        }

        // 递归调用
        TreeNode left = lowestCommonAncestor(root.left , p ,q);
        TreeNode right = lowestCommonAncestor(root.right , p , q) ;

        // 递归处理
        if (left == null ) return right;
        if (right == null ) return left ;
        return root;

    }
}
