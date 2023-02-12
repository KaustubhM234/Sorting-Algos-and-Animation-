package Sort;

public class Insertion 
{
    public static void ins(int Array[], int Size)
    {
        int i,j;
        long start = System.nanoTime();
        for (i = 1; i < Size; i++) 
        {
            int temp = Array[i];
            j = i - 1;
  
            while (j >= 0 &&  Array[j] > temp)
            {
                Array[j + 1] = Array[j];
                j--;
            }
            
            Array[j+1] = temp;
        }
        long end = System.nanoTime();

        System.out.println("Sorted Data INSERTION SORT :");
        for( i=0;i<Size;i++)
        {
            System.out.print(Array[i]+" ");
        }

        System.out.println("\nTime elapsed = "+(end-start));   
    }    
}
