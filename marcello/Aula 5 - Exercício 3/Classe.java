package rpg;

public class Classe {

    private String nome;
    private String funcao;

    public Classe(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return this.getNome() + "\n"
                + "Função: " + this.getFuncao() + "\n";
    }
}
