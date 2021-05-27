import java.time.LocalDate;
import java.util.*;

public class Exercicios {

    public static void exercicio01(){

        Integer[] array = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};
        Arrays.sort(array);
        printArray(array);

        Arrays.sort(array, Collections.reverseOrder());
        printArray(array);
        System.out.println("");

    }

    public static void exercicio02(){

       double empresaX = 1.13;
       double empresaY = 18.4;
        int ano = 2021;


        while(empresaX < empresaY){

           System.out.println("Empresa X 01/01/"+ano+" - Valor da empresa: "+empresaX+"m");
           System.out.println("Empresa Y 01/01/"+ano+" - Valor da empresa: "+empresaY+"m");

           empresaX *= 2.48;
           empresaY *= 1.32;
           ano++;
       }

        System.out.println("Empresa X 01/01/"+ano+" - Valor da empresa: "+empresaX+"m");
        System.out.println("Empresa Y 01/01/"+ano+" - Valor da empresa: "+empresaY+"m"+"\n");
    }

    public  static void exercicio03(){

        Map<String, String> nome = Map.of("Produto 1", "Arroz",
                                         "Produto 2", "Feijão",
                                         "Produto 3", "Tomate");
        Map<String, Double> preco = Map.of("Produto 1", 10.99,
                                        "Produto 2", 14.49,
                                        "Produto 3", 9.99);
        Map<String, Integer> quantidade = Map.of("Produto 1", 2,
                                          "Produto 2", 1,
                                          "Produto 3", 5);
        Map<Integer, String> mapProdutos = Map.of(1, "Produto 1",
                                            2, "Produto 2",
                                            3, "Produto 3");

        double vt = 0.0;

        for(int i = 1; i<4; i++){
            System.out.println(mapProdutos.get(i));
            System.out.println("Nome: " + nome.get(mapProdutos.get(i)));
            System.out.println("Preço: R$ " + preco.get(mapProdutos.get(i)));
            System.out.println("Quantidade: " + quantidade.get(mapProdutos.get(i)) + "\n");
            vt += quantidade.get(mapProdutos.get(i)) * preco.get(mapProdutos.get(i));
        }

            System.out.println("Valor Total: R$ " + vt );

    }
    
    public static void printArray(Integer[] array){

        System.out.print("[ ");
        for(int n: array){
            System.out.print(n + " ");
        }

        System.out.println("]");


    }

    public static void main(String[] args) {
        Exercicios.exercicio01();
        Exercicios.exercicio02();
        Exercicios.exercicio03();
    }


}
