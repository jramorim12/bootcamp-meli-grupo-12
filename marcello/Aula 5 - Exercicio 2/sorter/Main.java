package sorter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        MyFactory myFactory = new MyFactory();

        // Ordenação Integers e Strings
        Integer[] integerArray = {599, 57, 3, 1, 19, 1097, 10};
        String[] stringsArray = {"Marcello", "Rodrigo", "João", "Lucas", "Gabriel" };

        MyComparator<Integer> integerComparator = new MyComparator<>();
        MyComparator<String> stringComparator = new MyComparator<>();

        Sorter bubbleSorter = (Sorter) myFactory.getInstance("bubblesort");
        Sorter quickSorter = (Sorter) myFactory.getInstance("quicksort");
        Sorter heapSorter = (Sorter) myFactory.getInstance("heapsort");

        bubbleSorter.sort(integerArray, integerComparator);
        quickSorter.sort(stringsArray, stringComparator);

        for(String s : stringsArray) {
            System.out.println(s);
        }

        System.out.println("\n");

        for(Integer i : integerArray) {
            System.out.println(i);
        }

        // Teste de performance

        Integer [] matriz = new Integer[5000];
        for(int i=0; i < matriz.length; i++) {
            matriz[i] = i+1;
        }

        Integer [] matriz2 = new Integer[5000];
        for(int i=0; i < matriz2.length; i++) {
            matriz2[i] = i+1;
        }

        Integer [] matriz3 = new Integer[5000];
        for(int i=0; i < matriz3.length; i++) {
            matriz3[i] = i+1;
        }

        quickSorter.sort(matriz,integerComparator);
        heapSorter.sort(matriz2, integerComparator);
        bubbleSorter.sort(matriz3, integerComparator);
    }

}
