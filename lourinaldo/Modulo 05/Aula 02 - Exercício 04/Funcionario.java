public abstract class Funcionario {
    protected String nome;
    protected long ID;

    public Funcionario(String nome, long ID) {
        this.nome = nome;
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    protected abstract double pagarSalario();
}
