package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr= {4,12,13,4,3,42,33,1,43,44};
        selectSort(arr);
    }

    //选择排序方法
    public static void selectSort(int [] array) {
        //需要最小值的下标和最小值的变量
        int minIndex=0;
        int min=0;
        //需要循环i-1次
        for(int i=0;i<array.length-1;i++) {
            minIndex=i;
            min=array[i];
            //从i+1开始寻找最小值
            for(int j=i+1;j<array.length;j++) {
                //在这里根据从小到大 或者 从大到小,改变符号即可
                if(min>array[j]) { //说明这个比给定的最小值还小
                    min=array[j]; //重置最小值
                    minIndex=j; //重置minIndex
                }
            }
            //判断最小值的下标有没有变化
            if(minIndex!=i) {
                //变化就交换
                array[minIndex]=array[i];
                array[i]=min;
            }
            System.out.println("第"+(i+1)+"轮后:");
            System.out.println(Arrays.toString(array));
        }
    }
}
