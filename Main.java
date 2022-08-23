
public class Main {
  public static void main(String[] paramArrayOfString) throws InterruptedException {
    System.out.println("* CalcPI (Leibniz) - PROFESSOR");
    System.out.println("* PSCF - PUCPR");
    for (byte b1 = 0; b1 < paramArrayOfString.length; b1++) {
      if (paramArrayOfString[b1] == "-l") {
        a.b = Long.parseLong(paramArrayOfString[++b1]);
      } else if (paramArrayOfString[b1] == "-s") {
        a.c = Integer.parseInt(paramArrayOfString[++b1]);
      } else {
        a.a = Integer.parseInt(paramArrayOfString[b1]);
      } 
    } 
    if ((a.a = Runtime.getRuntime().availableProcessors()) > 256) {
      System.err.println("No. of threads must be in the range [1,256]");
      System.exit(2);
    } 
    if (a.c <= 0) {
      System.out.println("Space must be > 1!");
      System.exit(2);
    } 
    System.out.println("* Iteracoes = " + a.b);
    Thread[] arrayOfThread = new Thread[a.a];
    for (byte b2 = 0; b2 < a.a; b2++)
      arrayOfThread[b2] = new Thread(new a(b2)); 
    long l1 = System.nanoTime();
    for (byte b3 = 0; b3 < a.a; b3++)
      arrayOfThread[b3].start(); 
    double d = 0.0D;
    for (byte b4 = 0; b4 < a.a; b4++) {
      arrayOfThread[b4].join();
      d += a.d[a.c * b4];
    } 
    d *= 4.0D;
    long l2 = System.nanoTime() - l1;
    System.out.println("\nPI = " + d);
    System.out.println("Duracao = " + l2 / 1.0E9D + "s");
  }
}
