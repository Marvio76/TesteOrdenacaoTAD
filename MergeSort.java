public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            sort(vetor, inicio, meio);
            sort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        T[] left = java.util.Arrays.copyOfRange(vetor, inicio, meio + 1);
        T[] right = java.util.Arrays.copyOfRange(vetor, meio + 1, fim + 1);

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                vetor[k++] = left[i++];
            } else {
                vetor[k++] = right[j++];
            }
        }

        while (i < n1) vetor[k++] = left[i++];
        while (j < n2) vetor[k++] = right[j++];
    }
}
