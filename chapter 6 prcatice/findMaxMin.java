import java.util.Scanner;
public class findMaxMin
{
    public static double findMax()
    {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter a series of number or a character to quit: ");
        
        double largest = scan.nextDouble();
        while (scan.hasNextDouble())
        {
            double input = scan.nextDouble();
            if( input > largest )
            {
                largest = input;
            }
        }
        
        return largest; 
    }
    public static double findMin()
    {
        Scanner s = new Scanner( System.in );
        System.out.println( "Enter a series of number or a charater to quit: ");
        
        double smallest = s.nextDouble();
        while (s.hasNextDouble())
        {
            double input = s.nextDouble();
            if (input < smallest)
            {
                smallest = input;
            }
        }
        return smallest;
    }
}