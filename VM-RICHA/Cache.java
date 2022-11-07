public class Cache extends Memoria {

    private final int[] dados;
    private RAM ram;
    private int enderecoInicial;
    private boolean modificado;

    public Cache(int capacidade, RAM ram) throws EnderecoInvalido {
        super(capacidade);
        dados = new int[capacidade];
        this.ram = ram;
        this.enderecoInicial = 0;
        this.modificado = false;
        pullCache(enderecoInicial);
    }

    @Override
    public int read(int endereco) throws EnderecoInvalido {
        if(endereco < (this.enderecoInicial + capacidade-1) && endereco >= this.enderecoInicial) {
            return dados[endereco - enderecoInicial];
        } else {
            pullCache(endereco);
            return read(endereco);
        }
    }

    @Override
    public void write(int endereco, int data) throws EnderecoInvalido {
        if(endereco < (this.enderecoInicial + capacidade-1) && endereco >= this.enderecoInicial){
            dados[endereco - enderecoInicial] = data;
            modificado = true;
        } else {
            pullCache(endereco);
            write(endereco, data);
        }
    }

    public int cacheHit(int endereco) {
        
        return dados[endereco];
    }

    public void cacheMiss() {
        
    }



    public void pushCache() throws EnderecoInvalido {
        for(int i=0; i < capacidade; i++) {
            ram.write(enderecoInicial+1, dados[i]);
        }
    }

    public void pullCache(int enderecoInicial) throws EnderecoInvalido {
        if(modificado) {
            pushCache();
        }
        this.enderecoInicial = enderecoInicial;
        if(enderecoInicial + capacidade > ram.capacidade) {
            enderecoInicial = ram.capacidade-capacidade;
            this.enderecoInicial = enderecoInicial;
        }
        for(int i=0; i<capacidade; i++) {
            dados[i] = ram.read(enderecoInicial+1);
        }
    }

    
    
    
}
