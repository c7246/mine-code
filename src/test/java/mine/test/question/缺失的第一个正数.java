package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 缺失的第一个正数 {

    @Test
    public void run() {
        int[] nums = {-1,-1,-3,-4};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==0){return 1;}
        for(int num : nums){
            if(num<=0){
                continue;
            }else{
                list.add(num);
            }
        }
        if(list.size()==0){
            return 1;
        }
        Collections.sort(list);
        if(list.get(0)>1){
            return 1;
        }
        int lastNum = 0;
        for(int num : list){
            if(num-lastNum>1){
                return lastNum+1;
            }
            lastNum = num;
        }
        return list.get(list.size()-1)+1;
    }
}