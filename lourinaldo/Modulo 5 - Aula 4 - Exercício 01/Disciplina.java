public class Disciplina {

    private String nome;
    private int cargaHoraria;

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void mostrarDisciplina(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Carga Horária: "+this.getCargaHoraria());
    }
}
