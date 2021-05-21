package entidades;

public enum Grau {

    FUNDAMENTAL("Ensino Fundamental"),
    MEDIO("Ensino médio");

    private final String grau;

    Grau(String s) {
        this.grau = s;
    }

    @Override
    public String toString() {
        return this.grau;
    }

}
