import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>{

    Comparator<T> t;

    @Override
    public void Sorter(T[] arr, Comparator<T> c) {
        this.t = c;
        quickSort(arr, 0, arr.length -1);
    }

    public void quickSort(T arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(T arr[], int begin, int end) {
        T pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (this.t.compare(arr[j], pivot) < 0) {
                i++;

                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
