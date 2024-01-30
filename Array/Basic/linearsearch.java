import java.util.Scanner;

public class linearsearch {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        System.out.println("Before : ");
        for(int i=0;i<size;i++)     
        {
            System.out.print(arr[i]+" ");
        }
        int ele=input.nextInt();

      boolean bool = search(arr,ele);
      System.out.println(bool);

       

}

public static boolean  search(int[] arr,int ele)
{
    
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i] == ele)
        {
           return true;

        }
        
        
    }
    return false;
}
}
