package week4;

public class Knapsack {

    public static void main(String[] args) {
        int N = 4;
        int W = 7;

        int[] profit = {3,4,5,6};
        int[] weight = {2,3,4,5};

        // generate random instance, items 1..N
      

      
        int[][] opt = new int[N][W];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 0; n < N; n++) {
            for (int w = 0; w < W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n-1][w-weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) { take[n] = true;  w = w - weight[n]; }
            else           { take[n] = false;                    }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 0; n < N; n++) {
            System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
        }
    }
}