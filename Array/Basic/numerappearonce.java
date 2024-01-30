import java.util.Scanner;

public class numerappearonce {
    public static void main(String[] args) {
        
    
     Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.println("Before : ");
        System.out.println();
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
        int ans = oncenum(arr);
        System.out.println(ans);

}

public static int oncenum(int[] arr){
    int ans = 0;
    for(int num:arr)
    {
        ans^=num;
    }
    return ans;
}
}
