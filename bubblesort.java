import java.util.Random;

public class bubblesort {
    public static void main(String[] args) {
        int cont = 0;
        long[] tempos = new long[20];
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

            bubbleSort(v);

            long tempoFinal = System.currentTimeMillis();
            long tempoTotal = tempoFinal - tempoInicial;

            System.out.println("\nVetor depois da ordenação:");

            for (int num : v) {
                System.out.print(num + " ");
            }

            System.out.println("\nTempo total: " + tempoTotal + " milissegundos");
            tempos[cont] = tempoTotal;
            cont++;
            
        }
        for(int i = 0; i<=20; i++){
            System.out.print(tempos[i] + " ");
        }
        
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
