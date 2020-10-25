public class Q66 {

    public static void main(String[] args) {
        System.out.println("哈哈哈");
        Q66 q = new Q66();

        int [] t = {9,9,9};
        t = q.plusOne1(t);

        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
        
    }

//  思路  : 分为两种情况,当位上的数为9时,要往上进一步,当是999的时候要重新生成一个数组 ;不为9的话+1直接返回结果 ;  这题没有其他解,本身就简单
    public int[] plusOne1(int [] digits){

        for (int i = digits.length-1; i >= 0 ; i--) {
            digits[i] += 1 ;
            if (digits[i] < 10 ){
                return digits;
            }
            digits[i] = 0 ;
        }
        int [] new_digits = new int[digits.length+1];
        new_digits[0] = 1 ;
        return new_digits ;


    }
}
