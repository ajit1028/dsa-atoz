import java.util.Scanner;

public class leftrotation {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.print("Before Rotation : ");
        System.out.println();
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
        int r = input.nextInt();
        int[] rotarr = rot(arr,0,size - 1,r);
         System.out.print("After Rotation : ");

         for(int i=0;i<size;i++)     
         {
             System.out.print(arr[i]+" ");
         }
    }
    public static int[] rot(int[]arr,int i, int j,int r)
    {
        int n =arr.length;
      //  r = -r; for right rotation
        r = r%n;
        if(r<0) r=r+n;
        
        rev(arr,i,j);
        rev(arr,i,n-r-1);
        rev(arr,n-r,n-1);


        return arr;
    }

    public static void rev(int[] arr,int i,int j)
    {
        while(i<=j)
        {
            int ele = arr[i];
            arr[i] = arr[j];
            arr[j] = ele;
            
            i++;
            j--;
        }
       
    }
}
