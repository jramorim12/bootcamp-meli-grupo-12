package rpg;

public class Arma {

    private String tipo;
    private int danoBase;
    private int level;

    public Arma(String tipo, int danoBase, int level) {
        this.tipo = tipo;
        this.danoBase = danoBase;
        this.level = level;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.tipo + "\n"
                + "Dano base: " + this.danoBase + "\n"
                + "Level: " + this.level + "\n";
    }
}
