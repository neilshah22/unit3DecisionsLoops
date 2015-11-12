import java.util.Scanner;
public class Diamond
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number");
        int sideLength = s.nextInt();
        
        /* 
         * side length = 4
         * row      spaces      stars
         * 0        3           1
         * 1        2           3
         * 2        1           5
         * 3        0           7
         * 4        1           5
         * 5        2           
         */
        
        for( int row = sideLength - 2;
             row >= 0;
             row++)
        {
            for( int spaces = 0;
                 spaces < sideLength - row - 1;
                 spaces++)
            {
                System.out.print("");
            }
            
            for(    int stars = 0;
                    stars < row * 2 + 1;
                    stars++)
            {
                System.out.print("*");
            }
            System.out.print( "\n" );
            
            for(    int row = sideLength -2;
                    row >= 0;
                    row--)
            {
                System.out.print( "");
            }
            
            for(    int stars = 0;
                    stars < row * 2 + 1;
                    stars++)
            {
                System.out.print("*");
            }
            
            System.out.print( "\n" );
        }
    }
}

            