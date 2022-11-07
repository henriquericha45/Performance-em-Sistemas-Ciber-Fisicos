import java.util.Random;
import java.util.concurrent.Semaphore;

public class CSC implements Runnable {
    private Semaphore vazio;
    private Semaphore cheio;
    private Semaphore mutex;
    private Random random;

    public CSC(Semaphore vazio, Semaphore cheio, Semaphore mutex) {
        this.vazio = vazio;
        this.cheio = cheio;
        this.mutex = mutex;
        this.random = new Random();
    }

    @Override
    public void run() {
        while(true) {
            try {
                mutex.acquire();
                cheio.acquire();
                
                Listas.transfereEsperaParaUsando();
                mutex.release();

                Thread.sleep(random.nextInt(5000) + 5000);

                mutex.acquire();
                Listas.removeFromUsando();
                mutex.release();

                cheio.release();

                

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }


    
}



