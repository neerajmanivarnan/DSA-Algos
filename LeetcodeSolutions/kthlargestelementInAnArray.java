class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());


        for(int num:nums){
            q.add(num);
        }

        int maxVal= 0;

        for(int i=0;i<k;i++){
            maxVal =  q.poll();
        }

        return maxVal;

    }
}
