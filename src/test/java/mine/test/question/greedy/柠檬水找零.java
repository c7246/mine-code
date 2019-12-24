package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/20 11:11
 */
public class 柠檬水找零 {


    @Test
    public void run() {
        int[] arr = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(arr));
    }


    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;

        for (int i = 0; i < bills.length; i++) {
            int num = bills[i];
            if (num > 5) {
                if(num==20){
                    if((tenNum<1||fiveNum<1)&&fiveNum<3){
                        return false;
                    }
                    if(tenNum>=1){
                        tenNum--;
                        fiveNum--;
                    }else{
                        fiveNum-=3;
                    }
                }
                if(num==10){
                    if(fiveNum<1){
                        return false;
                    }else{
                        fiveNum--;
                    }
                }
            } else {
                fiveNum++;
            }
            if (num == 10) {
                tenNum++;
            }
        }


        return true;
    }
}