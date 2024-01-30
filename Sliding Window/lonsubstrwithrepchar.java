import java.util.Scanner;

public class lonsubstrwithrepchar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the String:");
        String str = input.nextLine();
           longsubstr(str);
        

    }

    public static void longsubstr(String str)
    {
        String s = str;
        int n = str.length(),si =0,ei=0,count =0,len=0;
        int[] freq = new int[128];
         while(ei<n)
         {
            if(freq[str.charAt(ei)] > 0)
             {
                count++;
             }

            freq[str.charAt(ei)]++;

            ei++;

            while(count > 0)
            {
                if(freq[str.charAt(si)] > 1)
                {
                    count--;
                }
                freq[str.charAt(si)]--;
                si++;
            }

            len =Math.max(len,(ei-si));
         }
         System.out.println(len);
         
         

         

    }
}
