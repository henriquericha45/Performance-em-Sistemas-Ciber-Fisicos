import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Produtor implements Runnable {
    private static Random gerador = new Random();
    private ArrayList<Integer> lista;
    Semaphore vazio;
    Semaphore cheio;
    Semaphore mutex;

    public Produtor(ArrayList<Integer> lista, Semaphore vazio, Semaphore cheio, Semaphore  mutex) {
        this.lista = lista;
        this.vazio = vazio;
        this.cheio = cheio;
        this.mutex = mutex;
    }

    @Override
    public void run() {

        int item;   
        while (true) {
            item = gerador.nextInt(100);
            try {
                vazio.acquire();
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Item Produzido: " + item);
            lista.add(item);
            mutex.release();
            cheio.release();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }     
    }
    
}
