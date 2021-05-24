import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T>{

    Comparator<T> t;

    @Override
    public void Sorter(T[] arr, Comparator<T> c) {
        this.t = c;
        heapSort(arr);
    }

    public void heapSort(T arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }


    void heapify(T arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && (this.t.compare(arr[l], arr[largest]) > 0))
            largest = l;

        if (r < n && (this.t.compare(arr[r], arr[largest]) > 0))
            largest = r;

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
