package dakar;

import java.util.*;


// TO DO
// Implementar lógica de distância percorrida.
public class Corrida {

    private Double distancia;
    private Double premioEmDolares;
    private String nome;
    private Integer quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos = new ArrayList<>();
    private SocorristaCarro salvaVidasCarro = new SocorristaCarro();
    private SocorristaMoto salvaVidasMoto = new SocorristaMoto();

    public void registraCarro(Double velocidade, Double aceleracao, Double anguloDeGiro,String patente) {
        if(listaVeiculos.size() > this.quantidadeVeiculosPermitidos - 1) {
            System.out.println("Corrida já está cheia!!");
            return;
        }
        System.out.println("Registrando carro...");
        listaVeiculos.add(new Carro(velocidade, aceleracao, anguloDeGiro, patente));
    }

    public void registraMoto(Double velocidade, Double aceleracao, Double anguloDeGiro, String patente) {
        if(listaVeiculos.size() > this.quantidadeVeiculosPermitidos - 1) {
            System.out.println("Corrida já está cheia!!");
            return;
        }
        System.out.println("Registrando moto...");
        listaVeiculos.add(new Moto(velocidade, aceleracao, anguloDeGiro,patente));
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
        System.out.println("Veículo removido");
    }

    public void voidRemoverVeiculoPorPlaca(String placa) {
        for(Veiculo veiculo : this.listaVeiculos){
            if(veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Removendo véiculo: " + veiculo);
                this.listaVeiculos.remove(veiculo);
                return;
            }
        }
    }

    public Veiculo getVencedor(){
        Veiculo veiculo = this.listaVeiculos
                .stream()
                .max(Comparator.comparing(this::getFormula))
                .get();
        System.out.println("O vencedor é: " + veiculo);
        return veiculo;
    }

    public void socorrerCarro(String documento) {
       Carro carro = (Carro) this.listaVeiculos
                .stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(documento))
                .findFirst()
                .get();
       this.salvaVidasCarro.socorrerCarro(carro);
    }

    public void socorrerMoto(String documento) {
        Moto moto = (Moto) this.listaVeiculos
                .stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(documento))
                .findFirst()
                .get();
        this.salvaVidasMoto.socorrerMoto(moto);
    }

    public Double getFormula(Veiculo veiculo) {
        return (veiculo.getvelocidade() * veiculo.getAceleracao()) / (veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100));
    }

    public Corrida(Double distancia, Double premioEmDolares, String nome, Integer quantidadeVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEmDolares() {
        return premioEmDolares;
    }

    public void setPremioEmDolares(Double premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeVeiculosPermitidos() {
        return quantidadeVeiculosPermitidos;
    }

    public void setQuantidadeVeiculosPermitidos(Integer quantidadeVeiculosPermitidos) {
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
}


