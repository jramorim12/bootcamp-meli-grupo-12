package livro;

public class Livro {

    private String nome;
    private String autor;
    private Integer anoDeLancamento;
    private Cliente cliente;

    public Livro(){}

    public Livro(String nome, String autor, Integer anoDeLancamento, Cliente cliente) {
        this.nome = nome;
        this.autor = autor;
        this.anoDeLancamento = anoDeLancamento;
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return this.nome + " escrito por " + this.autor + "\n"
                + "Lançado em: " + this.anoDeLancamento
                + "Está com o cliente: " + this.cliente;
    }
}
