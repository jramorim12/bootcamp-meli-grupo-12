package laChiqui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LaChiqui {

    private Scanner sc = new Scanner(System.in);
    private List<Convidado> listaConvidados = new ArrayList<>();
    private List<FogosDeArtificio[]> fogosDeArtificios = new ArrayList<>();

    public void explodeFogos() {
        this.fogosDeArtificios.forEach(arrayFogos -> Arrays.stream(arrayFogos).forEach(fogos -> System.out.println(fogos.toString())) );
    }

    public void comeBolo() {
        this.listaConvidados.forEach(Convidado::comeBolo);
    }

    public void criaConvidado() {
        System.out.println("======== La Chiqui ========");
        System.out.print("Insira o nome do convidado: ");
        String nome = sc.nextLine();
        System.out.print("Insira a idade do convidado: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("O convidado é do MeLi? (S/N): ");
        String resposta = sc.nextLine();
        this.adicionaConvidado(nome, idade, resposta);
        System.out.print("Gostaria de adicionar mais convidados? (S/N): ");
        String opcao = sc.nextLine();
        if(opcao.equalsIgnoreCase("S"))
            this.criaConvidado();
        this.printConvidados();
        return;
    }

    public void adicionaFogos(FogosDeArtificio[] array) {
        this.fogosDeArtificios.add(array);
    }

    public void adicionaConvidado(String nome, int idade, String resposta) {
        if(resposta.equalsIgnoreCase("S")) {
            listaConvidados.add(new Convidado(nome, idade, TipoConvidado.MELI));
            return;
        }
        listaConvidados.add(new Convidado(nome, idade, TipoConvidado.STANDARD));
    }

    public void printConvidados() {
        System.out.println("======== La Chiqui ========");
        System.out.println("Lista de convidados: " + "\n");
        this.listaConvidados.forEach(System.out::println);
    }

    public void apagaVela() {
        this.comeBolo();
        this.explodeFogos();
    }

}
