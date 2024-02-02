import java.util.Scanner;

public class countNumOfNiceSubArrays {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(numberOfSubarrays(arr, k));
    }

    public static int atMostOdd(int[] arr, int k) {
        int n = arr.length, si = 0, ei = 0, count = 0, ans = 0;
        while (ei < n) {
            if ((arr[ei])%2 != 0)
            {
                count++;
              //  System.out.println((arr[ei] & 1));
            }
            ei++;
                

            while (count > k) {
                if ((arr[si])%2 != 0)
                    count--;

                si++;
            }

            ans += ei - si;
        }

        return ans;
    }

    public static  int numberOfSubarrays(int[] nums, int k) {
        return atMostOdd(nums, k) - atMostOdd(nums, k - 1);
    }
}
