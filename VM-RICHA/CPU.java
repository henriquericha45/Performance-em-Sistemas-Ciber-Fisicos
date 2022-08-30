public class CPU {
    private int PC;
    private final Memoria memoria;
    private final IO io;

    public CPU(Memoria memoria, IO io) {
        this.memoria = memoria;
        this.io = io;
    }

    public void run(int endereco) throws EnderecoInvalido {
        PC = endereco;

        io.output("Executando programa no endereco " + PC);

        while(memoria.read(PC) != -1) {

        }


    }


}