import java.util.Scanner;
import java.util.Arrays;

class SWEA_Flatten
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
        final int width = 100;

        for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
            int[] heights = new int[width];
            for(int i = 0; i < width; i++)
                heights[i] = sc.nextInt();
            
            Arrays.sort(heights);
            
            for(int i = 0; i < num; i++)
            {
                
                if (heights[width - 1] - heights[0] > 1) {
                    heights[0] += 1;
                    heights[width - 1] -= 1;
                } else {
                	break;
                }
            }
            
            Arrays.sort(heights);
            System.out.println("#" + test_case + " " + (heights[width - 1] - heights[0]));
		}
        
        sc.close();
	}
}
