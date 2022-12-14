//
// Arquitetura von Neumann Básica
// Prof. Luiz A. de P. Lima Jr.
// PSCF - PUCPR
//
// CPU
//
public class CPU {
    // Registradores da CPU
    private int PC = 0;     // program counter
    private int regA = 0;   // registrador A
    private int regB = 0;   // registrador B
    //private int regC = 0;   // registrador C
    private final Memoria mem;
    private final IO es;

    public CPU(Memoria mem, IO es) {
        this.es = es;
        this.mem = mem;
    }
    /*
    public void Run(int ender) throws EnderecoInvalido {
        PC = ender;

        // lê "programa" da memória
        regA = mem.Read(PC++);
        regB = mem.Read(PC++);

        // roda o programa
        regC = 1;   // contador
        while (regA <= regB) {
            mem.Write(regA, regC);
            es.Output("> " + regA + " -> " + regC + "\n");
            ++regC;
            ++regA;
        }
    }
    */
    public void Run(int endereco) throws EnderecoInvalido {
        PC = endereco;
        es.Output("Executing program at address " + PC);

        while(mem.Read(PC) != -1){
            int regA = mem.Read(PC);
            ++PC;
            int regB = mem.Read(PC);
            ++PC;
            int regC = mem.Read(PC);
            ++PC;

            int counter = 0;
            for(int i=0; i<=(regB-1); i++){
                es.Output(i);
                counter += 1;
                mem.Write(i, counter);
                es.Output(i + " -> " + counter + "\n");
            }
        }


    }

}
