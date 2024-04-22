import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int cont = 0;
        long[] bubbleSortTimes = new long[20];
        long[] insertionSortTimes = new long[20];
        while (cont != 20) {
            int tamanho = 800000;
            int[] v = new int[tamanho]; 
            Random random = new Random();

            System.out.println("Vetor antes da ordenação:");

            for (int i = 0; i < tamanho; i++) {
                v[i] = random.nextInt(900000); 
                System.out.print(v[i] + " ");
            }

            long tempoInicial = System.currentTimeMillis();

            bubbleSortTimes[cont] = bubbleSort(v.clone());

            long tempoFinal = System.currentTimeMillis();
            long tempoTotalBubble = tempoFinal - tempoInicial;

            System.out.println("\nVetor depois da ordenação pelo Bubble Sort:");

            for (int num : v) {
                System.out.print(num + " ");
            }

            System.out.println("\nTempo total (Bubble Sort): " + tempoTotalBubble + " milissegundos");

            tempoInicial = System.currentTimeMillis();

            insertionSortTimes[cont] = insertionSort(v.clone());

            tempoFinal = System.currentTimeMillis();
            long tempoTotalInsertion = tempoFinal - tempoInicial;

            System.out.println("\nVetor depois da ordenação pelo Insertion Sort:");

            for (int num : v) {
                System.out.print(num + " ");
            }

            System.out.println("\nTempo total (Insertion Sort): " + tempoTotalInsertion + " milissegundos");

            cont++;
        }

        System.out.println("\nTempos de execução do Bubble Sort:");
        for(long time : bubbleSortTimes){
            System.out.print(time + " ");
        }

        System.out.println("\nTempos de execução do Insertion Sort:");
        for(long time : insertionSortTimes){
            System.out.print(time + " ");
        }
    }

    static long bubbleSort(int[] arr) {
        int n = arr.length;
        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal - tempoInicial;
    }

    static long insertionSort(int[] arr) {
        int n = arr.length;
        long tempoInicial = System.currentTimeMillis();
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal - tempoInicial;
    }
}