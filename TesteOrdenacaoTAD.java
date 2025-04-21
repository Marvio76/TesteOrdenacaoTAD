import java.util.Random;

public class TesteOrdenacaoTAD {

    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000, 300000, 800000, 1000000};
        int repeticoes = 10;

        for (int tamanho : tamanhos) {
            long[] tempos = new long[repeticoes];

            for (int i = 0; i < repeticoes; i++) {
                Pessoa[] vetor = gerarVetorAleatorio(tamanho);
                long inicio = System.currentTimeMillis();

               // QuickSort.sort(vetor, 0, vetor.length - 1);
                MergeSort.sort(vetor, 0, vetor.length - 1); // se quiser trocar

                long fim = System.currentTimeMillis();
                tempos[i] = fim - inicio;
            }

            double media = calcularMedia(tempos);
            double desvio = calcularDesvioPadrao(tempos, media);

            System.out.println("Tamanho: " + tamanho);
            System.out.println("Tempo médio: " + media + " ms");
            System.out.println("Desvio padrão: " + desvio + " ms\n");
        }
    }

    public static Pessoa[] gerarVetorAleatorio(int tamanho) {
        Pessoa[] vetor = new Pessoa[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = new Pessoa("Pessoa" + i, rand.nextInt(100000)); // faixa de idades maior pra variabilidade
        }
        return vetor;
    }

    public static double calcularMedia(long[] valores) {
        long soma = 0;
        for (long v : valores) {
            soma += v;
        }
        return (double) soma / valores.length;
    }

    public static double calcularDesvioPadrao(long[] valores, double media) {
        double soma = 0;
        for (long v : valores) {
            soma += Math.pow(v - media, 2);
        }
        return Math.sqrt(soma / valores.length);
    }
}
