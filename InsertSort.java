package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {10,5,3,7,6};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //第二轮
            int insertVal = arr[i];
            int insertIndex = i - 1;//既arr[1]的前面这个数的下标
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//将arrIndex后移
                insertIndex--;
            }
            if (insertVal + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("第" + i + "轮插入后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
