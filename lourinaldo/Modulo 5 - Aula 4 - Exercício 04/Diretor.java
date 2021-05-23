public class Diretor extends FuncionarioCLT{

    private double lucro;

    public Diretor(String nome, long ID, double lucro) {
        super(nome, ID, 15000);
        this.lucro = lucro;
    }

    @Override
    public double pagarSalario() {
        return this.salarioBase + (0.03)*this.lucro;
    }
}
