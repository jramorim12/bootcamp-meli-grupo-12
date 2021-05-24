package rpg;

import precedenciaPessoa.Pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    static ArmaUtils armaUtils = new ArmaUtils();
    static ClasseUtils classeUtils = new ClasseUtils();

    private static List<Arma> armas;
    private static List<Classe> classes;

    public static void main(String[] args) {
        Menu.initPersonagem();
    }


    public static void initPersonagem() {

        // Menu inicial
        Menu.setArmas();
        Menu.ordenaArmas();
        Menu.setClasses();
        Menu.initMenu();

        // Escolha de Classes
        System.out.println("Escolha sua classe: ");
        Menu.printClasses();
        Classe classeEscolhida = Menu.getClasse();

        // Escolha de Armas
        System.out.println("Escolha sua arma: ");
        Menu.printArmas();
        Arma armaEscolhida = Menu.getArma();

        // Montando personagem
        System.out.print("Informe o nome do seu personagem: ");
        String nome = sc.nextLine();
        Personagem personagem = new Personagem(nome, classeEscolhida, armaEscolhida, 99);
        System.out.println("E assim ficou ser personagem: ");
        System.out.println(personagem);

        System.out.println("Vamos trocar as armas!!");
        int retry=0;
        do {
            Arma novaArma = Menu.getArma();
            personagem.setArma(novaArma);
            System.out.println(personagem);
            retry++;
        } while(retry < 3);


    }

    public static void initMenu() {
        System.out.println("Vamos montar seu personagem!");
        System.out.println("No nosso jogo sabemos que Devs não têm tempo!!");
        System.out.println("Então nada de grind, você começa solando tudo no Level 99!! ");
    }

    public static void printClasses() {
        for(Classe classe : Menu.classes) {
            System.out.println(classe);
        }
    }

    public static void printArmas() {
        for(Arma arma : Menu.armas) {
            System.out.println(arma);
        }
    }

    private static Classe getClasse() {
        System.out.print("Digite aqui a classe escolhida: ");
        String opcaoClasse = sc.nextLine();
        return Menu.getClasseEscolhida(opcaoClasse);
    }

    private static Classe getClasseEscolhida(String nomeClasse) {
        Classe classeEscolhida = null;
        for(Classe classe : Menu.classes) {
            if(classe.getNome().equalsIgnoreCase(nomeClasse))
                classeEscolhida = classe;
        }
        return classeEscolhida;
    }

    private static Arma getArma() {
        System.out.print("Digite aqui sua arma: ");
        String opcaoArma = sc.nextLine();
        return Menu.getArmaEscolhida(opcaoArma);
    }

    private static Arma getArmaEscolhida(String nomeArma) {
        Arma armaEscolhida = null;
        for(Arma arma : Menu.armas) {
            if(arma.getTipo().equalsIgnoreCase(nomeArma))
                armaEscolhida = arma;
        }
        return armaEscolhida;
    }

    private static int compare(Arma arma1, Arma arma2) {
        int maxLength = Math.max(arma1.getTipo().length(), arma2.getTipo().length());
        for (int i = 0; i < maxLength; i++) {
                if (arma1.getTipo().charAt(i) != arma2.getTipo().charAt(i)) {
                    return Character.compare(arma1.getTipo().charAt(i), arma2.getTipo().charAt(i));
                }
            }
            return 0;
        }

    private static void ordenaArmas() {
        Arma aux;
        for (Arma arma : Menu.armas) {
                for (int i = 0; i < Menu.armas.size() - 1; i++) {
                    if (Menu.compare(armas.get(i), armas.get(i+1)) > 0) {
                        aux = armas.get(i);
                        armas.set(i,armas.get(i+1));
                        armas.set(i+1,aux);
                    }
                }
        }
    }

    private static void trocaArma() {
        System.out.println("E");
    }

    private static void setArmas() {
        Menu.armas = Menu.armaUtils.initArmas();
    }

    private static void setClasses() {
        Menu.classes = Menu.classeUtils.initClasses();
    }


}
