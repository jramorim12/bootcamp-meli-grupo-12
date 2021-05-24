package precedenciaPessoa;

public class SortUtil {

    public <T> Precedente<T>[] sort(Precedente<T>[] array) {

        Precedente<T> aux;

        for(Precedente<T> genericElement : array) {
            for(int i=0; i < array.length - 1; i++) {
                if (array[i].precede((T) array[i+1]) > 0) {
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                }
            }
        }

        return array;
    }

}
