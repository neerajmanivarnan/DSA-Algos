class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];

        Arrays.fill(array,amount+1);

        array[0]  = 0;

        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(coin <= i){
                    array[i] = Math.min(array[i],array[i-coin]+1);
                }
            }
        }

        return array[amount] > amount?-1:array[amount];
        
    }
}
