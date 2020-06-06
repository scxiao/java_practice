import impl.Matrix;

public class TestMatrixMul {
  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("Usage: java TestMatrixMul m n k threadNum");
      return;
    }

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);
    int threadNum = Integer.parseInt(args[3]);

    Matrix a = new Matrix(m, n);
    double[] iniValueA = new double[m * n];
    int i;
    for (i = 0; i < m * n; i++) {
      iniValueA[i] = 1.0 * i;
    }
    a.setValue(Boolean.TRUE, iniValueA);
    a.initialize();

    Matrix b = new Matrix(n, k);
    double[] iniValueB = new double[n * k];
    for (i = 0; i < n * k; i++) {
      iniValueB[i] = 1.0;
    }
    b.setValue(Boolean.FALSE, iniValueB);
    b.initialize();

    Matrix[] c = new Matrix[threadNum + 1];
    for (int threadNo = 1; threadNo <= threadNum; threadNo *= 2) {
      a.setThreadNum(threadNo);
      long startTime = System.nanoTime();
      c[threadNo] = a.multiply(b);
      long endTime = System.nanoTime();
      System.out.println("TheadNum: " + threadNo + ", Elapsed time = " + (endTime - startTime) / 1000000 + " ms");
    }

    for (i = 2; i <= threadNum; i *= 2) {
      if (c[1].equal(c[i]) == Boolean.FALSE) {
        System.out.println("Computation error in thread: " + i);
      }
    }

    return;
  }
}

