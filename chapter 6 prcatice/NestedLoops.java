public class NestedLoops
{
    public static void NestedLoops()
    {

        for( int i = 1;
        i < 3;
        i++)
        {
            for( int z = 1;
            z <= 4;
            z++)
            {
                System.out.println( i + " " + z );
            }
        }
    }

    public static void NestedWhileLoops()
    {
        int z = 1;
        while(z <= 2)
        {
            int counter = 1;
            while (counter <= 4)
            {
                System.out.println( z + " " + counter);
                counter++;
            }
            z++;
        }
    }

    public static void NestedDoWhileLoops()
    {
        int z = 1; 
        do 
        {
            int counter =1;
            do
            {
                System.out.println(z + " " + counter);
                counter++;
            }
            while( counter <=4); 
            z++;    
        }
        while(z<=2);
        }
    }