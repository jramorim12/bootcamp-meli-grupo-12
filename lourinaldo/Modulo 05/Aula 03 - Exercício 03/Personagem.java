import java.util.Scanner;
import java.util.SortedMap;

public class Personagem {
    private String nome;
    private String raca;
    private int nivel;
    private Arma arma;

    public Personagem(String nome, String raca, int nivel, Arma arma) {
        this.nome = nome;
        this.raca = raca;
        this.nivel = nivel;
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void comprarFlecha(){
        if(this.arma instanceof Arco){
            ((Arco) this.arma).comprarFlecha();
            System.out.println("Flecha comprada, vc possui " + ((Arco) this.arma).getQuantidadeFlechas());
        }else{
            System.out.println("Você não está usando um arco!");
        }
    }

    public void trocarArma(Arma arma){
        this.arma = arma;
    }

    public void atacar(){
        Scanner scanner = new Scanner(System.in);
        int val;
        if(this.arma instanceof Espada){
            System.out.println("Você está usando uma espada: 1 para ataque normal | 2 para ataque pesado");
            val = scanner.nextInt();
            if(val == 1){
                this.arma.ataqueNormal();
            }else{
                ((Espada) this.arma).ataquePesado();
            }
        }else if(this.arma instanceof Arco){
            this.arma.ataqueNormal();
        }else if(this.arma instanceof Staff){
            System.out.println("Você está usando uma staff: 1 para ataque normal | 2 para ataque especial");
            val = scanner.nextInt();
            if(val == 1){
                this.arma.ataqueNormal();
            }else{
                ((Staff) this.arma).ataqueEspecial();
            }
        }
    }
}
