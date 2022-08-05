public class FlowShop {
    int jobNumbers;//作业数
    int f1Time;//机器1完成处理时间
    int finishTime;//完成时间和
    int bestTime;//当前最优值
    int[][] jobMachineTime;//各作业所需的处理时间
    int[] curEx;//当前作业调度
    int[] bestEx;//当前最优作业调度
    int[] f2Times;//机器2完成处理时间

    public FlowShop(int n, int[][] m) {
        this.jobNumbers = n;
        this.jobMachineTime = m;
        f1Time = 0;
        finishTime = 0;
        bestTime = 10000;//给定初始值
        bestEx = new int[n + 1];
        curEx = new int[n + 1];
        //初始化，x[i]为原始排序
        for (int i = 1; i <= n; i++) {
            curEx[i] = i;
        }
        f2Times = new int[n + 1];
    }

    public void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public void backtrack(int i) {
        if (i > jobNumbers) {
            for (int j = 1; j <= jobNumbers; j++)
                bestEx[j] = curEx[j];
            bestTime = finishTime;
        } else {
            for (int j = i; j <= jobNumbers; j++) {
                f1Time += jobMachineTime[curEx[j]][1];//作业x[j]在第一台机器的时间
                f2Times[i] = ((f2Times[i - 1] > f1Time) ? f2Times[i - 1] : f1Time) + jobMachineTime[curEx[j]][2];//f2[i]等于f2[i-1]和f1中较大者加上作业x[j]在第2台机器的时间
                finishTime += f2Times[i];
                if (finishTime < bestTime) {
                    swap(curEx, i, j);
                    backtrack(i + 1);
                    swap(curEx, i, j);
                }
                f1Time -= jobMachineTime[curEx[j]][1];
                finishTime -= f2Times[i];
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] m = {{0, 0, 0},
                     {0, 2, 1},
                     {0, 3, 1},
                     {0, 2, 3}};//m的下标从1开始，因此第一行的0和每一行第一列的0无用
        FlowShop f = new FlowShop(n, m);
        f.backtrack(1);
        System.out.println("最优批处理作业调度顺序为：");
        for (int i = 1; i <= n; i++)
            System.out.print(f.bestEx[i] + " ");
        System.out.println();
        System.out.println("最优调度所需的最短时间为：" + f.bestTime);
    }
}
