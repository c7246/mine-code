package mine.test.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mine.test.domain.ListNode;
import org.junit.Test;

public class 合并k个有序列表 {
	@Test
	public void result() {
		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(7);
		ListNode lists[] = {l1,l2};
		ListNode l = mergeKLists(lists);
		while(l!=null) {
			System.out.println(l.val);
			l=l.next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ArrayList<ListNode> list = new ArrayList<>();
		for(ListNode l :lists) {
			addToList(l, list);
		}
		if(list.size()==0)return null;
		Collections.sort(list, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		for(int i = 0;i<list.size();i++) {
			if(i==list.size()-1) {
				list.get(i).next=null;break;
			}
			list.get(i).next=list.get(i+1);
		}
		return list.get(0);
	}
	private void addToList(ListNode l, ArrayList<ListNode> list) {
		while(l!=null) {
			list.add(l);
			l=l.next;
		}
	}
}