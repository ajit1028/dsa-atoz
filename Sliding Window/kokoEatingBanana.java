import java.util.Scanner;

public class kokoEatingBanana {
     public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
         
         int[] arr = new int[n];
         for(int i =0;i<n;i++)
         {
            arr[i] = scn.nextInt();
         }
         int h = scn.nextInt();
         System.out.println(koko(arr,h));
    }

    public static int  max(int[]arr)
    {
        int maxi =arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>maxi)
            {
                maxi =arr[i];
            }
        }
        return  maxi;
    }
      
    public static int calculateTotalHour(int[] arr,int hour)
    {
        int totalH = 0;
        for(int i=0;i<arr.length;i++)
        {
            totalH += Math.ceil((double)arr[i]/(double)hour);
        }
        return totalH;
    }
    public static int koko(int[]arr,int h){
           int low =0,high = max(arr);
           while(low<=high)
           {
            int mid = (low+high)/2;
            int totalhour = calculateTotalHour(arr,mid);
            
           if(totalhour <= h)
           {
            high = mid-1;
           }
           else
              low = mid+1;
           }

           return low;

    }
}
