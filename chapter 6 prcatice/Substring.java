import java.util.Scanner;
public class Substring
{
    public static void substring()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = s.next();
       
        
       for( int length = 1;
            length <= word.length();
            length++)
        {
            for (int pos = 0;
                pos <= word.length() - length;
                pos++)
                {
                    System.out.println(word.substring(pos, pos + length));
                  
                }
       }
    }
}
