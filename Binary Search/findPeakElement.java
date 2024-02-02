import java.util.Scanner;
public class findPeakElement{
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         for(int i =0;i<n;i++)
         {
            arr[i] = scn.nextInt();
         }

         System.out.println(findPeak(arr,n));
    }
    public static  int findPeak(int[] arr,int n) {
        
        if(n==1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        
        int low=1,high =n-2;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid]>arr[mid-1]) low =mid+1;
            else high =mid-1;
        }
        return -1;
        
        
    } 
}