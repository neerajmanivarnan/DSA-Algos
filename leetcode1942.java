public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        
        int[][] guests = new int[n][3];
        for (int i = 0; i < n; i++) {
            guests[i][0] = times[i][0]; 
            guests[i][1] = times[i][1]; 
            guests[i][2] = i;           
        }

        
        Arrays.sort(guests, Comparator.comparingInt(a -> a[0]));

        
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i); 
        }

        
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int arrival = guests[i][0];
            int leaving = guests[i][1];
            int guestIndex = guests[i][2];

            
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.add(occupiedChairs.poll()[1]); 
            }

            
            int chair = availableChairs.poll();

            
            if (guestIndex == targetFriend) {
                return chair;
            }

            
            occupiedChairs.add(new int[]{leaving, chair});
        }

        return -1; 
    }
}

