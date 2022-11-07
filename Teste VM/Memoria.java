abstract class Memoria {
    private int capacidade;

    public Memoria(int capacidade) {
        this.capacidade = capacidade;
    }
    
    abstract int read(int endereco);
    abstract void write(int endereco, int data);
    
}
