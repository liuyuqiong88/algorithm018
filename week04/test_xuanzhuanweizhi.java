
/*
* 作业题 : 找使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方*/

public class test_xuanzhuanweizhi {

    // 思路 : 依旧是不断的中分,寻找的范围是存在旋转的区域,终止条件是    nums[i-1]<nums[i] < nums[i +1]
    // 当时有序是 返回  -1
    // 时间复杂度 : O(n)
    // 空间复杂度 : O(1)
    public int getNumber(int[] nums){

        int left = 0 , right = nums.length -1 , mid;

        while (left <= right){
            mid = (left + right) /2 ;
            if (nums[mid] < nums[left] && nums[mid] < nums[right] ){
                return mid;
            }
            if (nums[mid] <= nums[left]){
                right = mid -1 ;
            }
            else {
                left = mid  ;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // 测试数组 : {4, 5, 6, 7, 0, 1, 2}
        int [] test = {4, 5, 6, 7, 0 , 2 };

        test_xuanzhuanweizhi t = new test_xuanzhuanweizhi();

        int index = t.getNumber(test);
        System.out.println("找到的下标是 : " + index  );
    }
}
