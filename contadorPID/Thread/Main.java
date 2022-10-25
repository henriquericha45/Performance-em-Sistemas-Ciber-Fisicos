package Thread;

class Contador1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Contador1: " + i);
            try {
                Thread.sleep((long)(500));
            } catch (InterruptedException e) {}
        }
    }
}

class Contador2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("    Contador2: " + i);
            try {
                Thread.sleep((long)(100));
            } catch (InterruptedException e) {}
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread c1 = new Thread(new Contador1());
        Thread c2 = new Thread(new Contador2());
        c1.start();
        c2.start();
        
        c1.join();
        c2.join();
        System.out.println("FIM!");
    }
}

// asdadada