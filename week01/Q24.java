class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Q24 {

    public static void main(String[] args) {

    }
    
    //   使用迭代的方式 , 首先满足交换的条件,必须是这一个节点和下一个节点都不为空 ;
//    交换的思路 : 这里需要利用到前一个节点;
//    步骤 : 先让缓存节点指向第二个节点;
//          2 . 第二个节点的 next 值 赋给第一个节点的next
//          3 。 第二个节点的next指向第一个节点
//          4 。 缓存节点换位 第一个节点
    public ListNode swapPairs(ListNode head) {

        ListNode p = new ListNode(0);
        p.next = head;
        ListNode tmp = p;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode t1 = tmp.next;
            ListNode t2 = tmp.next.next;
            tmp.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            tmp = t1;
        }
        return p.next;
    }
    //    递归法
    public ListNode swapPairs1(ListNode head) {

        if (head == null || head.next == null) { // 递归结束条件 ,当进入的节点head为空或者下个节点为空 , 就没必要交换,返回 head
            return head;
        }
        // 交换过程
        ListNode t = head.next;   // head的下个节点拿出来用临时变量放着 （ ListNode t = head.next; ）
//        head.next 变为下次循环的某个节点, head.next = swapPairs1(t.next); 这里有点难理解,是遍历到最后的两个节点;
//                                   再回溯回来的 ;
        head.next = swapPairs1(t.next);

        t.next = head; // 每组交换的第二个节点的next，指向第一个节点

        return t; // 这里为什么不是返回 head ?
    }
}
