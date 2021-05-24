import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public abstract class Arma {

    private int danoAtaque;
    private int durabilidade;
    private int pCritico;
    private String nome;

    public Arma(int danoAtaque, int durabilidade, int pCritico, String nome) {
        this.danoAtaque = danoAtaque;
        this.durabilidade = durabilidade;
        this.pCritico = pCritico;
        this.nome = nome;
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }

    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    public int getpCritico() {
        return pCritico;
    }

    public void setpCritico(int pCritico) {
        this.pCritico = pCritico;
    }

    public abstract void ataqueNormal();

    public int ataqueCriticou(){
        Random r = new Random();
        int chance = r.nextInt(100);

        if(chance < this.getpCritico()+1){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nome=" + nome +
                ", danoAtaque=" + danoAtaque +
                ", durabilidade=" + durabilidade +
                ", pCritico=" + pCritico +
                '}';
    }

    public void sortArmas(ArrayList<Arma> armas){
        Comparator<Arma> c = new Comparator<Arma>() {
            @Override
            public int compare(Arma o1, Arma o2) {
                return o1.nome.compareTo(o2.nome);
            }
        };

        Collections.sort(armas, c);
    }
}
