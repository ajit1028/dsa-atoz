import java.util.Scanner;

public class firstlastoccurance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        int target = input.nextInt();
        int[] ans = searchRange(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int lowerBound(int []arr, int target) {
        int n= arr.length;
        int low =0,high=n-1;
        int ans =n;

        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>=target)
            {
                 ans=mid;
                high = mid-1;
               
            }
            else
                low = mid+1;
        }
        return ans;

    }

    public static int upperBound(int []arr,  int target){
          int n= arr.length;
          int low =0,high=n-1;
          int ans =n;

        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>target)
            {
                 ans=mid;
                high = mid-1;
               
            }
            else
                low = mid+1;
        }
        return ans;

    }
    public static  int[] searchRange(int[] arr, int target) {
       
        int n=arr.length;
         int lb = lowerBound(arr,target);
        if(lb ==n || arr[lb]!= target) return new int[]{-1,-1};
        return new int[]{lb,upperBound(arr,target) - 1};
    }
}
