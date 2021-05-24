package sorter;

public class HeapSortImpl<T extends Comparable<T>> implements Sorter<T> {

    private MyComparator<T> comparator;
    public Timer heapSortTimer = new Timer();

    @Override
    public void sort(T[] array, MyComparator<T> comparator) {
        this.heapSortTimer.start();
        this.comparator = comparator;
        heapSort(array);
        this.heapSortTimer.stop();
        System.out.println("Tempo decorrido para HeapSort: " + this.heapSortTimer.elapsedTime());
    }

    public void heapSort(T[] array) {
        int size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);

        for (int i = size - 1; i >= 0; i--) {

            T x = array[0];
            array[0] = array[i];
            array[i] = x;

            heapify(array, i, 0);
        }
    }

    void heapify(T[] array, int heapSize, int i) {
        int largest = i;
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        if (leftChildIdx < heapSize && (this.comparator.compare(array[leftChildIdx], array[largest]) > 0))
            largest = leftChildIdx;

        if (rightChildIdx < heapSize && (this.comparator.compare(array[rightChildIdx], array[largest]) > 0))
            largest = rightChildIdx;

        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
        }
    }

}
