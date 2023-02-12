package Sort;

public class Merge 
{    
    public static void m(int arr[],int n) 
    {    
        divide(arr, 0, n-1);
        
        System.out.print("\nSorted array using MERGE SORT :");
        for (int i = 0; i < n; ++i) 
        {
          System.out.print(" " + arr[i]);
        }
        System.out.println("\nTime elapsed = "+(end-start)); 
    }
    static long start = System.nanoTime();
    static void divide(int arr[], int start, int end) 
    {
        if (start >= end) return;
        
        int mid = (end - start) / 2 + start;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }
    
    static void conquer(int array[], int p, int q, int r) 
    {
        int n1 = q - p + 1;
        int n2 = r - q;
    
        int L[] = new int[n1];
        int M[] = new int[n2];
    
        for (int i = 0; i < n1; i++) 
        L[i] = array[p + i];
        for (int j = 0; j < n2; j++) 
        M[j] = array[q + 1 + j];
    
        int i, j, k;
        i = 0;
        j = 0;
        k = p;
    
        while (i < n1 && j < n2) 
        {
          if (L[i] <= M[j]) array[k++] = L[i++];
          else array[k++] = M[j++];
        }
    
        while (i < n1) 
        array[k++] = L[i++];
        while (j < n2) 
        array[k++] = M[j++];
  }
  static long end = System.nanoTime();

}

