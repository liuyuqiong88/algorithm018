package work09;


/*
*387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2 */

import java.util.HashMap;

public class Q387_first_unique_character_in_a_string {


    // 时间复杂度 O(n)
    // 空间复杂度 : O(n)
    // 思路 : 使用哈希 , 第一步 : 遍历字符串,使用哈希表存字符以及出现的出现;
    //                 第二步 : 遍历字符串,找到第一步没有重复的字符
    public int firstUniqChar(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        char tmp ;
        for (int i = 0; i < n; i++) {
            tmp = s.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) return i ;
        }

        return -1 ;
    }
}


