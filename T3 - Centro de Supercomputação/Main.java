import java.util.concurrent.Semaphore;

class Main {

    public static final int N = 10;  // número de threads
    public static void main(String[] args) throws InterruptedException {

        Thread [] empresaA = new Thread[N];
        Thread [] empresaB = new Thread[N];
        Semaphore vazio = new Semaphore(10);
        Semaphore cheio = new Semaphore(3);
        Semaphore mutex = new Semaphore(1);
        Listas lista = new Listas();

        // Inicializa os funcionarios da empresa A
        for (int i=0; i<N; ++i) {
            Funcionario funcionario = new Funcionario("F" + (i+1), 'A', mutex, vazio, cheio);
            empresaA[i] = new Thread(funcionario);
            Listas.addToFuncionarios(funcionario);
        }

        // Inicializa os funcionarios da empresa B
        for (int i=0; i<N; ++i) {
            Funcionario funcionario = new Funcionario("F" + (i+1), 'B', mutex, vazio, cheio);
            empresaB[i] = new Thread(funcionario);
            Listas.addToFuncionarios(funcionario);
        }

        // Inicializa as threads da empresa A
        for (int i=0; i<N; ++i) {
            empresaA[i].start();
        }

        // Inicializa as threads da empresa B
        for (int i=0; i<N; ++i) {
            empresaB[i].start();
        }

        // Inicializa a thread do CSC
        Thread csc = new Thread(new CSC(vazio, cheio, mutex));
        csc.start();
/* 
        while(true){
            System.out.println("lista de espera: ");
            Listas.imprimeListaDeEspera();
            System.out.println("lista de funcionarios: ");
        }
        
        // Espera as threads da empresa A terminarem
        for (int i=0; i<N; ++i) {
            empresaA[i].join();
        }

        // Espera as threads da empresa B terminarem
        for (int i=0; i<N; ++i) {
            empresaB[i].join();
        }
        */
    }


}