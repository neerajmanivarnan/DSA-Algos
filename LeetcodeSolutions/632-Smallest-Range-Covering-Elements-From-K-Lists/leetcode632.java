import java.util.*;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE; 
        int rangeStart = 0; 
        int rangeEnd = Integer.MAX_VALUE; 
        
        
        for (int i = 0; i < nums.size(); i++) {
            if (!nums.get(i).isEmpty()) {
                minHeap.offer(new Node(nums.get(i).get(0), i, 0)); 
                max = Math.max(max, nums.get(i).get(0));
            }
        }
        
        
        while (minHeap.size() == nums.size()) {
            Node node = minHeap.poll(); 
            int min = node.value; 
            
            
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }
            
            
            if (node.elementIndex + 1 < nums.get(node.listIndex).size()) {
                int nextValue = nums.get(node.listIndex).get(node.elementIndex + 1);
                minHeap.offer(new Node(nextValue, node.listIndex, node.elementIndex + 1));
                max = Math.max(max, nextValue); 
            }
        }
        
        return new int[]{rangeStart, rangeEnd}; 
    }
    
    
    private static class Node {
        int value;
        int listIndex;
        int elementIndex;

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

}

