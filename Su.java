import java.util.Scanner;
public class Su {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kbd = new Scanner(System.in);
		int[][] su = new int[9][9];
		int[] num = new int[9];
		int least = 10;
		
		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
			{
				su[y][x] = kbd.nextInt();
			}
		
		int[][][] pos = new int[9][9][9];
		
		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
			{
				if ( su[y][x] == 0 )
				{
					int m = 0;
					int n = 0;
					while ( su[y][x] < 9 )
					{
						su[y][x]++;
						
						while ( y > 3 * m + 2 )
						{
							m++;
						}
						while ( x > 3 * n + 2 )
						{
							n++;
						}
					
						boolean valid = true;
					
						for ( int p = 3 * m; p < 3 * m + 3; p++)
							for ( int q = 3 * n; q < 3 * n + 3; q++)
								for ( int i = 0; i < 9; i++)
								{
									if ( su[p][q] == i + 1 )
									{
										num[i]++;
									}
									
									if ( num[i] >= 2 )
									{
										valid = false;
									}
								}
						
						for ( int i = 0; i < 9; i++)
						{
							num[i] = 0;
						}
						
						for ( int p = 0; p < 9; p++)
							for ( int i = 0; i < 9; i++)
							{
								if ( su[p][x] == i + 1 )
								{
									num[i]++;
								}
								
								if ( num[i] >= 2 )
								{
									valid = false;
								}
							}
					
						for ( int i = 0; i < 9; i++)
						{
							num[i] = 0;
						}
						
						for ( int q = 0; q < 9; q++)
							for ( int i = 0; i < 9; i++)
							{
								if ( su[y][q] == i + 1 )
								{
									num[i]++;
								}
								
								if ( num[i] >= 2 )
								{
									valid = false;
								}
							}
						
						for ( int i = 0; i < 9; i++)
						{
							num[i] = 0;
						}
						
						if ( valid )
						{
							int i = 0;
							while ( pos[y][x][i] != 0 )
							{
								i++;
							}
							pos[y][x][i] = su[y][x];
						}
					}
					
					su[y][x] = 0;
				}
			}
		
		int i = 0;
		
		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
			{
				if ( pos[y][x][i] == 0 )
				{
					su[y][x] = 0;
				}
				else 
				{
					while ( pos[y][x][i] != 0 )
					{
						i++;
					}
					
					su[y][x] = i;
					
					i = 0;
				}
			}
		
		int leaX = 0;
		int leaY = 0;
		
		for (int x = 0; x < 9; x++)
			for (int y = 0; y < 9; y++)
			{
				if ( su[y][x] != 0 )
				{
					if ( least > su[y][x] )
					{
						least = su[y][x];
						leaX = x;
						leaY = y;
					}
				}
			}
		
		System.out.print("(" + (leaX + 1) + "," + (leaY + 1) + ")");
		
		i = 0;
		
		while ( pos[leaY][leaX][i] != 0 )
		{
			System.out.print(" " + pos[leaY][leaX][i]);
			i++;
		}
		
		System.out.println();
	}

}
