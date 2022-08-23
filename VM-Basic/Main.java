//
// Arquitetura von Neumann Básica
// PSCF
// Prof. Luiz Lima Jr.
//
// IO <- CPU <-> RAM
//
public class Main {

    public static void main(String[] args) {

        System.out.println("* Arquitetura von Neumann Básica - PSCF\n");

        // cria componentes da arquitetura

        IO io = new IO(System.out);
        RAM ram = new RAM(128);
        CPU cpu = new CPU(io, ram);
        Cache cache = new Cache(8, ram);

        try {

            // carrega "programa" na memória

            ram.Write(1, 0);
            ram.Write(2, 127);

            cpu.Run(1);

        } catch (EnderecoInvalido e) {
            System.err.println("Erro: " + e);
        }
    }
}

