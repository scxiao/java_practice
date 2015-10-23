package impl;

import java.util.Random;

public class Matrix {
  private int rowNum, columnNum;
  private double[] matrix;
  private boolean rowMajor;
  private Random rd;
  private int threadNum;

  class ThreadForMultiply extends Thread {
    private Matrix a, b, c;
    private int index;
    private Thread t;

    ThreadForMultiply(Matrix a, Matrix b, Matrix c, int index) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.index = index;
    }

    public void run() {
      a.ThreadMultiply(b, c, index);
    }

    public void start() {
      t = new Thread(this);
      t.start();
    }

    public void joinT() {
      try {
        t.join();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public Matrix(int row, int column) {
    rowNum = row;
    columnNum = column;
    matrix = new double[row * column];
    rd = new Random();
    rowMajor = Boolean.TRUE;
    threadNum = 1;
  }

  public void setThreadNum(int num) {
    threadNum = num;
  }

  public Matrix(int row, int column, double[] iniValue) {
    rowNum = row;
    columnNum = column;
    matrix = new double[row * column];
    rowMajor = Boolean.TRUE;
    rd = new Random();

    for (int i = 0; i < row * column; i++) {
      matrix[i] = iniValue[i];
    }
  }

  public boolean setValue(boolean rowMajorFormat, double[] iniValue) {
    if (iniValue.length != rowNum * columnNum) {
      return Boolean.FALSE;
    }

    rowMajor = rowMajorFormat;

    for (int i = 0; i < rowNum * columnNum; i++) {
      matrix[i] = iniValue[i];
    }

    return Boolean.TRUE;
  }

  public void initialize() {
    int i;
    for (i = 0; i < rowNum * columnNum; i++) {
      matrix[i] = rd.nextDouble();
    }
  }

  // copy constructor
  public Matrix(Matrix m) {
    rowNum = m.rowNum;
    columnNum = m.columnNum;
    rd = new Random();
    matrix = new double[rowNum * columnNum];
    for (int i = 0; i < rowNum * columnNum; i++) {
      matrix[i] = m.matrix[i];
    }

    rowMajor = m.rowMajor;
  }

  public void print() {
    int i, j;
    for (i = 0; i < rowNum; i++) {
      for (j = 0; j < columnNum; j++) {
        int pos = i * columnNum + j;
        System.out.format("%f\t", matrix[pos]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public Matrix multiply(Matrix m) {
    // If current columnNum != m.rowNum, return null
    if (columnNum != m.rowNum) {
      return null;
    }

    // Allocate return matrix
    Matrix res = new Matrix(rowNum, m.columnNum);
    ThreadForMultiply[] t = new ThreadForMultiply[threadNum];

    int threadNo;
    for (threadNo = 0; threadNo < threadNum; threadNo++) {
      t[threadNo] = new ThreadForMultiply(this, m, res, threadNo);
      t[threadNo].start();
    }

    for (threadNo = 0; threadNo < threadNum; threadNo++) {
      t[threadNo].joinT();
    }

    return res;
  }

  void ThreadMultiply(Matrix b, Matrix res, int index) {
    if (columnNum != b.rowNum) {
      System.out.println("Error, cannot multiply matrix");
      return;
    }

    int rowsPerThread = rowNum / threadNum;
    int startRowNum = index * rowsPerThread;
    int endRowNum = (index + 1) * rowsPerThread;

    int i, j, k, pos;
    if (b.rowMajor == Boolean.TRUE) {
      for (i = startRowNum; i < endRowNum; i++) {
        for (j = 0; j < b.columnNum; j++) {
          double sum = 0.0;
          for (k = 0; k < columnNum; k++) {
            int pos1 = i * columnNum + k;
            int pos2 = k * b.columnNum + j;
            sum += matrix[pos1] * b.matrix[pos2];
          }
          res.matrix[i * b.columnNum + j] = sum;
        }
      }
    }
    else { // column major for m
      for (i = startRowNum; i < endRowNum; i++) {
        for (j = 0; j < b.columnNum; j++) {
          double sum = 0.0;
          for (k = 0; k < columnNum; k++) {
            int pos1 = i * columnNum + k;
            int pos2 = j * b.rowNum + k;
            sum += matrix[pos1] * b.matrix[pos2];
          }
          res.matrix[i * b.columnNum + j] = sum;
        }
      }
    }

    return;
  }

  public boolean equal(Matrix m) {
    if (rowNum != m.rowNum) {
      return Boolean.FALSE;
    }

    if (columnNum != m.columnNum) {
      return Boolean.FALSE;
    }

    int i, j;
    if (rowMajor == m.rowMajor) {
      for (i = 0; i < rowNum * columnNum; i++) {
        if (matrix[i] - m.matrix[i] > 0.0000001 ||
            matrix[i] - m.matrix[i] < -0.0000001) {
          return Boolean.FALSE;
        }
      }
    }
    else {
      for (i = 0; i < rowNum; i++) {
        for (j = 0; j < columnNum; j++) {
          int pos1 = i * columnNum + j;
          int pos2 = j * rowNum + i;
          if (matrix[pos1] - m.matrix[pos2] > 0.0000001 ||
              matrix[pos1] - m.matrix[pos2] < -0.0000001) {
            return Boolean.FALSE;
          }
        }
      }
    }

    return Boolean.TRUE;
  }
}

