package mine.test.question;

import java.util.ArrayList;

import mine.test.domain.ListNode;
import org.junit.Test;

public class 链表数字求和 {
    @Test
    public void result() {
        ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
        ListNode l = addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (l1 != null || l2 != null) {
            int x = 0;
            if (l1 != null) x = l1.val;
            int y = 0;
            if (l2 != null) y = l2.val;
            int z = x + y;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (z >= 10) {
                if (l1 == null) {
                    l1 = new ListNode(1);
                } else {
                    l1.val += 1;
                }
                z = z % 10;
            }
            list.add(new ListNode(z));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

}
