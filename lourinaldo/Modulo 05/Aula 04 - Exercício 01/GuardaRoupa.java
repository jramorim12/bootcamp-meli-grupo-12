import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuardaRoupa {
    private int counter = 0;
    private Map<Integer, ArrayList<Vestuario>> roupas;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public GuardaRoupa() {
        roupas = new HashMap<>();
    }

    public Integer guardarVestuario(ArrayList<Vestuario> listaVestuario){
        setCounter(counter+1);
        roupas.put(counter, listaVestuario);
        return counter;
    }

    public void mostrarVestuario(){
        for(Map.Entry<Integer, ArrayList<Vestuario>> entry : roupas.entrySet()){
            System.out.println("Valor chave: " + entry.getKey() + '\n');
            for(Vestuario v : entry.getValue()){
                System.out.println(v);
            }
        }
    }

    public ArrayList<Vestuario> devolverVestuario(Integer id){
        return roupas.get(id);
    }

    public Map<Integer, ArrayList<Vestuario>> getRoupas() {
        return roupas;
    }

    public void setRoupas(Map<Integer, ArrayList<Vestuario>> roupas) {
        this.roupas = roupas;
    }
}
