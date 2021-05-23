public class FuncionarioCLT extends Funcionario{

    protected double salarioBase;
    protected double bonus;

    public FuncionarioCLT(String nome, long ID, double salarioBase) {
        super(nome, ID);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double pagarSalario() {
        return this.salarioBase;
    }

}
