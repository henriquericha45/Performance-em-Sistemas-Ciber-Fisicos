import java.util.Random;
import java.util.concurrent.Semaphore;

public class Funcionario  implements Runnable {
    private String nome;
    private char empresa;
    private Random random = new Random();
    private Semaphore mutex;
    private Semaphore vazio;
    private Semaphore cheio;

    public Funcionario() {}

    public Funcionario(String nome, char empresa, Semaphore mutex, Semaphore vazio, Semaphore cheio) {
        this.nome = nome;
        this.empresa = empresa;
        this.mutex = mutex;
        this.vazio = vazio;
        this.cheio = cheio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getEmpresa() {
        return empresa;
    }

    public void setEmpresa(char empresa) {
        this.empresa = empresa;
    }

    public void imprimeTentativa() {
        System.out.println(this.nome + " [" + this.empresa + "] tentando acesso");
    }

    public void imprimeAcesso() {
        System.out.println("+ " + this.nome + " [" + this.empresa + "] acessou");
    }

    public void imprimeTermino() {
        System.out.println("- " + this.nome + " [" + this.empresa + "] terminou acesso");
    }

    public void run() {
        int funcionarioEscolhido;
        while(true) {            
            try {
                funcionarioEscolhido = random.nextInt(10);
                if(funcionarioEscolhido == 0) {
                    vazio.acquire();
                    mutex.acquire();
                    
                    // Zona de Risco
                    imprimeTentativa();
                    Listas.addToEspera(this);

                    mutex.release();
                    cheio.release();
                    Thread.sleep(3000, 5000);
                }
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}
