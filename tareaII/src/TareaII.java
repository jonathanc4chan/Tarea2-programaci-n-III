import java.util.*;

public class TareaII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // permita que el usuario que ingrese los números a ordenar
        
        System.out.print("Ingrese los números separados por espacios: ");
        String input = scanner.nextLine();
        String[] strNumbers = input.split(" ");
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        // Solicitar al usuario que elija un método de ordenamiento
        System.out.println("Elija un método de ordenamiento:");
        System.out.println("1. Selection sort (selección)");
        System.out.println("2. Bubble sort (burbuja)");
        System.out.println("3. Insertion sort (inserción)");
        System.out.println("4. Merge sort (combinación)");
        System.out.println("5. Quick sort (rápida)");
        System.out.println("6. Heap sort (montón)");
        System.out.println("7. Counting sort (conteo)");
        System.out.println("8. Radix sort (raíz)");
        System.out.println("9. Bucket sort (cubo)");
        System.out.print("Ingrese el número correspondiente al método de ordenamiento: ");

        int choice = scanner.nextInt();

        // Ordenar la lista de números según el método elegido
        
        switch (choice) {
        case 1:
            System.out.println("Ordenando con Selection Sort...");
            selectionSort(numbers);
            break;
        case 2:
            System.out.println("Ordenando con Bubble Sort...");
            bubbleSort(numbers);
            break;
        case 3:
            System.out.println("Ordenando con Insertion Sort...");
            insertionSort(numbers);
            break;
        case 4:
            System.out.println("Ordenando con Merge Sort...");
            mergeSort(numbers);
            break;
        case 5:
            System.out.println("Ordenando con Quick Sort...");
            quickSort(numbers, 0, numbers.length - 1);
            break;
        case 6:
            System.out.println("Ordenando con Heap Sort...");
            heapSort(numbers);
            break;
        case 7:
            System.out.println("Ordenando con Counting Sort...");
            countingSort(numbers);
            break;
        case 8:
            System.out.println("Ordenando con Radix Sort...");
            radixSort(numbers);
            break;
        case 9:
            System.out.println("Ordenando con Bucket Sort...");
            bucketSort(numbers);
            break;
        default:
            System.out.println("Opción no válida.");
            return;
    }

       
        System.out.println("numeros ordenados: " + Arrays.toString(numbers));
    }

    // Métodos de ordenamiento
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println("Después de seleccionar el mínimo en el índice " + minIndex + ": " + Arrays.toString(arr));
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Después de intercambiar " + arr[j] + " y " + arr[j+1] + ": " + Arrays.toString(arr));
                }
            }
        }
    }
   
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("Después de insertar " + key + " en su posición correcta: " + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
            System.out.println("Después de combinar: " + Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
        

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            System.out.println("Después de particionar con pivote " + arr[pi] + ": " + Arrays.toString(arr));
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
       
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
           
            heapify(arr, i, 0);
            System.out.println("Después de extraer el máximo: " + Arrays.toString(arr));
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

       
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

       
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

           
            heapify(arr, n, largest);
        }
    }

    public static void countingSort(int[] arr) {
        int n = arr.length;
        
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

       
        int[] count = new int[max - min + 1];

        
        for (int num : arr) {
            count[num - min]++;
        }
        System.out.println("Arreglo de conteo: " + Arrays.toString(count));

       
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        System.out.println("Arreglo de conteo acumulado: " + Arrays.toString(count));

        
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

      
        System.arraycopy(output, 0, arr, 0, n);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
            System.out.println("Después de ordenar por el dígito " + exp + ": " + Arrays.toString(arr));
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int value : arr) {
            count[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void bucketSort(int[] arr) {
        
        if (arr.length == 0) {
            return;
        }

        
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        
        int bucketSize = 10;

        
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        System.out.println("Distribuyendo los elementos en los cubos:");
        for (int num : arr) {
            int bucketIndex = (num - min) / bucketSize;
            System.out.println("Elemento " + num + " en cubo " + bucketIndex);
            buckets.get(bucketIndex).add(num);
        }

        
        System.out.println("\nOrdenando cada cubo:");
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
            System.out.println("Cubo ordenado: " + bucket);
        }
    }
}