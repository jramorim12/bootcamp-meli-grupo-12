package livro;

public class Cliente {

    private String nome;

    public Cliente(){}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        if(this.nome == null){
            return "Livro não está com nenhum cliente";
        }
        return this.nome;
    }
}
