package sistemaEmpresa;

public class Analista extends Funcionario{

    private Boolean bateuMeta;
    private final Double bonus = 1.08;
    private final Double salarioBase = 4000.;

    public Analista(String nome, String numeroMatricula, Boolean bateuMeta) {
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
        return "Analista " + super.getNome() + "\n"
                + "com Matrícula: " + super.getNumeroMatricula() + "\n"
                + "que " + bateuMetas + "\n"
                + "e salário: " + super.getSalario();
    }

}
