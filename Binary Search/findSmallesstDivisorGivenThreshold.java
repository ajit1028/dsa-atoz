import java.util.Scanner;

public class findSmallesstDivisorGivenThreshold {
     public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
         
         int[] arr = new int[n];
         for(int i =0;i<n;i++)
         {
            arr[i] = scn.nextInt();
         }
        
         System.out.println(smallestDivisor(arr));
    }
    public static  int max(int[] arr)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            maxi=Math.max(maxi,arr[i]);
            
        }
        return maxi;
    }
    public static int sod(int[] arr,int div)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
             sum+=Math.ceil((double)arr[i]/(double)div);
        }
        return sum;
    }
    public static  int smallestDivisor(int[] arr, int tar) {
        
        int n= arr.length,ans=-1;
    
        int low=1,high=max(arr);
        while(low<=high)
        {
           int mid=(low+high)/2;
            if(sod(arr,mid) <=tar)
            {
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
        
    }
}
