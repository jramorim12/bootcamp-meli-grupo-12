import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args){
        int n;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Insira o valor de n:");
        n = keyboard.nextInt();

        for(int i=2; n > 0; i = i+2) {
            System.out.println(i);
            n--;
        }
    }
}
