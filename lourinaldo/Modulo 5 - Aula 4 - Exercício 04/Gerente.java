public class Gerente extends FuncionarioCLT{

    public static final int jornadaSemanal = 36;
    public static final int descansoSemanalRemunerado = 4;

    private int nMetas;

    public Gerente(String nome, long ID, int nMetas) {
        super(nome, ID, 6000);
        this.nMetas = nMetas;
    }

    @Override
    public double pagarSalario() {
        return this.salarioBase + (this.salarioBase)*(0.125)*this.nMetas;
    }
}
