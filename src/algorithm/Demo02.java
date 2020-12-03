package algorithm;

import java.util.Arrays;
import java.util.List;

/*
    超级"水王"数
        一个队列中，某一个数据出现的次数大于等于这个队列长度的一半，则这个队列是水王数
        判断这个队列是否是水王树，并且找到“水王”

    思路：
        两两比较，不同删除，相同+1
        两个变量
            当前目标数
            当前目标数个数
 */
public class Demo02 {
    public static void main(String[] args) {
        int data[] = new int[]{1,2,3,4,5,6,2,3,4,5,6,3,4,5,6,4,5,6,5,6,6};
        int res = checkAndFind(data);
        System.out.println(res == -1 ? "没有水王" : "是水王数，水王是：" + res);
    }

    /**
     * 判断是否是水王数，并返回水王
     * @param data
     * @return
     */
    public static int checkAndFind(int[] data){
        if (data == null || data.length == 0){
            return -1;
        }

        int compareNum = 0;     // 当前目标
        int compareCount = 0;   // 当前目标数量
        for(int curr: data){
            if (compareCount == 0){
                // 如果当前目标数量为空，设定当前值为当前目标，当前目标数量为1
                compareNum = curr;
                compareCount = 1;
            } else if (compareNum != curr) {
                // 如果当前目标与当前值不相同，扣减当前目标数量
                compareCount--;
            } else {
                // 如果相同，增加当前目标数量
                compareNum++;
            }
        }

        // 判断当前目标数量
        if (compareCount == 0){
            return -1;
        }

        // 判断当前目标总体存在次数(因为可能剩余当前目标，但是次数却不符合要求比如(1,2,3,4,5))
        compareCount = 0;
        for (int i : data){
            if (i == compareNum) {
                compareCount++;
            }
        }
        return compareCount > (data.length >> 2) ? compareNum : -1;
    }
}
