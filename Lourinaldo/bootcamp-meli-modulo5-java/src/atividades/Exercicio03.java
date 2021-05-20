package atividades;

import java.util.Scanner;


public class Exercicio03 {

    public static boolean ehPrimo(int n){

        for(int i = 2; i<n; i++)
            if(n%i == 0)
                return false;
        return true;
    }

    public static void main(String[] args){
        int n;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Insira o valor de n:");
        n = keyboard.nextInt();

        boolean b = ehPrimo(n);

        if(b){
            System.out.println("Eh primo");
        }else{
            System.out.println("Não eh primo");
        }

    }
}