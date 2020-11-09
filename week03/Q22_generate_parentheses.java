/*
* 22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]*/

import java.util.ArrayList;
import java.util.List;

public class Q22_generate_parentheses {


    // 思路 : 1 . 先不考虑生成所有的括号字符串
    //       2.  再去过滤掉所有的不合法字符串,
    //       3.  左括号要添加必须满足 (left < n )
    //       4. 有括号必须满足 right < left (注意这里因为左括号是<n的,所有right<left也即是right<n; 传递性)
    //  时间复杂度 :  O(2n) = O(n)
    //  空间复杂对 :  O(n)
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        _generate(0,0,n,"",res);
        return res;
    }

    private void _generate(int left , int right , int max ,String s,List<String> res) {
        if (left == max && right == max){
            System.out.println(s);
            res.add(s);
            return;
        }
        if (left < max){
            _generate(left +1 ,right,max , s+"(",res);
        }
        if(right < left){
            _generate(left , right+1, max , s+")",res);
        }

    }

    public static void main(String[] args) {
        Q22_generate_parentheses q = new Q22_generate_parentheses();
        q.generateParenthesis(3);
    }
}
