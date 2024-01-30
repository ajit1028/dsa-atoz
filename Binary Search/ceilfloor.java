import java.util.Scanner;

public class ceilfloor {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        int target = input.nextInt();
        int ans = floor(arr,target,size);
        System.out.println(ans);
    }
    // ceil is same as lower bound
    
    public static  int floor(int[] arr, int target,int n) {
        int ans = n,low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=target)
            {
                ans =arr [mid];
                low = mid+1;

            }
            else{
                high=mid-1;
                
            }
        }
        


        return ans;
    }
}
