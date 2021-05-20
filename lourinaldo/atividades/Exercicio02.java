import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args){
        int n,m;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Insira o valor de n:");
        n = keyboard.nextInt();

        System.out.println("Insira o valor de m:");
        m = keyboard.nextInt();

        switch (m){
            case 0:
                System.out.println("M deve ser maior que 0");
                break;

            default:
                for(int i=1; n > 0; i++) {
                    if(i%m == 0){
                        System.out.println(i);
                        n--;
                    }
                }
        }
    }
}
