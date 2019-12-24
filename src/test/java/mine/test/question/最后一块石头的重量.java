package mine.test.question;

import org.junit.Test;

import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author caijinnan
 * @date 2019/12/18 20:20
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class 最后一块石头的重量 {


    @Test
    public void run() {
        int[] arr = {2, 4, 8, 8};
        System.out.println(lastStoneWeight(arr));
    }


    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        for (int i = stones.length - 1; i >= 1; i--) {
            Arrays.sort(stones);
            int bigNum = stones[stones.length - 1];
            int smallNum = stones[stones.length - 2];
            stones[stones.length - 1] = bigNum - smallNum;
            stones[stones.length - 2] = 0;
        }
        return stones[stones.length - 1];
    }

}
