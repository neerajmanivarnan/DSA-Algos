class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int total = rows*cols;

        for(int i = 0 ; i< total;i++){

            q.offer(matrix[y][x]);
             if(!(x < x+ dx && x+dx < cols) || !(y < y+dy && y+dy <= rows) ){
                 x = 0 ;
                 y += dy; 
                 System.out.println();
                 continue;
        }

        x += dx;
    }

    int minValue = 0 ;

    for(int i=0;i<k;i++){
        minValue = q.poll();
    }

    return minValue;

    }
}
