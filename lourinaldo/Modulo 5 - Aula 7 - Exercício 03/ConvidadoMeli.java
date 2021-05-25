public class ConvidadoMeli extends Convidado {
    public ConvidadoMeli(String nome) {
        super(nome);
    }

    @Override
    public void comerBolo() {
        System.out.println("Gritando: Viva la Chiqui !!");
    }
}
