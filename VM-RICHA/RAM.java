public class RAM extends Memoria {
    
    private final int[] dados;

    public RAM(int capacidade){
        super(capacidade);
        dados = new int[capacidade];
    }

    @Override
    public int read(int endereco) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        return dados[endereco];
    }

    @Override
    public void write(int endereco, int data) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        dados[endereco] = data;
    }

}
