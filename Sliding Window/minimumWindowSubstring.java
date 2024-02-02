import java.util.Scanner;

public class minimumWindowSubstring{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("String S:");
        String s = input.nextLine();
        System.out.println("String t:");
        String t = input.nextLine();
       
       
             minWindow(s,t);

    }
    public static void minWindow(String s, String t)
    {
        int ns = s.length(),nt = t.length();
        if(ns < nt) {
            // System.out.println();
            return;
        }

        int[] frq = new int[128];
        for(int i=0;i<nt;i++) frq[t.charAt(i)]++;

        int si = 0, ei = 0, count = nt, len = (int)1e9, gsi=0;

        while(ei<ns)
        {
            if(frq[s.charAt(ei)] > 0) count--;
            
            frq[s.charAt(ei)]--;
            ei++;

            while(count == 0)
            {
                if(ei - si < len)
                {
                    len = ei-si;
                    gsi = si;
                }

                if(frq[s.charAt(si)] == 0) count++;

                frq[s.charAt(si)]++;

                si++;
            }
        }
        System.out.println("Minimum String is"+(len == (int)1e9 ? "" : s.substring(gsi, gsi+len)));

    }
   

}