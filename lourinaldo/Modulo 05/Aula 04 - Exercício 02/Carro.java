public class Carro extends Veiculo{

    public static final int rodas = 4;
    public static final double peso = 1000;

    public Carro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, peso, rodas);
    }
}
