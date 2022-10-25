package Semaforo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;


class Produtor implements Runnable {

    private ArrayList<Integer> lista;   
    private Semaphore mutex;
    private Semaphore cheio;
    private Semaphore vazio;

    public Produtor(Semaphore mutex, Semaphore cheio, Semaphore vazio, ArrayList<Integer> lista) {
        this.mutex = mutex;
        this.cheio = cheio;
        this.vazio = vazio;
        this.lista = lista;
    }

    @Override
    public void run() {
        Random r = new Random();
        int item;
        while(true) {
            item = r.nextInt(1000);
            try {
                vazio.acquire();
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            lista.add(item);
            mutex.release();
            cheio.release();
        }        
    }
}

class Consumidor implements Runnable {


    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}

public class Main {
    public static void main(String[] args) {
        
        Semaphore semaforo = new Semaphore(1);
        ArrayList<Integer> buffer = new ArrayList<Integer>();

    }
}
