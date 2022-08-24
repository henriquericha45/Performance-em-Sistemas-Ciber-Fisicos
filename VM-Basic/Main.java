//
// Arquitetura von Neumann Básica
// PSCF
// Prof. Luiz Lima Jr.
//
// IO <- CPU <-> RAM
//
public class Main {

    public static void main(String[] args) {

        IO io = new IO(System.out);

        io.Output("* Arquiterura von Neumann Básica - PSCF\n");
        System.out.println("* Arquiterura von Neumann Básica - PSCF\n");
        System.out.println("* Arquitetura von Neumann Básica - PSCF\n");

        // cria componentes da arquitetura

        
        RAM ram = new RAM(128);
        Cache cache = new Cache(8, ram);
        CPU cpu = new CPU(cache, io);

        try {

            final int inicio = 10;

            // carrega "programa" na memória
            ram.Write(inicio, 118);
            ram.Write(inicio+1, 126);

            // executa programa

            cpu.Run(inicio);

        } catch (EnderecoInvalido e) {
            System.err.println("Erro: " + e);
        }
    }
}

