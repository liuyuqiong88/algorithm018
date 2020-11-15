package work04;


/*
* 33. 搜索旋转排序数组
给你一个整数数组 nums ，和一个整数 target 。

该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。

请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。


示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1*/

public class Q33_search_in_rotated_sorted_array {

    // 思路 : 依旧是使用二分查找,不过这道题的二分查找切割分区会有点复杂, 首先根据旋转情况先分出两个区域，然后在指定的区域中在根据target
    // 所在的区域决定如何夹逼缩进 ;

    //  这里还用了一个技巧,就是只处理那些比较容易处理单一的情况,比如在旋转分区在左边的时候,这时候右边是有序,就直接考虑右边,因为这时候右边是有序的,
    //  情况比较单一,就先处理右边,剩下的就是处理存在旋转的分区;
    //  千万不要陷入旋转分区里面去人肉二分搜索,这时候会发现很多不同的情况,会越想越乱,思路拎不清,代码也很难写

    // 时间复杂度 : O(logn)
    // 空间复杂度 : O(1)
    public int search(int[] nums, int target) {

        int left = 0 , right = nums.length -1 ,mid;
        while (left <= right){
            mid = (left + right) / 2 ;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }
                else {
                    left = mid +1 ;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1 ;
                }
            }
        }
        return -1 ;
    }
}
