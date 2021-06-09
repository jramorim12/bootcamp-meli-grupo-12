public class Analista extends FuncionarioCLT{

    public static final int jornadaSemanal = 40;
    public static final int descansoSemanalRemunerado = 4;

    private int nMetas;

    public Analista(String nome, long ID, int nMetas){
        super(nome, ID, 4000);
        this.nMetas = nMetas;
    }

    @Override
    public double pagarSalario() {
        return this.salarioBase + (this.salarioBase)*(0.08)*this.nMetas;
    }
}
