public class Exemplo2 {
    
    public static void main(String args[]){
        int n = 0;

        long t0 = System.nanoTime();

        for(long i=0; i<5_000_000_00; i++){
            n++;
        }

        long tf = System.nanoTime();

        System.out.println((tf-t0)/1e9);

        System.out.println(n);
    }

}
