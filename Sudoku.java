/**
 * File: Sudoku.java
 * Author: Li Jingwei
 * Date: December 1, 2015
 * Purpose: CSCI 1110, Assignment 10
 * 
 * Description: This program reads a Sudoku puzzle and outputs
 * a solution to it.
 */
import java.util.Scanner;

/**
 * This is the Sudoku class of the program containing all of the program code.
 * It implements the solution to a Sudoku puzzle.
 */
public class Sudoku {

	/**
	 * This method is called when the program starts running.
	 * It reads in a number of lines from the console, instantiate
	 * the calculation and output the result calculated.
	 */
	public static void main(String[] args) 
	{
		// Instantiate new scanner to read from the console.
		Scanner keyboard = new Scanner(System.in);
		
		// Create the 2D array to store the numbers.
		int[][] sudoku = new int[9][9];
		
		// Get the number from the console.
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9; x++)
			{
				sudoku[x][y] = keyboard.nextInt();
			}
		
		// Run the method.
		sudokuSol(sudoku, 0, 0);
		
		// Print out the result of the complete sudoku.
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9; x++)
			{
				System.out.print(sudoku[x][y]);
				
				// Judge if the number is the last one of the line.
				if ( x == 8 )
				{
					System.out.println();
				}
				else 
				{
					System.out.print(" ");
				}
			}	
	}

	// The method for backtracking recursion to solve the sudoku problem.
	public static boolean sudokuSol( int[][] sudoku, int x, int y)
	{
		// Check if the element is zero.
		if ( sudoku[x][y] == 0 )
		{
			// Define the range numbers.
			int m = 0;
			int n = 0;
						
			// Get the range of the coordinates.
			while ( !(m <= x && x < m + 3) )
			{
				m += 3;
			}
						
			while ( !(n <= y && y < n + 3))
			{
				n += 3;
			}
						
			// Define the array to check numbers in the grid.
			int[] grid = new int[9];
						
			// Create the boolean value and loop running time number.
			boolean valid = true;
			int runTime = 0;
			
			// Check the possible numbers.
			while ( runTime < 9 )
			{
				// Try the number.
				sudoku[x][y]++;
				
				// Loop through the small grids.
				for ( int p = n; p < n + 3; p++)
					for ( int q = m; q < m + 3; q++)
					{
						// Check the value inside the grid.
						for ( int i = 0; i < 9; i++)
						{
							// Check the value.
							if ( i + 1 == sudoku[q][p] )
							{
								grid[i]++;
							}
									
							// Check if one number is stored in two coordinates.
							if ( grid[i] >= 2 )
							{
								valid = false;
							}
						}
					}
						
				// Reset the values to zero in the array.
				for ( int i = 0; i < 9; i++)
				{
					grid[i] = 0;
				}
						
				// Check the horizontal direction numbers.
				for ( int q = 0; q < 9; q++)
					for ( int i = 0; i < 9; i++)
					{
						// Check the value.
						if ( i + 1 == sudoku[q][y] )
						{
							grid[i]++;
						}
								
						// Check if one number is stored in two coordinates.
						if ( grid[i] >= 2 )
						{
							valid = false;
						}
					}
						
				// Reset the values to zero in the array.
				for ( int i = 0; i < 9; i++)
				{
					grid[i] = 0;
				}
						
				// Check the vertical direction numbers.
				for ( int p = 0; p < 9; p++)
					for ( int i = 0; i < 9; i++)
					{
						// Check the value.
						if ( i + 1 == sudoku[x][p] )
						{
							grid[i]++;
						}
								
						// Check if one number is stored in two coordinates.
						if ( grid[i] >= 2 )
						{
							valid = false;
						}
					}
				
				// Reset the values to zero in the array.
				for ( int i = 0; i < 9; i++)
				{
					grid[i] = 0;
				}
				
				// Check if the number is not valid.
				if ( !(valid) )
				{
					runTime++;
					valid = true;
				}
				else 
				{
					if ( sudokuSol(sudoku, x, y) )
					{
						return true;
					}
					else 
					{
						runTime++;
					}
				}
			}
			
			// If all the numbers are checked and no one is valid, return false.
			sudoku[x][y] = 0;
			
			return false;
		}
		else
		{
			// Change into the next line if the coordinate is on the right edge.
			if ( x == 8 )
			{
				x = 0;
				y++;
				
				// Check if all the grids are filled.
				if ( y == 9 )
				{
					return true;
				}
				else
				{
					if (sudokuSol(sudoku, x, y))
					{
						return true;
					}
					else 
					{
						return false;
					}
				}
			}
			else
			{
				x++;
				
				if (sudokuSol(sudoku, x, y))
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
		}
	}
}
