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

    @Override
    int Read(int endereco) throws EnderecoInvalido {
        if(endereco < (this.enderecoInicial + dados.length-1) && endereco >= this.enderecoInicial){
            return dados[endereco - this.enderecoInicial];
        } else {
            pullCache(endereco);
            return Read(endereco);
        }
    }

    @Override
    void Write(int endereco, int valor) throws EnderecoInvalido {
        if(endereco < (this.enderecoInicial + dados.length-1) && endereco >= this.enderecoInicial) {
            dados[endereco-enderecoInicial] = valor;
            modificada = true;
        } else {
            pullCache(endereco);
            Write(endereco, valor);
        }
    }

    public void pushCache() throws EnderecoInvalido {
        for(int i=0; i < capacidade; i++) {
            ram.Write(enderecoInicial+1, dados[i]);        
        }
    }

    public void pullCache(int enderecoInicial) throws EnderecoInvalido{
        if(modificada){
            pushCache();
        }
        this.enderecoInicial = enderecoInicial;
        for(int i=0; i< capacidade; i++) {
            dados[i] = ram.Read(enderecoInicial+1);
        }
    }

    // ------------------------------
    // pensar no chache miss ( algo em falta na cache que vai precisar ser buscada na RAM )
    // ------------------------------
    
}
