import java.util.ArrayList;

public class Listas {
    private static ArrayList <Funcionario> listaDeEspera = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaUsando = new ArrayList<Funcionario>();
    Funcionario f = new Funcionario();
    
    public Listas() {

    }

    public static void addToEspera(Funcionario f) {
        if(!listaDeEspera.contains(f)) {
            listaDeEspera.add(f);
            f.imprimeTentativa();
        }
    }

    public static void removeFromEspera(int indice) {
        listaDeEspera.remove(indice);
    }

    public static void addToFuncionarios(Funcionario f) {
        listaFuncionarios.add(f);
    }

    public static void removeFromFuncionarios(int indice) {
        listaFuncionarios.remove(indice);
    }

    public static void addToUsando(Funcionario f) {
        listaUsando.add(f);
    }

    public static void removeFromUsando(int indice) {
        listaUsando.remove(indice);
    }

    public static void printaListaEspera() {
        for(int i=0; i<listaDeEspera.size(); i++) {
            System.out.println(listaDeEspera.get(i).getNome());
        }
    }

    public static void printaListaFuncionarios() {
        for(int i=0; i<listaFuncionarios.size(); i++) {
            System.out.println(listaFuncionarios.get(i).getNome());
        }
    }

    public static void printaListaUsando() {
        for(int i=0; i<listaUsando.size(); i++) {
            System.out.println(listaUsando.get(i).getNome());
        }
    }

    public static void transfereEsperaParaUsando(Funcionario f) {
        for(int i=0; i<listaDeEspera.size(); i++) {
            if(listaDeEspera.get(i).getEmpresa() == f.getEmpresa()) {
                Funcionario func = listaDeEspera.get(i);
                listaUsando.add(func);
                listaDeEspera.remove(i);
                func.imprimeAcesso();
            }
        }
    }

}