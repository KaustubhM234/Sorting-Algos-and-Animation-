package Sort;

public class Quick {
    static long start = System.nanoTime();
    public static int partition(int arr[], int low, int high) 
    {
        int pivot = arr[high];
        int i = (low-1);      
        for (int j=low; j<high; ++j)
        {
            if (arr[j] <= pivot)
            {
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[++i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void sort(int arr[], int low, int high) 
    {
        if (low >= high) return;
        
        int pi = partition(arr, low, high);
        sort(arr, low, pi - 1);
        sort(arr, pi + 1, high);
    }
    static long end = System.nanoTime();

    public static void quicksort(int[] arr, int n) 
    {
        int i;
        Quick.sort(arr, 0, n-1);
        System.out.print("\nSorted array using QUICK SORT :");
        for (i = 0; i < n; ++i) System.out.print(" " + arr[i]);
        System.out.println("\nTime elapsed = "+(end-start));
    }
}

