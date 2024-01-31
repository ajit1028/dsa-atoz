import java.util.Scanner;

public class singleElementInSorted {
     public static void main(String[] args)
     {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
    
        singleNonDuplicate(arr);
    }
    public static void  singleNonDuplicate(int[] arr) {
        int n= arr.length;
        if(n==1) {System.out.println(arr[0]); 
        return;}
        if(arr[0]!=arr[1]){System.out.println(arr[0]); 
            return;}
        if(arr[n-1]!=arr[n-2]){System.out.println(arr[n-1]); 
            return;}
        
        
        int low=1,high=n-2;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]) { 
                System.out.println(arr[mid]); 
                return;
            }
            
            //left half
            if((mid%2 == 1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid] == arr[mid+1]))
                low=mid+1;//eleminte left half
            
            else
                high = mid -1; //elemintae right half
            
        }
        System.out.println(-1); 
}
}
