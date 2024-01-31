import java.util.Scanner;

public class searchInRotated {
    
    public static void main(String[] args)
     {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        int target = input.nextInt();
         search(arr,target);
    }
    public static void search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
      
        while(left<=right){
          int  mid = left+(right-left)/2;
            if(nums[mid] == target) {
                System.out.println(mid);
                return;}
           
            if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target <=nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target <=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
    }
     System.out.println(-1);  
}
 }

