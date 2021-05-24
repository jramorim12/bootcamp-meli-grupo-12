package sorter;

import java.util.Comparator;

public class QuickSortImpl<T extends Comparable<T>> implements Sorter<T> {

    private Comparator<T> comparator;
    public Timer quickSortTimer = new Timer();

    @Override
    public void sort(T[] array, MyComparator<T> comparator) {
        this.quickSortTimer.start();
        this.comparator = comparator;
        this.quickSort(array, 0, array.length - 1);
        this.quickSortTimer.stop();
        System.out.println("Tempo decorrido para QuickSort: " + this.quickSortTimer.elapsedTime());
    }

    private void quickSort(T[] array, int begin, int end) {

        int partition = partition(array, begin, end);

        if (partition - 1 > begin) {
            quickSort(array, begin, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(array, partition + 1, end);
        }

    }

    public int partition(T[] array, int begin, int end) {
        T pivot = array[end];

        for (int i = begin; i < end; i++) {
            if (this.comparator.compare(array[i], pivot) < 0) {
                T temp = array[begin];
                array[begin] = array[i];
                array[i] = temp;
                begin++;
            }
        }

        T temp = array[begin];
        array[begin] = pivot;
        array[end] = temp;

        return begin;
    }

}
