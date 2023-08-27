import java.util.*;
public class Program2
{
    static  int partition(int[]array,int lower,int higher)
    {
        int pivot = array[(lower+higher)/2];

        while(lower<=higher)
        {
            while(array[lower]<pivot)
            {
                lower++;
            }
            while(array[higher]>pivot)
            {
                higher--;
            }
            if(lower<=higher)
            {
                int temp=array[lower];
                array[lower]=array[higher];
                array[higher]=temp;

                lower++;
                higher--;
            }
        }

        return lower;
    }

    static  void QuickSortRecursion(int[]array,int lower,int higher)
    {
        int pi = partition(array,lower,higher);

        if(lower<pi-1)
        {
            QuickSortRecursion(array,lower,pi-1);

        }
        if(pi<higher)
        {
            QuickSortRecursion(array,pi,higher);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("Enter the number of elements : ");
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=rand.nextInt(10000);
        }
        System.out.println();
        System.out.print("Unsorted array is : ");
        for(int i=0;i<n;i++)
            System.out.print(array[i] + " ");


        long start=System.nanoTime();

        QuickSortRecursion(array,0,array.length-1);

        long end=System.nanoTime();

        System.out.println();
        System.out.print("Sorted array is : ");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");

        System.out.println();
        System.out.println("Total time is "+(end-start)+"ns");
    }
}