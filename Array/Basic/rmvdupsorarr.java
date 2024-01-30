import java.util.Scanner;

public class rmvdupsorarr {
        public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
        remduplicate(arr);
        
        
        
}
    public static void remduplicate(int[] arr)
    {
        int x = 0;
        for(int y = 1;y<arr.length;y++)
        {
            if(arr[x]!=arr[y])
            {
                arr[x+1] = arr[y];
                x++;

            }
        }
        System.out.println();
        for(int i=0;i<x+1;i++)     
        {
            System.out.print(arr[i]+" ");
        }
    }
}
