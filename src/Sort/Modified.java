package Sort;

public class Modified 
{
    public static void mbubble(int array[], int n) 
    {
        long start = System.nanoTime();   
        int i,j,flag=0;
        int temp;
        for(i=0;i<n-1;i++)
        {
            for( j=0;j<n-i-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag++;
                }
            }
            if(flag==0)
                break;
        }
        long end = System.nanoTime();
        System.out.println("Sorted Data using MODIFIED BUBBLE SORT :");
        for(i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("Flag = "+flag);
        System.out.println("\nTime elapsed = "+(end-start)); 
    }        
}
