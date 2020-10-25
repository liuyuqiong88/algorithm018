public class Q26 {
    public static void main(String[] args) {

        Q26 q = new Q26();
        int[] t = {1,1,2};
        System.out.println(q.removeDuplicates(t));
    }

    //  思路 ： 利用快慢指针 ; 快指针寻找不重复的元素下标, 慢指针指向要替换的元素下标，当 nums[慢指针]!=nums[快指针]时,交换,慢指针++;
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){return 0;}
        int h = 0;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] != nums[h]){
                nums[++h] = nums[i];
            }
        }
        return h+1;
    }
}
