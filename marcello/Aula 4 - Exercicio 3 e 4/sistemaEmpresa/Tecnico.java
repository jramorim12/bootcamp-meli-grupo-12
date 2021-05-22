package sistemaEmpresa;

public class Tecnico extends Funcionario{

    private Boolean bateuMeta;
    private final Double bonus = 1.05;
    private final Integer jornadaSemanal = 40;
    private final Double salarioBase = 3200.;

    public Tecnico(String nome, String numeroMatricula, Boolean bateuMeta) {
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
        return "Técnico " + super.getNome() + "\n"
                + "com Matrícula: " + super.getNumeroMatricula() + "\n"
                + "que " + bateuMetas + "\n"
                + "e salário: " + super.getSalario();
    }
}
