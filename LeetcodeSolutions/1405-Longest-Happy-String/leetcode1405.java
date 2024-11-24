import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);

        
        if (a > 0) {
            maxHeap.offer(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.offer(new Pair('b', b));
        }
        if (c > 0) {
            maxHeap.offer(new Pair('c', c));
        }

        StringBuilder result = new StringBuilder();

        
        while (!maxHeap.isEmpty()) {
            Pair first = maxHeap.poll();

            
            int n = result.length();
            if (n >= 2 && result.charAt(n - 1) == first.ch && result.charAt(n - 2) == first.ch) {
                
                if (maxHeap.isEmpty()) {
                    break;  
                }
                
                Pair second = maxHeap.poll();
                result.append(second.ch);
                second.count--;
                
                
                if (second.count > 0) {
                    maxHeap.offer(second);
                }
                
                maxHeap.offer(first);
            } else {
                
                result.append(first.ch);
                first.count--;

                
                if (first.count > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return result.toString();
    }

    
    private static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}

