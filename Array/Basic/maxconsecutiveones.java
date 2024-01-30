import java.util.Scanner;

public class maxconsecutiveones {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.println("Before : ");
        System.out.println();
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
       int ans =  maxones(arr);
       System.out.println(ans);
}
   public static int maxones(int[] arr)
   {
    int max = 0,count=0;
    for(int i =0;i<arr.length;i++)
    {
        if(arr[i]==1)
        {
            count++;
            max = Math.max(max,count);
        }
        else{
            count=0;
        }
    }
    return max;
   }
}
