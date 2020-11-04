/*
* 145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
* */


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q145_binary_tree_postorder_traversal {


    // 递归法  后序 : 左右父
    //// 时间复杂度 O(n),空间复杂度 O(n)
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;

    }
    public void postorder(TreeNode root , List<Integer> res){

        if (root == null) {return;}

        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    // 迭代法 , 后序的 迭代法比前序和中序要多处理一段逻辑,就是当右节点为空的时候
    // 时间复杂度 O(n),空间复杂度 O(n)
    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            }else {
                stk.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
