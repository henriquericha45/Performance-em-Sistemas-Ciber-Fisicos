public class Cache extends Memoria{
    private int[] dados;
    private RAM ram;
    private int enderecoInicial;
    private boolean modificado;

    public Cache(int capacidade, RAM ram) {
        super(capacidade);
        dados = new int[capacidade];
        this.ram = ram;
        this.modificado = false;
        this.enderecoInicial = 0;
    }

    int Read(int endereco) throws EnderecoInvalido {
        
        if(endereco < (enderecoInicial+dados.length-1) && endereco >= enderecoInicial){
            return dados[endereco-enderecoInicial];
        } else {
            pullCache(endereco);
            return Read(endereco);
        }
    }

    void Write(int endereco, int valor) throws EnderecoInvalido {
        if(endereco < (enderecoInicial+dados.length-1) && endereco >= enderecoInicial){
            dados[endereco-enderecoInicial] = valor;
            modificado = true;
        } else {
            pullCache(endereco);
            Write(endereco, valor);
        }
    }

    public void pushCache() throws EnderecoInvalido {
        for(int i=0; i<dados.length; i++){
            ram.Write(enderecoInicial+i, dados[i]);
        }
    }

    public void pullCache(int startAddress) throws EnderecoInvalido {
        if(modificado){
            pushCache();
        }
        this.enderecoInicial = enderecoInicial;
        for(int i=0; i<dados.length; i++){
            dados[i] = ram.Read(enderecoInicial+i);
        }
    }
}
