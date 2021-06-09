public class Pessoa implements Precedente<Pessoa>{

    private String nome;
    private  long cpf;

    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }

    @Override
    public int precedeA(Pessoa pessoa) {
        if(pessoa.getCpf() > this.getCpf()){
            return 1;
        }else if(pessoa.getCpf() < this.getCpf()){
            return -1;
        }else{
            return 0;
        }
    }
}
