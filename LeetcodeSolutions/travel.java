public class travel{

  public static void main(String[] args) {
    int[][] result = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

    int x= 0;
    int y = 0;
    int dx = 1;
    int dy = 1;

    int rows = result.length;
    int cols = result[0].length;

    int total = rows*cols;

    for(int i = 0 ; i< total;i++){

        System.out.print(result[y][x] + "\t");
        if(!(x < x+ dx && x+dx < cols) || !(y < y+dy && y+dy <= rows) ){
          x = 0 ;
          y += dy; 
          System.out.println();
          continue;
        }

        x += dx;
    }



  }

}
