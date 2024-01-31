import java.util.Scanner;

public class majorityElement {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }
         majority(arr);
        
}

    //o(n^2)
    //  public static int[] majority(int[]arr,int n)
    //  {
    //     int count =0;
    //     for(int i=0;i<n;i++)
    //     {
    //         count =0;
    //         for(int j=0;j<n;j++)
    //         {
    //             count++;
    //         }
    //         if(count > n/2) return new int[]{arr[i]};
    //     }
        
    //     return new int[]{-1};
      
    //  }


    public static  void majority(int[] v) {
      
        int element = 0;
        int count = 0;
      

        for(int i : v){
            if(count == 0){
                count = 1;
                element = i;
            }
            else if (i == element) count++;
            else count--;
        }
        count = 0;
        for(int i : v){
            if(i == element) count++;
        }
        if(count > (v.length/2))  System.out.println("majority"+element);
        else System.out.println(-1);
        
    }
          

        
           
        
        
    

}
