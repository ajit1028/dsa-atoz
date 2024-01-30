import java.util.Scanner;

public class maxvowelsubstrgivlen {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the String:");
        String str = input.nextLine();
        int k = input.nextInt();
        int len  = maxVowels(str,k);
        System.out.println(len);
        

    }
    public static boolean isVowel(Character ch)
    {
        return (ch=='a' || ch =='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch =='E' || ch=='I' || ch=='O' || ch=='U');
    }
    public static int maxVowels(String s, int k) {
        int n = s.length(),si=0,ei=0,vowelCount=0,maxVowelCount=0;
        
        while(ei<n)
        {
            if(isVowel(s.charAt(ei))) vowelCount++;
              
            ei++;
            
            if(ei-si==k)
            {
                maxVowelCount=Math.max(maxVowelCount,vowelCount);
                if(isVowel(s.charAt(si))) vowelCount--;
                 
                si++;
                   
            }
            
        }
        return maxVowelCount;
    }
}
