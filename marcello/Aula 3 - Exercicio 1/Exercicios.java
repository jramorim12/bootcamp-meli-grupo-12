import java.util.Scanner;

public class Exercicios {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Exercicios.numerosPares();
        Exercicios.numerosMultiplos();
        Exercicios.primoInformadoPeloUsuario();
        Exercicios.numerosPrimos();
        Exercicios.algarismosIguais();
    }

    public static void numerosPares() {
        System.out.print("Informe a quantidade dos primeiros números pares que deseja descobrir: ");
        int counter = 0;
        int num = 1;
        int qtdeNum = Exercicios.sc.nextInt();

        if(qtdeNum < 1) {
            System.out.println("Número informado inválido!!");
            System.out.print("Por favor insira outro número: ");
            qtdeNum = Exercicios.sc.nextInt();
        } 
        
        do {
            if(Exercicios.par(num)) {
                counter++;
                System.out.println(counter + "º número par: " + num);
            }
            num++;
        } while(counter != qtdeNum);
    }

    public static boolean par(int num) {
        if(num%2 == 0) {
            return true;
        }

        return false;
    }

    public static void numerosMultiplos() {
        int counter = 0;
        int num = 1;
        System.out.print("Informe a quantidade dos primeiros números que deseja descobrir se são múltiplos: ");
        int qtdeNum = Exercicios.sc.nextInt();
        System.out.print("Esses números serão múltiplos de: ");
        int multiplo = Exercicios.sc.nextInt();

        do {
            if(Exercicios.multiplo(num, multiplo)) {
                counter++;
                System.out.println(counter + "º número múltiplo de " + multiplo + " : " + num);
            }
            num++;
        }while(counter != qtdeNum);

    }

    public static Boolean multiplo(int num, int multiplo) {
        if(num%multiplo == 0) {
            return true;
        } 

        return false;
    }

    public static Boolean primo(int num) {
        int qtdeDivisores = 0;

        if(num == 1) {
            return true;
        }

            for(int i=1; i < num+1; i++) {
                if(num%i == 0) {
                    qtdeDivisores++;
                }
            }
            if(qtdeDivisores == 2) {
                return true;
            }

            return false;

    }

    public static void primoInformadoPeloUsuario() {
        System.out.print("Informe um número para saber se é primo ou não: ");
        int num = sc.nextInt();
        if(Exercicios.primo(num)) {
            System.out.println("O número " + num + " é primo!");
            return;
        }

        System.out.println("O número " + num + " não é primo!");
    }

    public static void numerosPrimos() {
        int num = 1;
        int counter = 0;
        System.out.print("Informe a quantidade dos primeiros números primos que deseja saber: ");
        int qtdeNum = Exercicios.sc.nextInt();

        do {
            if(Exercicios.primo(num)) {
                counter++;
                System.out.println(counter + "º número primo: " + num);
            }
            num++;
        } while(counter != qtdeNum);
        
    }

    public static int pegaAlgarismo(int num) {
        return num%10;
    }

    public static Boolean verificaAlgarismosIguais(int num, int algarismo, int times) {
        int aux = num;
        int appearanceTimes = 0;
        do{
            int alg = Exercicios.pegaAlgarismo(aux);
            aux = aux/10;

            if(alg == algarismo){
                appearanceTimes++;
            }

            }while(aux != 0);

            if(appearanceTimes == times) {
                System.out.println("Achamos um número: " + num );
                return true;
            }

            return false;

    }

    public static void algarismosIguais() {

        int counter = 0;
        int num = 1;
        System.out.print("Informe a quantidade de números que deseja saber se tem determinados algarismos: ");
        int retry = Exercicios.sc.nextInt();
        System.out.print("Por qual algarismo você deseja comparar: ");
        int comparableAlg = Exercicios.sc.nextInt();
        System.out.print("Quantas vezes esse algarismo deve aparecer? ");
        int times = Exercicios.sc.nextInt();

        do {
            
            if(Exercicios.verificaAlgarismosIguais(num, comparableAlg, times)) {
                counter++;
            }
            num++;
            
        } while(counter != retry);
   
    }

}