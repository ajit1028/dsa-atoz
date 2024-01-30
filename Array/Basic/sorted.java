import java.util.Scanner;

public class sorted {
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
        int count = 1;
        for(int i=1;i<size;i++)     
        {
            if(arr[1] > arr[0]){
               if(arr[i] > arr[i-1])
               count++ ;
               else
               break;
            }
            else{
                if(arr[i] < arr[i-1])
                count++ ;
                else
                break;
            }

        }
        if(count == arr.length)
           System.out.println("Array is Sorted");
        else
          System.out.println("not sorted");

         

    }
}
