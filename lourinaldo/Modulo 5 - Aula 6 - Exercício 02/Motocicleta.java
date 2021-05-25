public class Motocicleta extends Veiculo{

    public static final int rodas = 2;
    public static final double peso = 300;

    public Motocicleta(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, peso, rodas);
    }


}
