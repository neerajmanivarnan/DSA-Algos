public class zerooneknap {
				
		public static void main(String args[]){
			int[] wt = {1,2,3,4,5,6};	
			int[] val = {7,3,2,9,5,2};

			System.out.println(knapsack(wt,val,10,5));

		}

		public static int knapsack(int[] wt,int[] val,int W,int n){
			if(n == 0 | W == 0) return 0;

			if(wt[n] <= W )return Math.max(val[n] + knapsack(wt,val,W-wt[n],n-1),knapsack(wt,val,W,n-1));
			return knapsack(wt,val,W,n-1);

		}
}
