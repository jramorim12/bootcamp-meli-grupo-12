package precedenciaPessoa;

public class Pessoa implements Precedente<Pessoa> {

    private String nome;
    private String cpf;

    @Override
    public int precede(Pessoa pessoa) {
        for(int i=0; i < pessoa.getCpf().length(); i++) {
            if(this.cpf.charAt(i) != pessoa.getCpf().charAt(i)) {
                return Character.compare(this.cpf.charAt(i), pessoa.getCpf().charAt(i));
            }
        }
        return 0;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n"
                + "CPF: " + this.cpf + "\n";
    }
}
