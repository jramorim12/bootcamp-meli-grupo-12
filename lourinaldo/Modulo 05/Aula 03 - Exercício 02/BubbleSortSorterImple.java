import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T>{

    Comparator<T> t;

    @Override
    public void Sorter(T[] arr, Comparator<T> c) {
        this.t = c;
        bubbleSort(arr);
    }

    public void bubbleSort(T[] arr){
        boolean sorted = false;
        T temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (this.t.compare(arr[i], arr[i+1]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
