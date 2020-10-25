public class Q1 {
    
    // 方法 一 : 穷举 , 类似选择排序的方式
    // 时间复杂度 nlogn
    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // 方法二思路 , 使用 hash表 ,构造一个缓存表,然后去hashmap中拿 target - num[i] 是否存在,存在就返回,不存在就把num[i]加入到hashMap中，
    // 时间复杂度O(n)
    public int[] twoSum2(int[] nums , int target){
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>() ;
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                return new int[]{i, m.get(target - nums[i])};
            }
            m.put(nums[i],i );
        }
        return new int[0];
    }
}
