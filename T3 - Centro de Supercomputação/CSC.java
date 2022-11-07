import java.util.concurrent.Semaphore;

public class CSC implements Runnable {
    private Semaphore vazio;
    private Semaphore cheio;
    private Semaphore mutex;

    public CSC(Semaphore vazio, Semaphore cheio, Semaphore mutex) {
        this.vazio = vazio;
        this.cheio = cheio;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while(true) {
            try {

                mutex.acquire();
                cheio.acquire();
                Listas.transfereEsperaParaUsando();
                mutex.release();
                
                Thread.sleep(5000, 10000);

                mutex.acquire();
                Listas.removeFromUsando();
                cheio.release();
                mutex.release();

                

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }


    
}



