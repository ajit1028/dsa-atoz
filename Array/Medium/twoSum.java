import java.util.Arrays;
import java.util.Scanner;

public class twoSum{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }
        System.out.println("inter target");
        int target = input.nextInt();
        int[] newArr = sum(arr,target);
        System.out.println(newArr[0]+" "+newArr[1]);
 
    }
    //o(n^2)
    // public static int[] sum(int[]arr,int target)
    // {
    //     for(int i=0;i<arr.length;i++)
    //     {
            
    //         for(int j=i+1;j<arr.length;j++)
    //         {
    //             if(arr[i]+arr[j]==target)
    //             {
    //               return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }
   

    //o(nlogn + n)
    public static int[] sum(int[]arr,int target)
    {
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;
        int sum=0;
        while(left<right)
        {
            sum = arr[left] +arr[right];
            if(sum == target)
            {
                return new int[]{left,right};
            }
            else if(sum < target) left++;
            else right--;
        }
       
        return new int[]{-1,-1};
    }


}