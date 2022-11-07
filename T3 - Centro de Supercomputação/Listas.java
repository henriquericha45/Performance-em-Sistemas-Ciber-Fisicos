import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Listas {
    private static ArrayList <Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaUsando = new ArrayList<Funcionario>();
    private static ArrayList <Funcionario> listaEspera = new ArrayList<Funcionario>();
    Funcionario f = new Funcionario();
    
    public Listas() {

    }

    public static void tentaConexao(Funcionario f) {
        if(!listaEspera.contains(f)) {
            listaEspera.add(f);
            f.imprimeTentativa();
        }
    }
/* 
    public static void transfereEsperaParaUsando(Semaphore cheio) throws InterruptedException {
        for(int i=0; i<listaEspera.size(); i++) {
            if(listaUsando.size() > 0){
                if(listaUsando.get(0).getEmpresa() == listaEspera.get(i).getEmpresa()) {
                    cheio.acquire();
                    Funcionario f = listaEspera.get(i);
                    listaUsando.add(f);
                    listaEspera.remove(i);
                    listaUsando.get(i).imprimeAcesso();
                }
            } else {
                cheio.acquire();
                Funcionario f = listaEspera.get(i);
                listaUsando.add(f);
                listaEspera.remove(i);
                listaUsando.get(i).imprimeAcesso();
            }
            
        }
    }
*/

    public static void transfereEsperaParaUsando() {
        for(int i=0; i<listaEspera.size(); i++) {
            if(listaUsando.size() > 0){
                if(listaUsando.get(0).getEmpresa() == listaEspera.get(i).getEmpresa()) {
                    Funcionario f = listaEspera.get(i);
                    listaUsando.add(f);
                    listaEspera.remove(i);
                    listaUsando.get(i).imprimeAcesso();
                }
            } else {
                Funcionario f = listaEspera.get(i);
                listaUsando.add(f);
                listaEspera.remove(i);
                listaUsando.get(i).imprimeAcesso();
            }   
        }
    }

    public static void removeFromUsando() {
        for(int i=0; i<listaUsando.size(); i++) {
            listaUsando.remove(i);
            listaUsando.get(i).imprimeTermino();
        }
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

    public static void printaTamanho() {
        System.out.println("Tamanho da lista de funcionarios: " + listaFuncionarios.size());
        System.out.println("Tamanho da lista de usando: " + listaUsando.size());
        System.out.println("Tamanho da lista de espera: " + listaEspera.size());
    }

}