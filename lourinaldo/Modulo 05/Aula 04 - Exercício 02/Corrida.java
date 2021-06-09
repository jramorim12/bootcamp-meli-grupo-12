import java.util.ArrayList;
import java.util.Comparator;

public class Corrida {
    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int quantidadeDeVeiculosPermitidos;
    private ArrayList<Veiculo> listaVeiculos;
    private SocorristaMoto socorristaMoto;
    private SocorristaCarro socorristaCarro;

    public Corrida(double distancia, double premioEmDolares, String nome, int quantidadeDeVeiculosPermitidos, ArrayList<Veiculo> listaVeiculos, SocorristaCarro socorristaCarro, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeDeVeiculosPermitidos = quantidadeDeVeiculosPermitidos;
        this.listaVeiculos = listaVeiculos;
        this.socorristaCarro = socorristaCarro;
        this.socorristaMoto = socorristaMoto;
    }



    public void registrarCarro(double velocidade, double aceleracao, double anguloDeGiro, String placa){

        if(listaVeiculos.size() < (quantidadeDeVeiculosPermitidos))
            listaVeiculos.add(new Carro(velocidade,aceleracao,anguloDeGiro,placa));
        else
            System.out.println("Limite atingindo, não eh possível adicionar novos veículos");
    }

    public void registrarMoto(double velocidade, double aceleracao, double anguloDeGiro, String placa){
        if(listaVeiculos.size() < (quantidadeDeVeiculosPermitidos))
            listaVeiculos.add(new Motocicleta(velocidade,aceleracao,anguloDeGiro,placa));
        else
            System.out.println("Limite atingindo, não eh possível adicionar novos veículos");
    }

    public void removerVeiculo(Veiculo veiculo){
        listaVeiculos.remove(veiculo);
    }

    public void removerVeiculo(String placa){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca() == placa){
                listaVeiculos.remove(v);
                break;
            }
        }
    }

    public Veiculo vencedore(){
        Veiculo vencedor;
        vencedor = this.listaVeiculos.stream().max(Comparator.comparing(v -> valorFormula(v))).get();
        return vencedor;
    }

    public static double valorFormula(Veiculo v){
        return (v.velocidade * v.aceleracao)/(v.anguloDeGiro * (v.peso - v.rodas * 100));
    }

    public void mostrar(){
        for (Veiculo v : this.listaVeiculos){
            System.out.println(v);
        }
    }

    public void sorristaCarro(String placa){
        Carro carro = (Carro) this.listaVeiculos.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().get();
        this.socorristaCarro.socorrer(carro);
    }

    public void socorristaMoto(String placa){
        Motocicleta moto = (Motocicleta) this.listaVeiculos.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst().get();
        this.socorristaMoto.socorrer(moto);
    }

}


