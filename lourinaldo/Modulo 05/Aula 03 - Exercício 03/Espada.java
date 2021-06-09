import java.util.Random;

public class Espada extends Arma{

    private double modificadorCriticoPesado;

    public Espada(int danoAtaque, int durabilidade, int pCritico, double modificadorCriticoPesado, String nome) {
        super(danoAtaque, durabilidade, pCritico, nome);
        this.modificadorCriticoPesado = modificadorCriticoPesado;
    }

    public void ataquePesado(){
        System.out.println("Dano de atk pesado: " + (this.getDanoAtaque() + (this.getDanoAtaque() * 1.5 * this.ataquePesadoCriticou())));
    }

    public double getModificadorCriticoPesado() {
        return modificadorCriticoPesado;
    }

    public void setModificadorCriticoPesado(double modificadorCriticoPesado) {
        this.modificadorCriticoPesado = modificadorCriticoPesado;
    }

    @Override
    public void ataqueNormal() {
        System.out.println("Dano de atk: " +(this.getDanoAtaque() + (this.getDanoAtaque() * 0.5 * this.ataqueCriticou())));
    }

    public int ataquePesadoCriticou() {
        Random r = new Random();
        int chance = r.nextInt(100);

        if(chance < (this.getpCritico()*this.getModificadorCriticoPesado())+1){
            return 1;
        }else{
            return 0;
        }
    }
}
