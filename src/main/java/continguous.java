/*import java.io.*;
public class continguous {
    public void add(int [] array)
    {
        int i,j;
        int [] a=new int[10];
        int s=0,max=0;
        int k=0;
        int [] m=new int[10];
        for(i=0;i<10;i++)
        {
            s=array[i];
            a[k++]=i;
            for(j=i+1;j<10;j++)
            {
                s=s+array[j];
                a[k++]=j;
                if(s>max)
                {
                    max=s;
                    int z;
                    for(z=0;z<k;z++)
                    {
                        m[z]=a[z];
                    }
                }
            }
        }
        System.out.println("Maximum sum ="+s);
        for(i=0;i<10;i++)
        {
            System.out.print(array[a[i]]+"+");
        }
        System.out.println();
    }
    public static void main(String [] args)throws IOException
    {
        int [] array=new int[10];
        int i;
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
        for(i=0;i<10;i++)
        {
            System.out.println("Enter array elements");
            array[i]=Integer.parseInt(br.readLine());
        }
        continguous obj=new continguous();
        obj.add(array);
    }

}*/

