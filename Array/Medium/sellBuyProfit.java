import java.util.Scanner;

public class sellBuyProfit {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }
        profit(arr);
}
  public static void profit(int[] arr)
  {
    int mini = arr[0], profit =0,cost=0;
    for(int i=1;i<arr.length;i++)
    {
         cost = arr[i] - mini;
         profit = Math.max(profit,cost);
         mini = Math.min(mini,arr[i]);

    }
    System.out.println(profit); 
  }
}
