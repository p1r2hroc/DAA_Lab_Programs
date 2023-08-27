import java.util.*;
public class KnapsackGreedy
{

    static double[] greed(double p[],double w[],double m)
    {
        int i;
        for(i=0;i<p.length-1;i++)
        {
            int max=i;

            for(int j=i+1;j<p.length;j++)
            {
                if((p[j]/w[j])>(p[max]/w[max]))
                    max=j;
            }
            double temp=w[i];
            w[i]=w[max];
            w[max]=temp;
            temp=p[i];
            p[i]=p[max];
            p[max]=temp;
        }

        double x[]=new double[p.length];
        for(i=0;i<x.length;i++)
            x[i]=0;
        double u=m;
        for(i=0;i<p.length;i++)
        {
            if(w[i]>u)
                break;
            x[i]=1;
            u=u-w[i];
        }

        if(i<=p.length) x[i]=u/w[i];
        return x;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the knapsack");
        int m = sc.nextInt();

        System.out.println("Enter the number of items available");
        int n = sc.nextInt();

        System.out.println("Enter the profit list for the available items");
        double p[] = new double[n];

        for (int i = 0; i < n; i++)
            p[i] = sc.nextDouble();
        System.out.println("Enter the weight list for the available items");

        double w[] = new double[n];
        for (int i = 0; i < n; i++)
            w[i] = sc.nextDouble();
        double x[] = greed(p, w, m);
        System.out.println("Solution vector is given as follows");
        for(int i=0;i<x.length;i++)
            System.out.println(x[i]);
    }
}