public class Arco extends Arma{

    private int QuantidadeFlechas;

    public Arco(int danoAtaque, int durabilidade, int pCritico, int quantidadeFlechas, String nome) {
        super(danoAtaque, durabilidade, pCritico, nome);
        this.setQuantidadeFlechas(quantidadeFlechas);
    }

    public void usarFlecha(){
        this.setQuantidadeFlechas(this.getQuantidadeFlechas()-1);
    }

    public void comprarFlecha(){
        this.setQuantidadeFlechas(this.getQuantidadeFlechas()+1);
    }

    public int getQuantidadeFlechas() {
        return QuantidadeFlechas;
    }

    private void setQuantidadeFlechas(int quantidadeFlechas) {
        QuantidadeFlechas = quantidadeFlechas;
    }

    @Override
    public void ataqueNormal() {
        if(getQuantidadeFlechas() == 0){
            System.out.println("As suas flechas acabaram!");
        }else{
            this.usarFlecha();
            System.out.println("Dano de atk: " + (this.getDanoAtaque() + (this.getDanoAtaque() * 0.25 * this.ataqueCriticou())));
        }
    }


}
