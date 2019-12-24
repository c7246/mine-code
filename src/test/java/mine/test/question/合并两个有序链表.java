package mine.test.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mine.test.domain.ListNode;
import org.junit.Test;

public class 合并两个有序链表 {
    @Test
    public void result() {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l = mergeTwoLists(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<ListNode> list = new ArrayList<>();
        addToList(l1, list);
        addToList(l2, list);
        if (list.size() == 0) return null;
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

    private void addToList(ListNode l, ArrayList<ListNode> list) {
        while (l != null) {
            list.add(l);
            l = l.next;
        }
    }
}
