package mine.test.question;

import mine.test.domain.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 两两交换链表中的节点 {

    @Test
    public void run() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode temp = swapPairs(l1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        for (int i = 0; i < list.size(); i += 2) {
            if (i + 1 >=list.size()) {
                break;
            }
            temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        if (list.size() > 0) {
            list.get(list.size() - 1).next = null;
        }
        return list.size() == 0 ? null : list.get(0);
    }
}