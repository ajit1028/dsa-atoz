import java.util.Scanner;

public class findInMinRotSorted{
     public static void main(String[] args)
     {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
    
        findMin(arr);
    }
    public static  void findMin(int[] arr) {
        int n=arr.length,low =0,high=n-1;
       int ans = Integer. MAX_VALUE;
   
       while(low<=high)
       {
           int mid=(high+low)/2;
           
           if(arr[low]<=arr[mid]) 
           {
               ans = Math.min(ans,arr[low]);
               low=mid+1;
           }
           
           else 
           {
               high = mid-1;
               ans = Math.min(ans,arr[mid]);
           }
           
           
       }
     System.out.println(ans);
   }

}