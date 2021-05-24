import java.util.ArrayList;
import java.util.Comparator;

public class Exercicio03 {

    public static void main(String[] args) {
        Arma arco = new Arco(20, 20, 20, 10, "Arco");
        Arma espada = new Espada(30, 20, 30, 0.5, "Espada");
        Arma staff = new Staff(20, 20, 15, 4, 50, "Staff");
        Personagem personagem = new Personagem("Goku", "Elfo", 32, arco);

        personagem.atacar();
        personagem.comprarFlecha();
        personagem.trocarArma(espada);
        personagem.atacar();
        personagem.trocarArma(staff);
        personagem.atacar();

        ArrayList<Arma> armas = new ArrayList<>();

        armas.add(staff);
        armas.add(espada);
        armas.add(arco);
        espada.sortArmas(armas);

        for(Arma a: armas){
            System.out.println(a);
        }
        
    }
}
