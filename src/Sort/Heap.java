package Sort;

public class Heap 
{
    static long start = System.nanoTime();
    void maxheap(int array[], int n, int i)
    {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        
        if (left < n && array[left] > array[largest])  
            largest = left;    

        if (right < n && array[right] > array[largest])  
            largest = right; 

        if (largest != i) 
        {    
            int temp = array[i];  
            array[i] = array[largest];  
            array[largest] = temp;
            maxheap(array, n, largest);
        }          
    }  
    
    void sort(int array[], int n)
    {
        int i;
        for(i = n / 2 - 1; i >= 0; i--)
        {
            maxheap(array, n, i);
        }
        
        for(i=n-1; i>=0; i--)
        {
            int temp = array[0];
            array[0]=array[i];
            array[i]=temp;
            maxheap(array, i, 0);
            
        }
    }
    static long end = System.nanoTime();
    
    public static void output(int[] array,int n) 
    {
        Heap hs = new Heap();
        hs.sort(array, n);
        
        System.out.println("Sorted data using HEAP SORT : ");
        for(int i=0;i<n;i++) System.out.print(array[i]+" ");
        System.out.println("\nTime elapsed = "+(end-start));
    }
}
