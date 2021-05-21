import java.util.ArrayList;

public class Turma {

    private long id;
    private String nome;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Estudante> estudantes;

    public Turma() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public void mostrarTurma(){
        System.out.println("ID da turma: "+ this.getId());
        System.out.println("Nome da Turma: "+ this.getNome());
        System.out.println("---------- Alunos cadastrados ---------");
        for(Estudante s: this.estudantes){
            s.mostrarEstudante();
        }
        System.out.println("--------------------------------------");
        System.out.println("------ Disciplinas cadastradas -------");
        for(Disciplina d: this.disciplinas){
            d.mostrarDisciplina();
        }
        System.out.println("---------------------------------------");
    }
}
