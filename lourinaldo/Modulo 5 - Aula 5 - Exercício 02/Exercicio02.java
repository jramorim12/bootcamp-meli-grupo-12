import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class Exercicio02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Timer timer = new Timer();

        Integer[] arr = new Integer[5000];

        for(int i = 5000; i>0; i--){
            arr[5000-i] = i;
        }

        Comparator<Integer> c = (x,y) -> x-y;

        Sorter sorter = (Sorter) MyFactory.getInstance("Heap");

        timer.start();
        sorter.Sorter(arr, c);
        timer.stop();

        System.out.println("Tempo decorrido: " + timer.elapsedTime() + "ms");

    }
}
