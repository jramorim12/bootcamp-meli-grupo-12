public class FuncionarioPJ extends Funcionario{

    private int horasTrabalhadas;
    private double valorPorHora;

    public FuncionarioPJ(String nome, long ID, int horasTrabalhadas, double valorPorHora) {
        super(nome, ID);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public String toString() {
        return "FuncionarioPJ{" +
                "nome='" + nome + '\'' +
                ", ID=" + ID +
                ", horasTrabalhadas=" + horasTrabalhadas +
                ", valorPorHora=" + valorPorHora +
                '}';
    }

    @Override
    public double pagarSalario() {
        return horasTrabalhadas * valorPorHora;
    }
}
