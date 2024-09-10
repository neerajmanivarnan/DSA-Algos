class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> newMap = new HashMap<>();


        for(int i=0;i<numbers.length;i++){
                int compliment = target-numbers[i];
                if(newMap.containsKey(compliment)){
                    return new int[]{newMap.get(compliment)+1,i+1};
                }

                newMap.put(numbers[i],i);
        }

        return new int[]{0};


    }
}
