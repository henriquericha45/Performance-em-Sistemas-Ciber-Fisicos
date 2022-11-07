import java.util.ArrayList;
import java.util.Random;

public class Listas {
    private static ArrayList <Funcionario> listaDeEspera = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaUsando = new ArrayList<Funcionario>();
    Funcionario f = new Funcionario();
    static Random random = new Random();
    
    public Listas() {

    }

    public static void addToEspera(Funcionario f) {
        if(listaDeEspera.size() == 0) {
            listaDeEspera.add(f);
            f.imprimeTentativa();
        } else if(listaDeEspera.size() > 0) {
            for(int i=0; i<listaDeEspera.size(); i++) {
                if(!listaDeEspera.get(i).equals(f)) {
                    listaDeEspera.add(f);
                    f.imprimeTentativa();
                    break;
                }
            }
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

    public static void transfereEsperaParaUsando() {
        if(listaUsando.size() == 0 && listaDeEspera.size() > 0) {
            Funcionario f = listaDeEspera.get(0);
            listaUsando.add(f);
            listaDeEspera.remove(0);
            f.imprimeAcesso();
        } 
        if(listaUsando.size() != 0 && listaDeEspera.size() != 0) {
            for(int i=0; i<listaDeEspera.size(); i++) {
                if(listaDeEspera.get(i).getEmpresa() == listaUsando.get(0).getEmpresa()) {
                    Funcionario f = listaDeEspera.get(i);
                    listaUsando.add(f);
                    listaDeEspera.remove(i);
                    f.imprimeAcesso();
                    break;
                }
            }
        }
    }

    public static void removeFromUsando() {
            
        if(listaUsando.size() > 0) {
            listaUsando.get(0).imprimeTermino();
            listaUsando.remove(0); 
        }
            
    }

    public static void imprimeListaDeEspera() {
        System.out.println("Lista de espera:");
        for(int i=0; i<listaDeEspera.size(); i++) {
            System.out.println(listaDeEspera.get(i).getNome() + " [" + listaDeEspera.get(i).getEmpresa() + "]");
        }
    }

}