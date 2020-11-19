package algorithm;

/*
    旋转
    1. 对一个正方形数组进行旋转
        * 第一步分成有多少圈，然后对圈进行旋转
        * 第二步对每圈数据分组，各个组的数字位置
        * 循环分组，对组中数据进行替换

    2. 对一个正方形/长方形 按照 Z 的顺序进行打印
        比如： 1 2 3 4 5
               6 7 8 9 10
               打印结果为：1 2 6 7 3 4 8 9 5 10
        * 第一步，设定一个直线，打印该直线上的左右的数字
        * 第二步，利用x、y划分多个直线，划分规则如下
            * x和y每次+1,
            * x向右走，到达边界后，向下走
            * y向下走，到达边界后，向右走
        * 第三步，每次打印直线上面数据的时候，循环 从上到下 和 从下到上
 */
public class Demo01 {
    public static void main(String[] args) {
        int[][] squareArr = {
                {10,11,12,13},
                {20,21,22,23},
                {30,31,32,33},
                {40,41,42,43},
        };
        square(squareArr);
    }

    // 题目一：旋转正方体
    public static void square(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        // 定义左上角坐标
        int x1 = 0, y1 = 0;

        // 定义右下角坐标
        int x2 = arr.length - 1;
        int y2 = x2;

        // 循环有多少圈
        while(x1 < x2){
            squareRotate(arr, x1++,y1++,x2--,y2--);
        }

        System.out.println("===============");

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    // 正方体旋转方法
    private static void squareRotate(int[][] arr, int x1, int y1, int x2, int y2){
        int tmp = 0;

        // 将旋转分组，循环有多少组
        for (int i = 0; i < (x2 - x1); i++) {
            // 第一个位置的坐标：x1, y1 + i
            // 第二个位置的坐标：x1 + i, y2
            // 第三个位置的坐标：x2, y2 - i
            // 第四个位置的坐标：x2 - i, y1

            // 保存第一个位置
            tmp = arr[x1][y1 + i];
            // 替换第一个位置(被第四个位置替换)
            arr[x1][y1 + i] = arr[x2 - i][y1];
            // 替换第四个位置(被第三个位置替换)
            arr[x2 - i][y1] = arr[x2][y2 - i];
            // 替换第三个位置(被第二个位置替换)
            arr[x2][y2 - i] = arr[x1 + i][y2];
            // 替换第二个位置(被第一个位置替换)
            arr[x1 + i][y2] = tmp;
        }
    }
}
