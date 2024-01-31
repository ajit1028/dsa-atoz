import java.util.Scanner;

public class rearrangePosNegOrderPreserved{
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }
        int[] newArr = solve(arr);

        for(int i=0;i<newArr.length;i++)
        {
           System.out.print(newArr[i]+" ");
        }
}

   
   public static int[] solve(int [] arr)
   {
     int posIndex= 0,negIndex=1;
     int[] ans = new int[arr.length];
     for(int i=0;i<arr.length;i++)
     {
        if(arr[i]<0)
        {
            ans[negIndex]=arr[i];
            negIndex += 2;
        }
        else
        {
            
            ans[posIndex]=arr[i];
            posIndex += 2;
        }
     }
    return ans;
   }
}