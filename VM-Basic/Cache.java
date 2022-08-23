public class Cache extends Memoria{
    private int[] dados;
    private RAM ram;

    public Cache(int capacidade, RAM ram) {
        super(capacidade);
        dados = new int[capacidade];
        this.ram = ram;
    }

    int Read(int endereco) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        return dados[endereco];
    }

    void Write(int endereco, int valor) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        dados[endereco] = valor;
        
    }
}
