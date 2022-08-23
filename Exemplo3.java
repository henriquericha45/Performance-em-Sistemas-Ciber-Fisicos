public class Exemplo3 {
    public static void main(String[] args) {
        
        double num = 1.0;
        double pi = 0.0;

        long t0 = System.nanoTime();

        for(long i=0; i<5_000_000_000L; ++i){
            pi += num / (2 * i + 1);
            num = -num;
        }
        pi *= 4;

        long tf = System.nanoTime();
        System.out.println((tf-t0)/1e9);
        System.out.println("\nPI= " + pi);
    }
}
