//
// Experimentos Threads e Memória Compartilhada
// Prof. Luiz Lima Jr.
//

package professor;

class Contador implements Runnable {
    // variável compartilhada (static)
    static public int cont = 0;
    static public volatile int vez = 0;
    private int id;

    Contador(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " iniciado");
        for (int i=0; i<50_000_000; ++i) {
            while(vez!=id){}
            cont++;
            vez = (vez+1) % 4;
        }
    }
}

public class ExpThreads {

    public static final int N = 4;  // número de threads

    public static void main(String[] args) throws InterruptedException {
        Thread [] cont = new Thread[N];

        for (int i=0; i<N; ++i) {
            cont[i] = new Thread(new Contador(i));
            cont[i].start();
        }

        // aguarda fim dos threads
        for (int i=0; i<N; ++i)
            cont[i].join();

        System.out.println("* Contador = " + Contador.cont);
    }

}
