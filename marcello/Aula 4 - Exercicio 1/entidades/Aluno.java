package entidades;

public class Aluno {

    String nome;
    Integer idade;
    Integer numeroMatricula;
    Serie serie;

    public Aluno(String nome, Integer idade, Integer numeroMatricula, Serie serie) {
        this.nome = nome;
        this.idade = idade;
        this.numeroMatricula = numeroMatricula;
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return  this.nome
                + ", Idade:" + this.idade
                + ", RM:" + this.numeroMatricula
                + ", Série:" + this.serie + "\n";
    }
}
