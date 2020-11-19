import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args){
//        sort();
        arrayCopy();
    }

    // 创建数组
    public static void demo01(){
        // 声明数组
        int[] arr;
        // 创建数组空间
        arr = new int[5];

        // 创建数组的方法
        // 第一种创建并声明
        int[] arr1 = new int[2];
        // 第二种，创建声明并赋值
        int[] arr2 = new int[]{1,2,3};
        // 第三种，直接初始化
        int[] arr3 = {1,2,3,4};
    }

    /*
     数组排序
        写出某种排序算法
            冒泡排序
            选择排序
            插入排序
            快速排序
        排序算的时间复杂度（空间复杂度）
            衡量一个数据结构是否合适的衡量标准
        排序算法的稳定性
            排序之后的值跟排序之前的值位置是否发生变化
     */
    public static void sort(){
        int[] arr = {41,8,6,4,2,5,7,33,44,9};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(maopao(arr)));
        System.out.println(Arrays.toString(chooseSort(arr)));
    }

    // 冒泡排序，由小到大
    private static int[] maopao(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        return arr;
    }

    // 选择排序，由小到大
    private static int[] chooseSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        return arr;
    }

    /*
        二维数组
            必须要给定一维数组的长度
            一般用于矩阵运算
     */
    public static void twoArr(){
        // 一维数组的定义
        int[] arr = new int[6];
        // 二维数组的定义
        int[][] arr1 = new int[3][];

        // 给二维数组赋值
        arr1[0] = new int[5];
        arr1[1] = new int[4];
        arr1[2] = new int[6];

        // 二维数组第一个数组赋值
        arr1[0][0] = 1;
        arr1[0][1] = 1;
        arr1[0][2] = 1;
        arr1[0][3] = 1;
        arr1[0][4] = 1;
    }

    // 使用 java.lang.System 了中的arraycopy方法
    public static void arrayCopy(){
        int[] arr = new int[]{1,2,3,4,5};
        int[] cArr = new int[3];
        // 被复制对象，开始复制下标，赋值对象，开始存放下标，复制长度
        System.arraycopy(arr,1,cArr,1,2);
        System.out.println(Arrays.toString(cArr));
    }
}
