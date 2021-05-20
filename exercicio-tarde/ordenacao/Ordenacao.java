package ordenacao;

import java.util.Arrays;
import java.util.Collections;

public class Ordenacao {

    

    public static void main(String[] args) {
        Ordenacao.crescentOrder();
        Ordenacao.decrescentOrder();
    }

    public static void crescentOrder() {
        Integer[] array = {52,10,85,1324,1,13,62,30,12,127};
        Arrays.sort(array);
        Ordenacao.printArray(array);
    }

    public static void decrescentOrder() {
        Integer[] array = {52,10,85,1324,1,13,62,30,12,127};
        Arrays.sort(array, Collections.reverseOrder());
        Ordenacao.printArray(array);
    }

    public static void printArray(Integer[] array) {
        System.out.print("[ ");
        for(Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}
