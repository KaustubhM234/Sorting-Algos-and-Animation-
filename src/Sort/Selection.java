package Sort;

public class Selection
{
    public static void sel(int arr[],int n)
    {
        long start = System.nanoTime();
        for(int i=0;i<n;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[min]>arr[j])
                {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        long end = System.nanoTime();
        
        System.out.println("Sorted Data SELECTION SORT :");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println("\nTime elapsed = "+(end-start));   
    }        
}
