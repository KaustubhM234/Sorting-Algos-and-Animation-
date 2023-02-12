package Sort;

public class Bucket {
    public static void buck(int arr[] , int n )
    {
        int k;
     
        int b[][]= new int[5][600];

        int c[] = new int[600];
        c[0]=0;c[1]=0;c[2]=0;c[3]=0;c[4]=0;
        long start = System.nanoTime();
        for(int i=0;i<n;i++)
        { 
            if(arr[i]/600==0)
            {
                b[0][c[0]]=arr[i];   
                c[0]++;
            }
            else if(arr[i]/600==1)
            {
                b[1][c[1]]=arr[i];
                c[1]++;
            }
            else if(arr[i]/600==2)
            {
                b[2][c[2]]=arr[i];
                c[2]++;
            }
            else if(arr[i]/600==3)
            {
                b[3][c[3]]=arr[i];
                c[3]++;
            }
            else if(arr[i]/600==4)
            {
                b[4][c[4]]=arr[i];
                c[4]++;
            }
            else
            {
                System.out.println("Entered data exceeds limit(1<=arr[i]<=100)");
            }
                
        }

        for(k=0;k<=4;k++)
        {
            if(c[k]>0)
            {
                for(int i=0;i<c[k];i++)
                {
                    int min=i;
                    for(int j=i+1;j<c[k];j++)
                    {
                        if(b[k][min]>b[k][j])
                        {
                            min = j;
                        }
                    }
                    int temp = b[k][i];
                    b[k][i]  = b[k][min];
                    b[k][min] = temp;
                }
            }
        }
        long end = System.nanoTime(); 

        System.out.println("Sorted Data using BUCKET SORT:");
        for(k=0;k<=4;k++)
        {
            if(c[k]>0)
            {
                for(int i=0;i<c[k];i++)
                {
                    System.out.print(b[k][i]+" ");
                }
            } 
        }
        System.out.println("\nTime elapsed = "+(end-start));        
    }
}
