package laChiqui;

public class Convidado {

    private String nome;
    private int idade;
    private TipoConvidado tipoConvidado;

    public Convidado(String nome, int idade, TipoConvidado tipoConvidado) {
        this.nome = nome;
        this.idade = idade;
        this.tipoConvidado = tipoConvidado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoConvidado getTipoConvidado() {
        return tipoConvidado;
    }

    public void setTipoConvidado(TipoConvidado tipoConvidado) {
        this.tipoConvidado = tipoConvidado;
    }

    @Override
    public String toString() {
        return this.nome + "\n"
                + "Idade: " + this.idade + "\n"
                + this.tipoConvidado + "\n";
    }

    public void comeBolo() {
        if(this.tipoConvidado.equals(TipoConvidado.MELI)) {
            System.out.println(this.nome + " gritou ao comer o bolo: ");
            System.out.println("Viva La Chiqui" + "\n");
            return;
        }
        System.out.println(this.nome + " não gritou ao comer o bolo pois está triste por não ser MeLi." + "\n");
    }
}
