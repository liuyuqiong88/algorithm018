package work09;




/*541. 反转字符串 II
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"*/




public class Q541_reverse_string_ii {


    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    // 遍历字符串,步长为 2k ; 分为 <k 或者 > k 两种情况去处理
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return s ;
        String res = "";
        for (int i = 0; i < n ; i += 2 * k ){
            if (n - i < k){
                for(int j = n-1 ; j >= i ; j-- ){
                    res += s.charAt(j);
                }
            }
            else {
                for(int j = i+k-1 ; j >= i ; j-- ){
                    res += s.charAt(j);
                }
                for (int j = i+k; j <  Math.min(i + 2 * k , n); j++) {
                    res += s.charAt(j);
                }
            }
        }
        return res ;
    }

    // 时间复杂度 O(logn), 这个少于O(n)，因为只替换 小于或者等于k 部分
    // 空间复杂度 O(n) n 为 字符串的长度
    // 把字符串转换为 数组 , 然后通过数组元素替换去反转, 最后再转化为字符串返回
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += (k * 2)) {
            revser(chars, i, Math.min(i + k - 1, chars.length - 1));
        }
        return new String(chars);
    }
    public void revser(char[] chars, int i, int j) {
        for (int k = i; k < j; k++) {
            char temp = chars[k];
            chars[k] = chars[j];
            chars[j] = temp;
            j--;
        }
    }


}
