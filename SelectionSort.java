import java.util.*;
public class SelectionSort
{
    static void selectionsort(int array[],int n)
    {

        int i,j,min,temp;

        for(i=0;i<n-1;i++)
        {
            min=i;

            for(j=i+1;j<n;j++)
            {
                if(array[j]<array[min])
                    min=j;
            }

            temp=array[i];
            array[i]=array[min];
            array[min]=temp;
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

        selectionsort(array,array.length);

        long end=System.nanoTime();

        System.out.println();
        System.out.print("Sorted array is : ");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");

        System.out.println();
        System.out.println("Total time is "+(end-start)+"ns");
    }
}