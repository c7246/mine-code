package mine.test.question;

import mine.test.domain.ListNode;
import org.junit.Test;

public class 删除排序链表中的重复元素 {
    @Test
    public void result() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode l = deleteDuplicates(head);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
            } else {
                p.next = p.next.next;
            }
        }
        return head;
    }
}