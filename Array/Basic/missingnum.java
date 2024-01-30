import java.util.Scanner;

public class missingnum {
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
          int num = missing(arr);
          System.out.println("missing num"+num);
}
    public static int missing(int[] arr)
    {
        // int n = arr.length,add=0;
        // int sum = n*((n+1)/2);
        // for(int i =0;i<n;i++)
        // {
        //     add+=arr[i];
        // }
        // return (sum-add);

        int n=arr.length,ans=n,i=0;
        while(i<n)
        {
            ans^=arr[i]^i;
            i++;
        }
        return ans;

    }
}
