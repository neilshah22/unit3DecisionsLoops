import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.Scanner;
/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 5 rows and 5 columns
    private final int ROWS = 5;
    private final int COLS = 5;
    
    private boolean testing = false;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife(boolean testing)
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        this.testing = testing;

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // constants for the location of the three cells initially alive
        final int X1 = 0, Y1 = 0;
        final int X2 = 1, Y2 = 1;
        final int X3 = 2, Y3 = 2;
        final int X4 = 3, Y4 = 3;
        final int X5 = 4, Y5 = 4;
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Scanner in = new Scanner(System.in);
        int scan = 0;
        if (testing) {
            scan = 1;
        } else {
            System.out.println("Please enter a number (1-3): ");
            scan = in.nextInt();
        }
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
        if (scan == 1)
        {
            Rock rock1 = new Rock();
            Location loc1 = new Location(Y1, X1);
            grid.put(loc1, rock1);

            Rock rock2 = new Rock();
            Location loc2 = new Location(Y2, X2);
            grid.put(loc2, rock2);

            Rock rock3 = new Rock();
            Location loc3 = new Location(Y3, X3);
            grid.put(loc3, rock3);

            Rock rock4 = new Rock();
            Location loc4 = new Location(Y4, X4);
            grid.put(loc4, rock4);

            Rock rock5 = new Rock();
            Location loc5 = new Location(Y5, X5);
            grid.put(loc5, rock5);

            world.show();
        }

        if (scan == 2)
        {
            Rock rock1 = new Rock();
            Location loc1 = new Location(Y1, X3);
            grid.put(loc1, rock1);

            Rock rock2 = new Rock();
            Location loc2 = new Location(Y2, X2);
            grid.put(loc2, rock2);

            Rock rock3 = new Rock();
            Location loc3 = new Location(Y2, X4);
            grid.put(loc3, rock3);

            Rock rock4 = new Rock();
            Location loc4 = new Location(Y3, X1);
            grid.put(loc4, rock4);

            Rock rock5 = new Rock();
            Location loc5 = new Location(Y3, X5);
            grid.put(loc5, rock5);

            Rock rock6 = new Rock();
            Location loc6 = new Location(Y4, X2);
            grid.put(loc6, rock6);

            Rock rock7 = new Rock();
            Location loc7 = new Location(Y4, X4);
            grid.put(loc7, rock7);

            Rock rock8 = new Rock();
            Location loc8 = new Location(Y5, X3);
            grid.put(loc8, rock8);

            world.show();
        }
        
        if (scan == 3)
        {
                Rock rock1 = new Rock();
                Location loc1 = new Location(Y1, X1);
                grid.put(loc1, rock1);
                
                Rock rock2 = new Rock();
                Location loc2 = new Location(Y2, X5);
                grid.put(loc2, rock2);
                
                Rock rock3 = new Rock();
                Location loc3 = new Location(Y4, X2);
                grid.put(loc3, rock3);
                
                Rock rock4 = new Rock();
                Location loc4 = new Location(Y4, X3);
                grid.put(loc4, rock4);
                
                Rock rock5 = new Rock();
                Location loc5 = new Location(Y5, X3);
                grid.put(loc5, rock5);
                
                Rock rock6 = new Rock();
                Location loc6 = new Location(Y5, X4);
                grid.put(loc6, rock6);
                
                world.show();
        }
        
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        Grid<Actor> grid = world.getGrid();
        BoundedGrid<Actor> grid2 = new BoundedGrid<Actor>(ROWS, COLS);
        // create the grid, of the specified size, that contains Actors
        for(int rows = 0; rows < ROWS; rows++)
        {     
            for( int cols = 0; cols < COLS; cols++)
            {
                int neighbors = grid.getNeighbors(new Location(rows, cols)).size();
                if(neighbors == 3)
                {
                    grid2.put(new Location(rows, cols), new Rock());
                }
                else if(neighbors == 2 && getActor(rows, cols) != null)
                {
                    grid2.put(new Location(rows, cols), new Rock());
                }

            }
        }
        world.setGrid(grid2);
        world.show();
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)throws InterruptedException
    {
        GameOfLife game = new GameOfLife(false);
        for (int i = 0; i < 3; i++)
        {
            Thread.sleep(1000);
            game.createNextGeneration();
        }
    }

}

