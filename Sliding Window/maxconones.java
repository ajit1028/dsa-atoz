import java.util.Scanner;

public class maxconones {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)     
        {
            arr[i]=input.nextInt();
        }
        findMaxConsecutiveOnes(arr);
       findMaxConsecutiveOnesII(arr);
       int k = input.nextInt(); ///only for findMaxConsecutiveOnesIII

       findMaxConsecutiveOnesIII(arr,k);

    }
    public static  void findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length,si=0,ei=0,len=0,count=0;
        while(ei<n)
        {
            if(arr[ei]==0) count++;

            ei++;
            
            while(count > 0)
            {
                if(arr[si]==0) count--;
                si++;
            }
            
            
            len=Math.max(len,ei-si);
            
        }
    }
        public static  void findMaxConsecutiveOnesII(int[] arr) {
            int n=arr.length,si=0,ei=0,len=0,count=0;
            while(ei<n)
            {
                if(arr[ei]==0) count++;
    
                ei++;
                
                while(count >  1)
                {
                    if(arr[si]==0) count--;
                    si++;
                }
                
                
                len=Math.max(len,ei-si);
                
            }
            }
        public static  void findMaxConsecutiveOnesIII(int[] arr,int k) {
                int n=arr.length,si=0,ei=0,len=0,count=0;
                while(ei<n)
                {
                    if(arr[ei]==0) count++;
        
                    ei++;
                    
                    while(count > k)
                    {
                        if(arr[si]==0) count--;
                        si++;
                    }
                    
                    
                    len=Math.max(len,ei-si);
                    
                }
        System.out.println(len);
    }
}
