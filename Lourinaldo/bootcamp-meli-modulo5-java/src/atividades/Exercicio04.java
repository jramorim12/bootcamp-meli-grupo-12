package atividades;

import java.util.Scanner;


public class Exercicio04 {

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


        for(int i=2;n>0;i++){
            if(ehPrimo(i)) {
                System.out.println(i);
                n--;
            }
        }
    }
}