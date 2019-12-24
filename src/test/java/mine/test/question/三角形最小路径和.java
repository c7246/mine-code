package mine.test.question;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 三角形最小路径和 {
	@Test
	public void result() {
		List<List<Integer>> triangle=new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		triangle.add(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		triangle.add(list2);
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		triangle.add(list3);
		List<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list4);
		System.out.println(minimumTotal(triangle));
	}
	public int minimumTotal(List<List<Integer>> triangle) {
		List<List<Integer>> minList=new ArrayList<>();
		minList.add(triangle.get(0));
		for(int j=1;j<triangle.size();j++) {
			List<Integer> temp= triangle.get(j);
			List<Integer> inner = new ArrayList<>();
			for(int i = 0;i<temp.size();i++) {
				if(i==0) {
					inner.add(temp.get(i)+minList.get(j-1).get(i));
				}else if(i==temp.size()-1) {
					inner.add(temp.get(i)+minList.get(j-1).get(i-1));
				}else {
					inner.add(Math.min(temp.get(i)+minList.get(j-1).get(i),temp.get(i)+minList.get(j-1).get(i-1)));
				}
			}
			minList.add(inner);
		}
		int min = Integer.MAX_VALUE;
		System.out.println(minList);
		for(Integer num:minList.get(minList.size()-1)) {
			min = Math.min(min, num);
		}
	    return min; 
	}
}