public class ConvidadoStandard extends Convidado {
    public ConvidadoStandard(String nome) {
        super(nome);
    }

    @Override
    public void comerBolo() {
        System.out.println("Em silêncio...");
    }
}
