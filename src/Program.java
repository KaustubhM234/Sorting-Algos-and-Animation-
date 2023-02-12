import Sort.*;
import java.util.*;


public class Program
{
    public static void main(String[] args) throws Exception 
    {
        int Size,i,Ch;
        
            System.out.println("Enter size of array: ");
            Scanner sc = new Scanner(System.in);
            Size = sc.nextInt();
            int Array[] = new int[Size];
            int temp[] = new int[Size];
            System.out.println("Enter elements of array:");
            for(i=0;i<Size;i++)
            {
                Array[i] = sc.nextInt();
                temp[i] = Array[i];
            }
            System.out.println("Inserted array ");
            for(i = 0; i < Size; i++){
                System.out.print(Array[i]+" ");
            }
        do
        {    
            System.out.println("\nList of Sorting Methods:\n1.Bubble Sort\n2.Modified Bubble Sort\n3.Insertion Sort\n4.Selection Sort\n5.Bucket Sort\n6.Heap Sort\n7.Quick Sort\n8.Merge Sort\n9.EXIT\nEnter Your Choice:");
            Ch = sc.nextInt();

            switch(Ch)
            {
                case 1:
                    Bubble.bubble(Array,Size);
                    break;
                case 2:
                    Modified.mbubble(Array, Size);
                    break;
                case 3:
                    Insertion.ins(Array,Size);                
                    break;
                case 4:
                    Selection.sel(Array , Size);
                    break;
                case 5:
                    Bucket.buck(Array , Size);
                    break;
                case 6:
                    Heap.output(Array, Size);
                    break;
                case 7:
                    Quick.quicksort(Array, Size);
                    break;
                case 8:
                    Merge.m(Array, Size);
                    break;
                case 9:
                    System.out.println("Program Exited");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
            for(i=0;i<Size;i++)
            {
                Array[i] = temp[i];
            }
        }
        while(Ch!=9);        
    }
}
