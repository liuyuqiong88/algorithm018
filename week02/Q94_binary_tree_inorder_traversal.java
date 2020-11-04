
/*
* 94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
* */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
        this.right = right;
     }
 }

public class Q94_binary_tree_inorder_traversal {
    
     // 递归法  中序 : 左父右
    // 时间复杂度 O(n),空间复杂度 O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    
    // 迭代法  ,就是手动维护一个栈 , 实测手动维护一个栈的速度是不如直接使用递归的
    // 时间复杂度 O(n),空间复杂度 O(n)
   public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
       Deque<TreeNode> stk = new LinkedList<TreeNode>();
       while (root != null || !stk.isEmpty()){
           while (root != null){
               stk.push(root);
               root = root.left;
           }
           root = stk.pop();
           res.add(root.val);
           root = root.right;
       }
        return res;
    }
}
