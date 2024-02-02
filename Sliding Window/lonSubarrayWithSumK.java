import java.util.Scanner;

public class lonSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of The array");
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println( longestSubarraySumK(arr,n,k));
    }
    //o(2N)
    public static int longestSubarraySumK(int[]arr, int n,int k)
    {
      int left =0,right=0,maxlen=0;
      int sum =arr[0];
      while(right < n)
      {
           while(left <= right && sum > k)
           {
               sum -= arr[left];
               left++;
           }

           if(sum == k)
           {
            maxlen =  Math.max(maxlen, right-left+1);

           }
           right++;

           if(right< n)
           {
            sum += arr[right];
           }
      }

        return maxlen;

    }
}
