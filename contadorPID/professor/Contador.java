package professor;

//
// PSCF
// Prof. Luiz Lima Jr.
// Contador
//

public class Contador {

    public static void main(String[] args) throws InterruptedException {

        if (args.length < 2) {
            System.err.println("Faltaram N e T!");
            return;
        }

        int N = Integer.parseInt(args[0]);
        float T = Float.parseFloat(args[1]);

        long meu_pid = ProcessHandle.current().pid();
        System.out.println("PID (pai) = " + ProcessHandle.current().parent().get().pid());

        for (int i=1; i<=N; ++i) {
            System.out.println(meu_pid + "> " + i);
            Thread.sleep((long)(T*1000));
        }
    }
}
