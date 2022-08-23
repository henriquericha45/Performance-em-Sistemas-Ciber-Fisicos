public class Exemplo1 {

    public static void main(String args[]) {
        long t0 = System.nanoTime();
        for(int i=0; i<5_000_000; i++){
            System.out.print("x");
        }
        long tf = System.nanoTime();
        System.out.println((tf-t0)/1e9);
    }

}