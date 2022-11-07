import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Consumidor implements Runnable {
    private ArrayList<Integer> lista;
    private Semaphore vazio;
    private Semaphore cheio;
    private Semaphore mutex;

    public Consumidor(ArrayList<Integer> lista, Semaphore vazio, Semaphore cheio, Semaphore  mutex) {
        this.lista = lista;
        this.vazio = vazio;
        this.cheio = cheio;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while(true){
            try {
                mutex.acquire();
                cheio.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(lista.size() > 0) {
                System.out.println("Item Removido: " + lista.get(0));
                lista.remove(0);
            }
            
            mutex.release();
            vazio.release();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
