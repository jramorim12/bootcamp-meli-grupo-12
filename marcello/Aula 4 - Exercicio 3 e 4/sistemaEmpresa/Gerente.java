package sistemaEmpresa;

public class Gerente extends Funcionario{

    private Boolean bateuMeta;
    private final Double bonus = 1.125;
    private final Double salarioBase = 6000.;

    public Gerente(String nome, String numeroMatricula, Boolean bateuMeta) {
        super(nome, numeroMatricula);
        this.bateuMeta = bateuMeta;
        super.setSalario(this.calculaSalario());
    }

    public Boolean getBateuMeta() {
        return bateuMeta;
    }

    public void setBateuMeta(Boolean bateuMeta) {
        this.bateuMeta = bateuMeta;
    }

    @Override
    public Double calculaSalario() {
        if(this.bateuMeta) {
            return this.salarioBase * this.bonus;
        }
        return this.salarioBase;
    }

    @Override
    public String toString() {
        String bateuMetas = "";
        if(this.bateuMeta){
            bateuMetas = "bateu metas";
        } else {
            bateuMetas = "não bateu metas";
        }
        return "Gerente " + super.getNome() + "\n"
                + "com Matrícula: " + super.getNumeroMatricula() + "\n"
                + "que " + bateuMetas + "\n"
                + "e salário: " + super.getSalario();
    }
}
