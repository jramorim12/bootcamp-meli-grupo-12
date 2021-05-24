package rpg;

public class Personagem {

    private String nome;
    private Classe classe;
    private Arma arma;
    private int level;

    public Personagem(String nome, Classe classe, Arma arma, int level) {
        this.nome = nome;
        this.classe = classe;
        this.arma = arma;
        this.level = level;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n"
                + this.classe + "\n"
                + this.arma + "\n"
                + "Level do Personagem: " + this.level + "\n";
    }
}
