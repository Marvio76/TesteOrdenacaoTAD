public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(vetor, inicio, fim);
            sort(vetor, inicio, pivoIndex - 1);
            sort(vetor, pivoIndex + 1, fim);
        }
    }

    private static <T extends Comparable<T>> int particionar(T[] vetor, int inicio, int fim) {
        T pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].compareTo(pivo) <= 0) {
                i++;
                T temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        T temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}
