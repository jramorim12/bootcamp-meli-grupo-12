package entidades;

public class Serie {

    Integer ano;
    Grau grau;

    public Serie(Integer ano, Grau grau) {
        this.ano = ano;
        this.grau = grau;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Grau getGrau() {
        return grau;
    }

    public void setGrau(Grau grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return this.ano + "º ano do " + this.grau;
    }
}
