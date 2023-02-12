import java.util.Random;
import java.util.Scanner;

import Sort.*;
public class Program2{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter Size of Array:");
        int Size = sc.nextInt();
        int Array[] = new int[Size];
        for(int i=0; i<Size; i++)
        {
            Array[i] = r.nextInt(3000);
            System.out.println(Array[i]);
        }
        // if(Size<=100){
        //     Bucket.buck(Array , Size);
        // }
        // else if(Size>100 && Size<=200){
        //     Selection.sel(Array, Size);
        // }
        // else if(Size> 200 && Size<=3000)
        // {
            int i,j;
            int temp;
            int flag=0;
            for(i=0;i<Size-1;i++)
            {

                for( j=0;j<Size-i-1;j++)
                {
                    if(Array[j]>Array[j+1])
                    {
                        temp = Array[j];
                        Array[j]=Array[j+1];
                        Array[j+1]=temp;
                        flag++;
                    }
                }
            }
            if(flag<=(Size/30))
            {
                Bubble.bubble(Array , Size);
            }
            else if(flag<=Size/20)
            {
                Selection.sel(Array, Size);
            }
            else if(flag<=(Size/10))
            {
                Insertion.ins(Array ,Size);
            }
            else if(Size<=1000 && flag<=Size/3)
            {
                Merge.m(Array, Size);
            }
            else if(flag<=Size/2)
            {
                Merge.m(Array, Size);
            }
            else 
            {
                Quick.quicksort(Array, Size);
            }
        }

    }

