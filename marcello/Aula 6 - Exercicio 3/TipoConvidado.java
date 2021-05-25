package laChiqui;

public enum TipoConvidado {

    MELI("MeLi"),
    STANDARD("Standard");

    private String tipo;

    TipoConvidado(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Convidado " + this.tipo;
    }
}
