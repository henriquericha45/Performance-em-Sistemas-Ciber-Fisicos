public class RAM extends Memoria {
    private int capacidade;
    private final int[] dados;

    public RAM(int capacidade){
        super(capacidade);
        dados = new int[capacidade];
    }

    public int read(int endereco) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        return dados[endereco];
    }

    public void write(int endereco, int data) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        dados[endereco] = data;
    }

}
