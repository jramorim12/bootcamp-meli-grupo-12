package sistemaEmpresa;

public class FuncionarioPJ extends Funcionario {

    private Double horasTrabalhadas;
    private Double valorHora;

    public FuncionarioPJ(String nome, String numeroMatricula, Double horasTrabalhadas, Double valorHora) {
        super(nome, numeroMatricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        super.setSalario(this.calculaSalario());
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }


    @Override
    public Double calculaSalario() {
        return this.valorHora * this.horasTrabalhadas;
    }

    @Override
    public String toString() {
        return "Funcionário PJ " + super.getNome() + "\n"
                + "com Matrícula: " + super.getNumeroMatricula() + "\n"
                + "que trabalhou " + this.horasTrabalhadas + " horas" + "\n"
                + "pago " + this.valorHora + " reais por hora trabalhada" + "\n"
                + "e salário: " + super.getSalario();
    }
}
