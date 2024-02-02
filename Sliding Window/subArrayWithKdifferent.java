import java.util.Scanner;

public class subArrayWithKdifferent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(subarraysWithKDistinct(arr, k));
    }

    public static int atMostKDistinct(int[] arr, int k) {
        int[] freq = new int[20000 + 1];
        int n = arr.length, si = 0, ei = 0, count = 0, ans = 0;

        while (ei < n) {
            if (freq[arr[ei]] == 0)
                count++;
            freq[arr[ei]]++;
            ei++;

            while (count > k) {
                if (freq[arr[si]] == 1)
                    count--;
                freq[arr[si]]--;
                si++;
            }
            ans += ei - si;
        }

        return ans;
    }

    public static int subarraysWithKDistinct(int[] arr, int k) {
        return atMostKDistinct(arr, k) - atMostKDistinct(arr, k - 1);
    }
}
