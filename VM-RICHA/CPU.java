public class CPU {
    private int programCounter = 0;
    private final Memoria memoria;
    private final IO io;
    private int registradorA = 0;
    private int registradorB = 0;
    private int registradorC = 0;

    public CPU(Memoria memoria, IO io) {
        this.memoria = memoria;
        this.io = io;
    }

    public void run(int endereco) throws EnderecoInvalido {
        programCounter = endereco;

        registradorA = memoria.read(programCounter++);
        registradorB = memoria.read(programCounter++);

        System.out.println("A: " + registradorA);
        System.out.println("B: " + registradorB);


        registradorC = 1;
        while(registradorA <= registradorB) {
            memoria.write(registradorA, registradorC);
            io.output("> " + registradorA + " -> " + registradorC + "\n");
            ++registradorC;
            ++registradorA;
        }
    }
}