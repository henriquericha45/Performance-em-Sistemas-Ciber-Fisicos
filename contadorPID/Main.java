
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
            System.out.println("Contador2: " + i);
            try {
                Thread.sleep((long)(100));
            } catch (InterruptedException e) {}
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("PID: " + ProcessHandle.current().pid());
        System.out.println("PID PAI: " + ProcessHandle.current().parent().get().pid());

        int N = Integer.parseInt(args[0]);
        //int N = 10;
        float t = Float.parseFloat(args[1]);
        //float t = 0.2F;

        for(int i=1; i<N; i++) {
            System.out.println(i);
            Thread.sleep((long)(t*1_000));

        }
    }
}