package newyearchaos;

import java.util.Scanner;

/**
 *
 * @author Slava
 * 
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
 *
 * There are n people queued up, and each person wears a sticker indicating their initial 
 * position in the queue (i.e.: 1, 2, ..., n-1, n) with the first number denoting 
 * the frontmost position).
 * 
 * Any person in the queue can bribe the person directly in front of them to swap positions. 
 * If two people swap positions, they still wear the same sticker denoting their original 
 * place in line. One person can bribe at most two other persons.
 * 
 * That is to say, if n=8 and Person 5 bribes Person 4, the queue will look like this: 
 * 1, 2, 3, 5, 4, 6, 7, 8.
 * 
 * Fascinated by this chaotic queue, you decide you must know the minimum number of 
 * bribes that took place to get the queue into its current state!
 * 
 * Note: Each Person X wears sticker X, meaning they were initially the Xth person in queue.
 * 
 * Input format
 * The first line contains an integer, T, denoting the number of test cases. 
 * Each test case is comprised of two lines; the first line has n (an integer indicating 
 * the number of people in the queue), and the second line has n space-separated 
 * integers describing the final state of the queue.
 * 
 * Constraints
 * 1<=T<=10
 * 1<=n<=10^5
 * 
 * Output format
 * Print an integer denoting the minimum number of bribes needed to get the queue 
 * into its final state; print Too chaotic if the state is invalid (requires Person X
 * to bribe more than 2 people).
 * 
 */
public class NewYearChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int[] result = new int[T];
  
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];

            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            
            result[a0] = getNumberOfBribestThroughBubbleSort(q);
        }
        
        for(int a1 = 0; a1 < result.length; a1++)
        {
            if(result[a1] == -1)
                System.out.println("Too chaotic");
            else
                System.out.println(result[a1]);
        }
    }
    
    private static int getNumberOfBribestThroughBubbleSort(int[] queue)
    {
        int result = 0;
        boolean swapped = false;
        
        do
        {
            swapped = false;
            
            for(int i = 1; i < queue.length; i++)
            {
                if(queue[i - 1] - i > 2)
                    return -1;
                
                if(queue[i - 1] > queue[i])
                {
                    //swap elements
                    int cache = queue[i];
                    queue[i] = queue[i - 1];
                    queue[i - 1] = cache;
                    
                    swapped = true;
                    result++;
                }
            }
        }
        while(swapped);
        
        return result;
    }
}
