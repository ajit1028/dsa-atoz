import java.util.Scanner;
public class maxSubArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of The array");
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = input.nextInt();
        }

//System.out.println(subArray(arr,n));
                   int[] idx = subArrayIdx(arr, n);
                   System.out.println("["+idx[0]+","+idx[1]+"]");
        
    }

    //for positive only
    // public static int subArray(int[] arr,int n)
    // {
    //     int globalSum = 0,currentSum=0;

    //     for(int i = 0;i<n;i++)
    //     {
    //         currentSum  += arr[i];
    //         if(currentSum > globalSum)
    //         {
    //             globalSum = currentSum;

    //         }

    //         if(currentSum <= 0)
    //         {
    //             currentSum = 0;
    //         }
    //     }
    //     return globalSum;
    // }

   //for negative & positive both 
//     public static int subArray(int[] arr) {
//         int globalSum = -(int)1e9, currentSum = 0;
//         for(int ele : arr)
//         {
//             currentSum = Math.max(ele, currentSum+ele);
//             globalSum = Math.max(globalSum,currentSum);
//         }
//         return globalSum;
//  }


//for positive result idx of maxsubarray
public static int[] subArrayIdx(int[] arr,int n) {
    int gsum=0, csum = 0,gsi=0,gei=0,csi=0;
    for(int i=0;i<arr.length;i++)
    {
        int ele = arr[i];
        csum += ele;
        if(csum>gsum)
        {
            gsum = csum;
            gsi = csi;
            gei = i;
        }

        if(csum <= 0)
        {
            csum = 0;
            csi = i+1;
        }
    }
     return new int[]{gsi,gei};
    
}


}
