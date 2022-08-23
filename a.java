final class a implements Runnable {
    public static int a = 0;
    
    public static long b = 5000000000L;
    
    public static int c = 8;
    
    public static double[] d;
    
    private final int e;
    
    public a(int paramInt) {
      if (d == null)
        d = new double[c * a]; 
      d[c * paramInt] = 0.0D;
      this.e = paramInt;
    }
    
    public final void run() {
      long l1 = b / a;
      long l2;
      long l3 = (l2 = this.e * l1) + l1;
      double d = (l2 % 2L == 0L) ? 1.0D : -1.0D;
      long l4;
      for (l4 = l2; l4 < l3; l4++) {
        d[c * this.e] = d[c * this.e] + d / (2L * l4 + 1L);
        d = -d;
      } 
    }
  }