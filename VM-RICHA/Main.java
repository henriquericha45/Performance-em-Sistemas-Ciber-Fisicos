public class Main {
    public static void main(String[] args) {
        
        try {

            IO io = new IO(System.out);
            RAM ram = new RAM(128);
            Cache cache = new Cache(8, ram);
            CPU cpu = new CPU(ram, io);

            final int inicio = 0;

            ram.write(inicio, 15); //A = 15
            ram.write(inicio+1, 30); //B = 30

            System.out.println(ram.read(1));
            

            cpu.run(inicio);

        } catch(EnderecoInvalido e) {
            System.err.println("Erro: " + e);
        }

        











    }
}
