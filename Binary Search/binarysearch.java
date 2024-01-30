import java.util.Scanner;

public class binarysearch {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        int n = input.nextInt();
        int ans = bsearch(arr,n);
        System.out.println(ans);

}
public static int bsearch(int[] arr,int n){
    
    int low =0;
    int high =arr.length-1;
    while(low <= high)
    {
        int mid = (low+high)/2;
        if(arr[mid] == n) return mid;
        else if( n > arr[mid]) low = mid+1;
        else 
         high = mid-1;
    }

   return -1;
}

    /*
     *  lowerbound(arr,target,n){
     *   int ans = n; 
     * while(low <= high)
    {
        int mid = (low+high)/2;
        if(arr[mid] >= target){//incase of upper bound (arr[mid]>target)
          mid;
          high = mid-1;}
        else 
         low = mid+1;
    }
    return ans;
   }
     */
}
