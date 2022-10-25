package Thread;

class Contador implements Runnable {
    public static int count = 0;
    public static boolean ocupada = false;
    @Override
    public void run() {
        for(int i=0; i<100_000; i++) {
            while(ocupada) {}
            ocupada = true;
            count++;
            ocupada = false;
        }

    }
}

public class Exercicio {
    public static void main(String[] args) throws InterruptedException {
        Thread c1 = new Thread(new Contador());
        Thread c2 = new Thread(new Contador());
        Thread c3 = new Thread(new Contador());
        Thread c4 = new Thread(new Contador());
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        c1.join();
        c2.join();
        c3.join();
        c4.join();
        System.out.println(Contador.count);
        
    }
}