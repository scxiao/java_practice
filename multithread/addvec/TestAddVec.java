import java.util.Random;

public class TestAddVec {
    static void init(double[] a)
    {
        Random rd = new Random();
        for (int i = 0; i < a.length; ++i)
        {
            a[i] = rd.nextDouble();
        }
    }

    static void print(String name, double[] a)
    {
        System.out.format(name + " = {");
        for (int i = 0; i < a.length; ++i)
        {
            System.out.format("%f", a[i]);
            if (i < a.length - 1)
            {
                System.out.format(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Usage: java TestAddVec vec_size threadNum");
            return;
        }

		int vecSize = Integer.parseInt(args[0]);
		int thrdNum = Integer.parseInt(args[1]);

        
        double[] a = new double[vecSize];
        double[] b = new double[vecSize];
        double[] c = new double[vecSize];

        init(a);
        init(b);

        AddVec[] t = new AddVec[thrdNum];

        for (int tid = 0; tid < thrdNum; ++tid)
        {
            t[tid] = new AddVec(a, b, c, thrdNum, tid);
            t[tid].start();
        }

        for (int tid = 0; tid < thrdNum; ++tid)
        {
            t[tid].joinT(); 
        }

        print("a", a);
        print("b", b);
        print("c", c);
    }
}

