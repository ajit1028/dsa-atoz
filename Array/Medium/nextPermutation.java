import java.util.Scanner;

public class nextPermutation {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = input.nextInt();
        }
        nxp(arr);
        for(int i=0;i<arr.length;i++)
        {
          System.out.print(arr[i]+" ");
        }
}


public static void nxp(int[] arr) {
    int index = -1;
   
    for(int i=arr.length-2;i>=0;i--)
    {
        if(arr[i]<arr[i+1])
        {
            index = i;
            break;
        }
    }
    if(index == -1){
         reverse(arr,0,arr.length-1);
         return;
    }



    int temp;
    for(int i=arr.length-1;i>=index;i--){
        if(arr[i]>arr[index]){
        temp=arr[i];
        arr[i]=arr[index];   
        arr[index]=temp;
        break;
        }
    }
    reverse(arr,index+1,arr.length-1);
}



public static void reverse(int[] arr, int i, int j) {
     while(i<j){
         int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;j--;
    }
}
}