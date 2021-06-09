public class Tecnico extends FuncionarioCLT{

    public static final int jornadaSemanal = 40;

    private int nMetas;

    public Tecnico(String nome, long ID, int nMetas) {
        super(nome, ID, 3200);
        this.nMetas = nMetas;
    }

    @Override
    public double pagarSalario() {
        return this.salarioBase + (this.salarioBase)*(0.05)*this.nMetas;
    }

}
