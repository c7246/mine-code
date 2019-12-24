package mine.test.question;

import mine.test.domain.ListNode;
import org.junit.Test;

import java.util.ArrayList;

public class 删除链表的倒数第N个节点 {
    @Test
    public void result() {
        ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(1);
//		l1.next.next.next.next = new ListNode(7);
        System.out.println(removeNthFromEnd(l1, 1).next);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int length = list.size();
        list.remove(length - n);
        System.out.println(list.size());
        if (length - n > 0) {
            if (length - n < list.size()) {
                list.get(length - n - 1).next = list.get(length - n);
            } else {
                list.get(length - n - 1).next = null;
            }
        }
        if (list.size() == 0)
            return null;
        return list.get(0);
    }
}