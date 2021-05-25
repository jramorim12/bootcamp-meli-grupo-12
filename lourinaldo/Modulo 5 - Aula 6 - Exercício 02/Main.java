import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Veiculo carro1 = new Carro(100, 5, 45, "qwe1233");
        Veiculo carro2 = new Carro(120, 3, 30, "rty8987");
        Veiculo moto1 = new Motocicleta(90, 7, 55, "hfh5656");

        ArrayList<Veiculo> lista = new ArrayList<>();
        lista.add(carro1);
        lista.add(carro2);
        lista.add(moto1);

        SocorristaMoto sm = new SocorristaMoto();
        SocorristaCarro sc = new SocorristaCarro();

        Corrida corrida = new Corrida(100, 1000, "Corrida 01", 4, lista, sc, sm);

        corrida.registrarCarro(123,5,23,"iop9049");
        corrida.registrarMoto(80,10,80,"iii3132");

        corrida.sorristaCarro("qwe1233");
        corrida.socorristaMoto("hfh5656");

        System.out.println("O vencedor da corrida é: " + corrida.vencedore());


    }
}
