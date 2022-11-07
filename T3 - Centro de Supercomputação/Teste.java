import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();   
        lista.add(1);
        lista.add(2); 

        if(lista.contains(2)) {
            System.out.println("contem");
        } else {
            System.out.println("nao contem");
        }

    }
}
