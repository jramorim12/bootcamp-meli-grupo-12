package sistemaEmpresa;

// Optei por fazer apenas a classe Funcionario em vez de FuncionarioPJ e FuncionarioCLT.
// Porque o funcionário Diretor não segue o modelo dos outros CLT mas ainda é um CLT.
// Isso quebraria o conceito de herança, adicionando muitas particularidades para uma classe filha, gerando complexidade desnecessária.

public abstract class Funcionario {

    private String nome;
    private String numeroMatricula;
    private Double salario;

    public Funcionario(String nome, String numeroMatricula) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public abstract Double calculaSalario();
}
