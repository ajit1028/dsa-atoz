import java.util.Scanner;

public class searchinsertposition {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        int target = input.nextInt();
        int ans = searchInsert(arr,target,size);
        System.out.println(ans);
    }
    public static  int searchInsert(int[] arr, int target,int n) {
        int ans = n,low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=target)
            {
                ans = mid;
                high = mid-1;

            }
            else{
                low=mid+1;
                
            }
        }
        


        return ans;
    }

}
