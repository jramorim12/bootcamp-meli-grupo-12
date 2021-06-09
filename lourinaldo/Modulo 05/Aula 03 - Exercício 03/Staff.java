public class Staff extends Arma{

    private int custoMana;
    private double mana;

    public Staff(int danoAtaque, int durabilidade, int pCritico, int custoMana, double mana, String nome) {
        super(danoAtaque, durabilidade, pCritico, nome);
        this.custoMana = custoMana;
        this.mana = mana;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public void setCustoMana(int custoMana) {
        this.custoMana = custoMana;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public boolean consumirMana(double modificador){
        if((this.getMana() - (this.getCustoMana()*modificador)) > 0){
            this.setMana(this.getMana() - (this.getCustoMana()*modificador));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void ataqueNormal() {
        if(this.consumirMana(1)){
            System.out.println("Dano mágico normal: " +(this.getDanoAtaque() + (this.getDanoAtaque() * 0.25 * this.ataqueCriticou())));
        }else{
            System.out.println("Item não possui mana suficiente para realizar o ataque.");
        }
    }

    public void ataqueEspecial() {
        if(this.consumirMana(2)){
            System.out.println("Dano mágico especial: " +(this.getDanoAtaque() + (this.getDanoAtaque() * this.ataqueCriticou())));
        }else{
            System.out.println("Item não possui mana suficiente para realizar o ataque.");
        }
    }


}
