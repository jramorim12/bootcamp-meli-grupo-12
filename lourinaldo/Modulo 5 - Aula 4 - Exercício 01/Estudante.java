public class Estudante {

    private String nome;
    private int idade;
    private long nMatricula;
    private String serie;

    public Estudante() {
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public long getnMatricula() {
        return nMatricula;
    }

    public void setnMatricula(long nMatricula) {
        this.nMatricula = nMatricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrarEstudante(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Idade: "+this.getIdade());
        System.out.println("Número de matrícula: "+this.getnMatricula());
        System.out.println("Série: "+this.getSerie());
    }
}
