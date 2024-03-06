import java.util.Scanner;
public class segnegpos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        
        System.out.print("Enter Elements :");
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }

        int[] segarr = seg(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

    public static void swap(int[] arr,int i,int j)
    {
        int ele = arr[i];
        arr[i] = arr[j];
        arr[j] = ele;
    }

    //seg negative positive
    public static int[] seg(int[] arr)
    {
        int itr = 0,ptr=-1;
        while(itr<arr.length)
        {
            if(arr[itr] < 0)
            {
                
                swap(arr,++ptr,itr);
            }
            itr++;
        }

    //     public static int[] seg(int[] arr)
    //     {
    //         int itr = 0,ptr=-1;
    //         while(itr<arr.length)
    //         {
    //             if(arr[itr] == 0)
    //             {
                    
    //                 swap(arr,++ptr,itr);
    //             }
    //             itr++;
    //         }
        return arr;
    }
}
