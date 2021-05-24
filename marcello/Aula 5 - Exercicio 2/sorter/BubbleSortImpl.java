package sorter;

public class BubbleSortImpl<T extends Comparable<T>> implements Sorter<T> {

    private MyComparator<T> comparator;
    private Timer bubbleSortTimer = new Timer();

    @Override
    public void sort(T[] array, MyComparator<T> comparator) {
        this.bubbleSortTimer.start();
        this.comparator = comparator;
        bubbleSort(array);
        this.bubbleSortTimer.stop();
        System.out.println("Tempo decorrido para BubbleSort: " + this.bubbleSortTimer.elapsedTime());
    }

    public void bubbleSort(T[] array) {

        T aux;

        for (T genericElement : array) {
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                }
            }
        }

    }


}
