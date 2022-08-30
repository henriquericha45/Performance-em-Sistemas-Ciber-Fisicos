public class Main {
    public static void main(String[] args) {
        
        IO io = new IO(System.out);
        RAM ram = new RAM(128);
        Cache cache = new Cache(8, ram);
        CPU cpu = new CPU(cache, io);

        try {

            final int inicio = 10;

            ram.write(inicio, 0);
            ram.write(inicio+1, 7);

            cpu.run(inicio);

        } catch(EnderecoInvalido e) {
            System.err.println("Erro: " + e);
        }

        











    }
}
