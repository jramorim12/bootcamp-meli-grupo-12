import java.util.Scanner;


public class Exercicio05 {

    public static void main(String[] args){
        int n,m,d;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Insira o valor de n:");
        n = keyboard.nextInt();
        System.out.println("Insira o valor de m:");
        m = keyboard.nextInt();
        System.out.println("Insira o valor de d:");
        d = keyboard.nextInt();


        for(Integer i = 1; n>0; i++){

            String string = i.toString();
            long repetitions = string.chars().filter(ch -> ch == (char) (d + '0')).count();

            if(repetitions > (m-1)){
                System.out.println(i);
                n--;
            }

        }
    }
}