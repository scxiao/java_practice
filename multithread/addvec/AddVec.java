
public class AddVec extends Thread {
    private double[] a;
    private double[] b;
    private double[] ret;

    private int tid;
    private int threadNum;

    AddVec(double[] a, double[] b, double[] c, int tNum, int tIdx)
    {
        this.a = a;
        this.b = b;
        this.ret = c;
        this.tid = tIdx;
        this.threadNum = tNum;
    }

    public void run()
    {
        int totalNum = a.length;
        int thrdNum = (totalNum + threadNum - 1)/ threadNum;
        int start = tid * thrdNum;
        int end = (tid + 1) * thrdNum;
        end = (end > totalNum) ? totalNum : end;
        System.out.println("Thread " + tid + " calcs elements from " + start + " to " + end);
        for (int i = start; i < end; ++i)
        {
            ret[i] = b[i] + a[i];
        }
    }

    public void joinT()
    {
        try {
            this.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

