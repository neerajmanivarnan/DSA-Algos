class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
 	int availableGas = 0;
	int totalCost = 0 ;
	int start = -1;

	for(int i =0 ;i<gas.length;i++){
		availableGas += gas[i];
		totalCost += cost[i];


		if(gas[i] < cost[i]){
			start  = i+1;
		}
	}

	if(availableGas < totalCost) return -1;

	return start;
    }
}
