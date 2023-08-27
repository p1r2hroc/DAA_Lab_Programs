import java.util.*;
public class MergeSort
{
    public static void divide(int array[],int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        int mid = start+(end-start) / 2;

        divide(array,start,mid);
        divide(array,mid+1,end);
        conquer(array,start,mid,end);
    }

    public static void conquer(int array[],int start,int mid,int end)
    {
        int merged[]=new int [end-start+1];
        int index1=start;
        int index2=mid+1;
        int x=0;

        while(index1<= mid && index2<=end)
        {
            if(array[index1] <= array[index2])
            {
                merged [x++] = array[index1++];
            }
            else
            {
                merged [x++] = array[index2++];
            }
        }
        while(index1 <= mid)
        {
            merged [x++] = array[index1++];
        }
        while(index2 <= end)
        {
            merged [x++] = array[index2++];
        }
        for(int i=0, j=start; i<merged.length; i++,j++)
        {
            array[j] = merged [i];
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

        divide(array,0,n-1);

        long end=System.nanoTime();

        System.out.println();
        System.out.print("Sorted array is : ");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");

        System.out.println();
        System.out.println("Total time is "+(end-start)+"ns");
    }
}