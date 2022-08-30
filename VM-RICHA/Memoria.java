
class EnderecoInvalido extends Exception{
    public final int endereco;
    public EnderecoInvalido(int endereco) {
        super();
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Endereco " + endereco + " invalido!";
    }
}

abstract class Memoria {
    private int capacidade;

    public Memoria(int capacidade) {
        this.capacidade = capacidade;
    }

    public void VerificaEndereco(int endereco) throws EnderecoInvalido {
        if (endereco < 0 || endereco >= capacidade) {
            throw new EnderecoInvalido(endereco);
        }
    }

    public abstract int read(int endereco) throws EnderecoInvalido;
    public abstract void write(int endereco, int data) throws EnderecoInvalido;
}
