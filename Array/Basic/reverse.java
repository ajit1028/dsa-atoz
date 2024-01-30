import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.println("Before Rotation : ");
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
         int[] revarr = rev(arr,0,size - 1);
         System.out.println("After Rotation : ");

         for(int i=0;i<size;i++)     
         {
             System.out.print(arr[i]+" ");
         }
}
   public static int[] rev(int[] arr,int i,int j)
   {
       while(i<=j)
       {
           int ele = arr[i];
           arr[i] = arr[j];
           arr[j] = ele;
           
           i++;
           j--;
       }
       return arr;
   }
}
