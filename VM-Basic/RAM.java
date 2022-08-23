//
// Arquitetura von Neumann Básica
// Prof. Luiz A. de P. Lima Jr.
// PSCF - PUCPR
//
// RAM (estende Memoria)
//
public class RAM extends Memoria {

    private final int [] dados;

    public RAM(int W) {     // W é a capacidade da memória em "words"
        super(W);
        dados = new int[W];
    }

    @Override
    public int Read(int endereco) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        return dados[endereco];
    }

    @Override
    public void Write(int endereco, int valor) throws EnderecoInvalido {
        VerificaEndereco(endereco);
        dados[endereco] = valor;
    }
}
