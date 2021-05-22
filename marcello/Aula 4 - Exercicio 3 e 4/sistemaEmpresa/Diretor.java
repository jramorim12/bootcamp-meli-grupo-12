package sistemaEmpresa;

public class Diretor extends Funcionario{

    private final Double bonusPLR = 0.03;
    private final Double salarioBase = 15000.;

    public Diretor(String nome, String numeroMatricula) {
        super(nome, numeroMatricula);
        super.setSalario(this.calculaSalario());
    }

    @Override
    public Double calculaSalario() {
        Double lucroEmpresa = 150000.;
        return this.salarioBase + (lucroEmpresa * this.bonusPLR);
    }

    @Override
    public String toString() {
        return "Diretor " + super.getNome() + "\n"
                + "com Matrícula: " + super.getNumeroMatricula() + "\n"
                + "e salário: " + super.getSalario();
    }
}
