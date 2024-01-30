
import java.util.*;

public class seclar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }

        int max = arr[0];
        int smax = -1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max){
                smax = max;
                max= arr[i];
            }
            else if(arr[i] < max && arr[i]>smax)
              smax = arr[i];
        }
        System.out.println("largest"+max);

       
        System.out.println("seclar"+smax);

    }
}



