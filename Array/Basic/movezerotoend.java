import java.util.Scanner;

public class movezerotoend {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.println("Before : ");
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }

        movezero(arr);

        System.out.println("After : ");
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }

}

public static void movezero(int[] arr)
{
    int x =0;
    for(int y=0; y<arr.length;y++)
    {
        if(arr[y]!=0)
        {
            arr[x]=arr[y];
            x++;
        }
    }
    while(x<arr.length)
    {
        arr[x] = 0;
        x++;
    }
}


}
