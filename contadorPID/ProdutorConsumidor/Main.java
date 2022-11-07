import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Semaphore vazio = new Semaphore(20);
        Semaphore cheio = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Thread produtor = new Thread(new Produtor(lista, vazio, cheio, mutex));
        Thread consumidor = new Thread(new Consumidor(lista, vazio, cheio, mutex));
        produtor.start();
        consumidor.start();
        
    }
}