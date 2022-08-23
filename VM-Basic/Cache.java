public class Cache extends Memoria{
    private int[] dados;
    private RAM ram;
    private int enderecoInicial;
    private boolean modificada;

    public Cache(int capacidade, RAM ram) {
        super(capacidade);
        dados = new int[capacidade];
        this.ram = ram;
        this.enderecoInicial = 0;
        this.modificada = false;
    }

    int Read(int endereco) throws EnderecoInvalido {

        VerificaEndereco(endereco);
        if(endereco < (this.enderecoInicial + dados.length-1) && endereco >= this.enderecoInicial){
            return dados[endereco - this.enderecoInicial];
        }
        // nao ta na cache
        return dados[endereco];
    }

    void Write(int endereco, int valor) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        dados[endereco] = valor;
    }

    // ------------------------------
    // pensar no chache miss ( algo em falta na cache que vai precisar ser buscada na RAM )
    // ------------------------------
    
}
