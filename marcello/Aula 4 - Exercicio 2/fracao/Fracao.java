package fracao;

public class Fracao {

    String fracao;

    public Fracao(String fracao) {
        this.fracao = fracao;
    }

    public String getFracao() {
        return fracao;
    }

    public void setFracao(String fracao) {
        this.fracao = fracao;
    }

    @Override
    public String toString() {
        return this.fracao;
    }
}
