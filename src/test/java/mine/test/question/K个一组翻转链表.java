package mine.test.question;

import java.util.ArrayList;
import java.util.List;

import mine.test.domain.ListNode;
import org.junit.Test;

public class K个一组翻转链表 {
    @Test
    public void result() {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        addToList(head, list);
        if (list.size() == 0) return null;
        troggle(list, k);
        return list.get(0);

    }

    private void troggle(List<ListNode> list, int width) {
        for (int i = 0; i <= list.size() - width; i += width) {
            for (int x = i, y = i + width - 1; x < y; x++, y--) {
                ListNode temp = list.get(x);
                list.set(x, list.get(y));
                list.set(y, temp);
            }
        }
        for (int x = 0; x < list.size(); x++) {
            if (x == list.size() - 1) {
                list.get(x).next = null;
                break;
            }
            list.get(x).next = list.get(x + 1);
        }

    }

    private void addToList(ListNode l, ArrayList<ListNode> list) {
        while (l != null) {
            list.add(l);
            l = l.next;
        }
    }
}